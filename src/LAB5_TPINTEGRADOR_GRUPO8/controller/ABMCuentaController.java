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
import LAB5_TPINTEGRADOR_GRUPO8.service.UsuarioService;

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
	
    @RequestMapping("eliminarCuenta.html")
    public ModelAndView eliminarCuenta(Integer idNroDeCuenta) {
        ModelAndView mv = new ModelAndView(); 
        CuentaService.eliminarCuentaPorId(idNroDeCuenta); 
		mv.addObject("listaCuentas",CuentaDao.obtenerTodasLasCuentas()); 
        mv.addObject("informarEliminadoCorrecto",true);
		mv.setViewName("AdministradorHome");
        return mv;
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
        	
        	cuenta.setSaldo(saldo);
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



//guardarCuenta.html 
@RequestMapping("guardarCuenta.html")
public ModelAndView guardarCuenta(Integer idUsuario, String nombreCuenta, Double saldo, String CBU, Date fechaCuenta, String tipoCuenta, Integer numeroCuenta ) {
    ModelAndView mv = new ModelAndView(); 
    mv.addObject("nombreCuenta",nombreCuenta);
    TiposDeCuentas tpCuentas = TipoDeCuentaDao.obtenerTipoCuentaPorNombre(tipoCuenta);
  
    
    ///Aca seria necesario 1ero chequear el limite de 4 cuentas y si se puede traer traer un numero de cuenta y un CBU
    ///fijarse en la BD el ultimo numero de cuenta y cbu y agregarles 1, y si no hay ninguna cuenta crear un CBU (podrian ser 11 ceros y un 1 )
    
    String validacion1= CuentaService.limiteCuentas(idUsuario);
    
    if() {
    	
    }
    
    
    
    
    
	String result = CuentaService.crearCuenta(saldo, CBU,fechaCuenta, tpCuentas, numeroCuenta,idUsuario );
   
    if(result.equalsIgnoreCase("OK")) {
    	mv.addObject("informarCuentaCreada",true);
    	mv.addObject("listaCuentas",CuentaDao.obtenerTodasLasCuentas()); 
    	 mv.addObject("nombreCuenta",nombreCuenta); 
    	mv.setViewName("ListarCuentas");
    } else {
    	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class); 
    	Cuentas cuenta = (Cuentas)appContext.getBean("cuenta"); 
    	
    	cuenta.setSaldo(saldo);
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
