package LAB5_TPINTEGRADOR_GRUPO8.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 

//Controller con algunas acciones que son comunes a todas las vistas
@Controller
public class Utils {
	
	@RequestMapping("salir.html")
	public ModelAndView redireccionarAPrincipal() { 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Principal");
		return mv;
	}
}
