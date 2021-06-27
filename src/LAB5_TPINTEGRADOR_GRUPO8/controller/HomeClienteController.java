package LAB5_TPINTEGRADOR_GRUPO8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.selector.CuentaSelector;
import LAB5_TPINTEGRADOR_GRUPO8.selector.MovimientoSelector;
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector;

@Controller
public class HomeClienteController {
	//irAClienteHome.html
	@RequestMapping("irAClienteHome.html")
    public ModelAndView redirigirAHome(String nombreCuenta, Integer idUsuario) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        Usuario us = UsuarioSelector.obtenerUsuarioPorID(idUsuario);
        mv.addObject("usuario",us);
        mv.addObject("listaCuentas", CuentaSelector.obtenerTodasLasCuentasDeClientePorId(us.getIdusuario()));
        mv.setViewName("HomeCliente");
        return mv;
    }
	 
	@RequestMapping("irATransferencia.html")
    public ModelAndView redirigirATransferencia(String nombreCuenta, Integer idUsuario) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        mv.addObject("cuentas", CuentaSelector.obtenerTodasLasCuentasDeClientePorId(idUsuario));
        mv.addObject("cliente", UsuarioSelector.obtenerUsuarioPorID(idUsuario));
        mv.setViewName("Transferencias");
        return mv;
    }
	
	@RequestMapping("verMovimientosCuenta.html")
    public ModelAndView redirigirAVerMovimientos(String nombreCuenta, Integer idCuenta) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        mv.addObject("cuenta", CuentaSelector.obtenerCuentaPorId(idCuenta));
        mv.addObject("listarMovimientos",MovimientoSelector.obtenerTodosLosMovimientosDeClientePorId(idCuenta));//ACA IRIAN LOS MOVIMIENTOS DE LA CUENTA
        mv.setViewName("HistorialMovimientos");
        return mv;
    }
	
}
