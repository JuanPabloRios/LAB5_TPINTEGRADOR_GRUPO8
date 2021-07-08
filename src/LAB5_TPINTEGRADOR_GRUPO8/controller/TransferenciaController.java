package LAB5_TPINTEGRADOR_GRUPO8.controller; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import LAB5_TPINTEGRADOR_GRUPO8.dao.CuentaDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.UsuarioDao; 
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario; 
import LAB5_TPINTEGRADOR_GRUPO8.service.MovimientoService;

@Controller
public class TransferenciaController {
	
	@RequestMapping("transferenciaCuenta.html")
    public ModelAndView transferenciaCuentaPropia(String nombreCuenta, Integer idUsuario, Double Monto, Integer CuentaDestino, Integer CuentaOrigen, String cbu , RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta);  
        String result = MovimientoService.transferenciaCuenta( Monto, CuentaDestino, CuentaOrigen, cbu);
        Usuario us = UsuarioDao.obtenerUsuarioPorID(idUsuario);
        if(result.equalsIgnoreCase("OK")) {   
        	//Usamos redirectAttributes y un new ModelAndView para evitar el reenvio del formulario mas de una vez.
	        redirectAttributes.addFlashAttribute("informarTransferenciaExitosa",true); 
	        redirectAttributes.addAttribute("nombreCuenta", nombreCuenta); 
	        redirectAttributes.addAttribute("idUsuario", us.getIdusuario()); 
    	    return new ModelAndView("redirect:irAClienteHome.html"); 
        } else { 
            mv.addObject("nombreCuenta",nombreCuenta); 
            mv.addObject("cuentas", CuentaDao.obtenerTodasLasCuentasDeClientePorId(idUsuario));
            mv.addObject("cliente", UsuarioDao.obtenerUsuarioPorID(idUsuario));
        	mv.addObject("informarError",true);
        	mv.addObject("mensajeError",result); 
        	mv.setViewName("Transferencias"); 
        }  
        return mv;
    }
}