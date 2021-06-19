package LAB5_TPINTEGRADOR_GRUPO8.controller;
import LAB5_TPINTEGRADOR_GRUPO8.data.creator.*; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView; 
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector;
import java.util.List;

@Controller
public class PrincipalController { 
	 
	@RequestMapping("redireccionar_Principal.html")
	public ModelAndView redireccionarAPrincipal() {
		DataCreator.createData();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Principal");
		return mv;
	}
	
	@RequestMapping("redirigirLogin.html")
	public ModelAndView redirigirAHome(String txtUsuario, String txtClave) {  
		System.out.println("txtUsuario "+ txtUsuario);
		System.out.println("txtClave "+ txtClave);
		Usuario us = UsuarioSelector.obtenerUsuarioPorNombreDeUsuario(txtUsuario);
		Boolean errorDeUsuario = false;
		if(us == null || us.getContrasenia() != txtClave) {
			errorDeUsuario = true;
		}  
		ModelAndView mv = new ModelAndView();
		if(errorDeUsuario) {
			mv.addObject("errorDeUsuario",true);
			mv.setViewName("Principal");
		} else {
			mv.addObject("nombreCuenta",us.getNombre() + " " + us.getApellido());
			mv.addObject("usuario",us);
			mv.setViewName("AdministradorHome");
		} 
		return mv;
	} 
}
