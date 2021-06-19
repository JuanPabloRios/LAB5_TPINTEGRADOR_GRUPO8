package LAB5_TPINTEGRADOR_GRUPO8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalController {
	@RequestMapping("redireccionar_Principal.html")
	public ModelAndView redireccionarAPrincipal() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Principal");
		return mv;
	}
	
	@RequestMapping("redirigirLogin.html")
	public ModelAndView redirigirAHome(String txtUsuario, String txtClave) {
		System.out.println("Usuario " + txtUsuario);
		System.out.println("Clave " + txtClave);
		//ACA VA LA BUSQUEDA DE USER Y PASS Y SEGUN RESULTADO REDIRIGE A ALGUN HOME O A ERROR
		
		
		
		//VOY A REDIRECCIONAR A LA PAGINA HOME DEL ADMIN POR AHORA
		ModelAndView mv = new ModelAndView();
		mv.addObject("nombreCuenta","Nombre y Apellido");
		mv.setViewName("AdministradorHome");
		return mv;
	} 
}
