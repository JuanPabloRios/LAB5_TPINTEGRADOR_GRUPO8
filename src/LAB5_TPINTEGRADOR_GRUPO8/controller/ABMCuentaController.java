package LAB5_TPINTEGRADOR_GRUPO8.controller;
 
import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.dao.CuentaDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.TipoDeCuentaDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.UsuarioDao;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.service.CuentaService;

import java.util.List; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody; 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature; 
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario; 

@Controller
public class ABMCuentaController {
	
    //Convertimos la lista a JSON y la usamos en el modal para seleccionar el cliente
	@RequestMapping(value="obtenerClientes.html", method = RequestMethod.GET) 
	public @ResponseBody String obtenerClientes() throws JsonProcessingException  {  
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    List<Usuario> res = UsuarioDao.obtenerTodosLosClientes();
        return mapper.writeValueAsString(res);
    }
	 
	@RequestMapping("editCuenta.html")
    public ModelAndView editarCuenta(String nombreCuenta, Double saldo, String CBU, Date fechaCuenta, String tipoCuenta, Integer numeroCuenta) {
        ModelAndView mv = new ModelAndView(); 
        
        mv.addObject("nombreCuenta",nombreCuenta); 
        TiposDeCuentas tpCuentas = TipoDeCuentaDao.obtenerTipoCuentaPorNombre(tipoCuenta);
        
        String result = CuentaService.editarCuenta(numeroCuenta, saldo, tpCuentas ); 

        if(result.equalsIgnoreCase("OK")) {
			
	        mv.addObject("listaCuentas",CuentaDao.obtenerTodasLasCuentas()); 
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
