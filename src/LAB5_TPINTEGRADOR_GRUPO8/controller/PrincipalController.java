package LAB5_TPINTEGRADOR_GRUPO8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalController {
	
	@RequestMapping("redireccionar_pag2.html")
	public ModelAndView redireccionarAPagina2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pag2");
		return mv;
	}
	
	@RequestMapping("redireccionar_Principal.html")
	public ModelAndView redireccionarAPrincipal() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Principal");
		return mv;
	}
}
