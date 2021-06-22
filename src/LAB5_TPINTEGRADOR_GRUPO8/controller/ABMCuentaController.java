package LAB5_TPINTEGRADOR_GRUPO8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector;

@Controller
public class ABMCuentaController {
	
	@RequestMapping("buscarCliente.html")
	public ModelAndView irABuscarCliente(String nombreCuenta) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta);  
        mv.setViewName("BuscarCliente");
        return mv;
    }
}
