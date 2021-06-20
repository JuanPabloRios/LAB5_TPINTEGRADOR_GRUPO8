package LAB5_TPINTEGRADOR_GRUPO8.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Controlador de la vista AdministradorHome
@Controller
public class AdministradorHomeController {

	@RequestMapping("editarCliente.html")
	public ModelAndView editarCliente(Integer idUsuario) { 
		ModelAndView mv = new ModelAndView();
		mv.addObject("idUsuario",idUsuario);
		System.out.println("Id Cliente seleccionado " + idUsuario);
		mv.setViewName("ACA VA LA VISTA DE EDITAR CLIENTE");
		return mv;
	}
	
	@RequestMapping("crearNuevoCliente.html")
	public ModelAndView crearNuevoCliente() { 
		ModelAndView mv = new ModelAndView();  
		mv.setViewName("ACA VA LA VISTA DE crear nuevo CLIENTE");
		return mv;
	}
	
	@RequestMapping("redirigirABMCuentas.html")
	public ModelAndView redirigirAABMCuentas() { 
		ModelAndView mv = new ModelAndView();  
		mv.setViewName("ACA VA LA VISTA DE ABM CUENTAS");
		return mv;
	}
	
}
