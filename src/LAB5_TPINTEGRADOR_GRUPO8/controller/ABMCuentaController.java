package LAB5_TPINTEGRADOR_GRUPO8.controller;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.selector.CuentaSelector;
import LAB5_TPINTEGRADOR_GRUPO8.selector.TipoDeCuentaSelector;
import LAB5_TPINTEGRADOR_GRUPO8.service.CuentaService;

@Controller
public class ABMCuentaController {
	
	@RequestMapping("buscarCliente.html")
	public ModelAndView irABuscarCliente(String nombreCuenta) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta);  
        mv.setViewName("BuscarCliente");
        return mv;
    }
	
	
	
	
	  @RequestMapping("editCuenta.html")
	    public ModelAndView editarCuenta(String nombreCuenta, Double saldo, String CBU, Date fechaCuenta, String tipoCuenta, Integer numeroCuenta) {
	        ModelAndView mv = new ModelAndView(); 
	        
	        mv.addObject("nombreCuenta",nombreCuenta); 
	        TiposDeCuentas tpCuentas = TipoDeCuentaSelector.obtenerTipoCuentaPorNombre(tipoCuenta);
	        
	        String result = CuentaService.editarCuenta(numeroCuenta, saldo, tpCuentas ); 

	        if(result.equalsIgnoreCase("OK")) {
				
		        mv.addObject("listaCuentas",CuentaSelector.obtenerTodasLasCuentas()); 
		        mv.addObject("informarCuentaEditada",true);
		        mv.addObject("nombreCuenta",nombreCuenta); 
		        mv.setViewName("ListarCuentas");
	        } else {
	        	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class); 
	        	Cuentas cuenta = (Cuentas)appContext.getBean("cuenta"); 
	        	
	        	cuenta.setSaldo(saldo);;
	        	cuenta.setCBU(CBU);
	        	cuenta.setTipoCuenta(tpCuentas);
	        	cuenta.setFechaCreacion(fechaCuenta);
	        	
	        	
	        	mv.addObject("cliente",cuenta);
	        	mv.addObject("informarError",true);
	        	mv.addObject("mensajeError",result); 
	        	mv.setViewName("ABMCuenta"); 
	        	((ConfigurableApplicationContext)appContext).close();
	        }  
			
			
	        return mv;
	    }
	
	
	
}
