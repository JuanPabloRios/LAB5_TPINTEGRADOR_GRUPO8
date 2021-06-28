package LAB5_TPINTEGRADOR_GRUPO8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.dao.CuentaDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.MovimientoDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.UsuarioDao;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;

@Controller
public class HomeClienteController {
	//irAClienteHome.html
	@RequestMapping("irAClienteHome.html")
    public ModelAndView redirigirAHome(String nombreCuenta, Integer idUsuario) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        Usuario us = UsuarioDao.obtenerUsuarioPorID(idUsuario);
        mv.addObject("usuario",us);
        mv.addObject("listaCuentas", CuentaDao.obtenerTodasLasCuentasDeClientePorId(us.getIdusuario()));
        mv.setViewName("HomeCliente");
        return mv;
    }
	 
	@RequestMapping("irATransferencia.html")
    public ModelAndView redirigirATransferencia(String nombreCuenta, Integer idUsuario) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        mv.addObject("cuentas", CuentaDao.obtenerTodasLasCuentasDeClientePorId(idUsuario));
        mv.addObject("cliente", UsuarioDao.obtenerUsuarioPorID(idUsuario));
        mv.setViewName("Transferencias");
        return mv;
    }
	
	@RequestMapping("verMovimientosCuenta.html")
    public ModelAndView redirigirAVerMovimientos(String nombreCuenta, Integer idCuenta) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        mv.addObject("cuenta", CuentaDao.obtenerCuentaPorId(idCuenta));
        mv.addObject("listarMovimientos",MovimientoDao.obtenerTodosLosMovimientosDeClientePorId(idCuenta));//ACA IRIAN LOS MOVIMIENTOS DE LA CUENTA
        mv.setViewName("HistorialMovimientos");
        return mv;
    }
	
}
