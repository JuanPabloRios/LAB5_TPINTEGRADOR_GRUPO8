package LAB5_TPINTEGRADOR_GRUPO8.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.selector.CuentaSelector;
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector;
import LAB5_TPINTEGRADOR_GRUPO8.service.MovimientoService;

public class TransferenciaController {
	
	
	
	@RequestMapping("transferenciaCuenta.html")
    public ModelAndView transferenciaCuentaPropia(String nombreCuenta, Integer idUsuario, Double Monto, Integer CuentaDestino, Integer CuentaOrigen, String cbu ) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        System.out.println("TODOS LOS DATOS SOLICITADOS  " + idUsuario+" "+Monto +" "+CuentaDestino +" "+CuentaOrigen +" "+cbu );
        String result = MovimientoService.transferenciaCuenta(idUsuario, Monto, CuentaDestino, CuentaOrigen, cbu);
        System.out.println("RESULT " + result);

        Usuario us = UsuarioSelector.obtenerUsuarioPorID(idUsuario);
        mv.addObject("usuario",us);
        mv.addObject("listaCuentas", CuentaSelector.obtenerTodasLasCuentasDeClientePorId(us.getIdusuario()));
        mv.setViewName("HomeCliente");
        return mv;
    }
}
