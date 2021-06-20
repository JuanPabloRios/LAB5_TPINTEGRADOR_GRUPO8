package LAB5_TPINTEGRADOR_GRUPO8.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Controlador de la vista AdministradorHome
@Controller
public class AdministradorHomeController {

	@RequestMapping("editarCliente.html")
	public ModelAndView editarCliente(Integer idUsuario, String nombreCuenta) { 
		ModelAndView mv = new ModelAndView();
		mv.addObject("idUsuario",idUsuario);
		mv.addObject("nombreCuenta",nombreCuenta); 
		mv.setViewName("ACA VA LA VISTA DE EDITAR CLIENTE");
		return mv;
	}
	
	@RequestMapping("crearNuevoCliente.html")
	public ModelAndView crearNuevoCliente(String nombreCuenta) { 
		ModelAndView mv = new ModelAndView();
		mv.addObject("nombreCuenta",nombreCuenta);   
		mv.setViewName("ACA VA LA VISTA DE crear nuevo CLIENTE");
		return mv;
	}
	
	@RequestMapping("redirigirListadoCuentas.html")
	public ModelAndView redirigirAABMCuentas(String nombreCuenta) { 
		ModelAndView mv = new ModelAndView();  
		mv.addObject("nombreCuenta",nombreCuenta); 
		mv.setViewName("ACA VA LA VISTA DE LISTADO DE CUENTAS");
		return mv;
	}
	
}
