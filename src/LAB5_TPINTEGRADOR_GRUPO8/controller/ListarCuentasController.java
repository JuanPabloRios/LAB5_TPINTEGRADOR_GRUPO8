package LAB5_TPINTEGRADOR_GRUPO8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.data.creator.DataCreator;
import LAB5_TPINTEGRADOR_GRUPO8.selector.CuentaSelector;

@Controller
public class ListarCuentasController {
	
	@RequestMapping("redireccionarANuevaCuenta.html")
	public ModelAndView redireccionarANuevaCuenta(String nombreCuenta) {
		DataCreator.createData();
		ModelAndView mv = new ModelAndView();
		mv.addObject("nombreCuenta",nombreCuenta);
		mv.setViewName("ABMCuenta");
		return mv;
	}
	
	@RequestMapping("editarCuenta.html")
	public ModelAndView redireccionarAEditarCuenta(String nombreCuenta, Integer idCuenta) {
		DataCreator.createData();
		ModelAndView mv = new ModelAndView(); 
		mv.addObject("cuenta", CuentaSelector.obtenerCuentaPorId(idCuenta)  );
		mv.addObject("nombreCuenta",nombreCuenta);
		mv.setViewName("ABMCuenta");
		return mv;
	}
}
