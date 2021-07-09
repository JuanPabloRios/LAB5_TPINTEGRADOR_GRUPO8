package LAB5_TPINTEGRADOR_GRUPO8.controller; 
import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import LAB5_TPINTEGRADOR_GRUPO8.dao.CuentaDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.UsuarioDao;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Localidad;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.service.LocalidadService;
import LAB5_TPINTEGRADOR_GRUPO8.service.UsuarioService;

@Controller
public class ABMClienteController {

    @RequestMapping("redirigirListadoClientes.html")
    public ModelAndView irAListadoClientes(String nombreCuenta) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        mv.addObject("listaClientes",UsuarioDao.obtenerTodosLosClientes());
        mv.setViewName("AdministradorHome");
        return mv;
    }

    @RequestMapping("redirigirListadoCuentasAdmin.html")
    public ModelAndView isAListadoCuentas(String nombreCuenta) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta);
        //ACA BUSCAR TODAS LAS CUENTAS Y AGREGARLAS AL MODELO
        mv.setViewName("ACA VA EL NOMBRE DE LA VISTA PARA LISTAR CUENTAS");
        return mv;
    }

    //eliminarCliente.html nombreCuenta y idUsuario
    
    @RequestMapping("eliminarCliente.html")
    public ModelAndView eliminarCliente(String nombreCuenta, Integer idUsuario) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta);
        UsuarioService.eliminarUsuarioPorId(idUsuario); 
		mv.addObject("listaClientes",UsuarioDao.obtenerTodosLosClientes()); 
        mv.addObject("informarEliminadoCorrecto",true);
		mv.setViewName("AdministradorHome");
        return mv;
    }
    
    //guardarCliente.html 
    @RequestMapping("guardarCliente.html")
    public ModelAndView guardarCliente(String nombreCuenta, String nombreCliente, String apellidoCliente, Integer dniCliente, Date fechaNacimientoCliente, 
    									String nacionalidadCliente, String direccionCliente, String sexoCliente, String provinciaCliente, Integer localidadCliente,
    									String nombreUsuario, String contrasenia, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("nombreCuenta",nombreCuenta); 
        String result = UsuarioService.crearUsuario(nombreCliente, apellidoCliente, dniCliente, fechaNacimientoCliente, 
				nacionalidadCliente, direccionCliente, sexoCliente, provinciaCliente, localidadCliente,
				nombreUsuario, contrasenia);
        Localidad loc = LocalidadService.obtenerLocalidadPorId(localidadCliente);
        if(result.equalsIgnoreCase("OK")) { 
        	redirectAttributes.addFlashAttribute("informarUsuarioCreado", true);  
    	    return new ModelAndView("redirect:regirigirAListadoDeClientes.html");
        } else {
        	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class); 
        	Usuario cliente = (Usuario)appContext.getBean("UsuarioCliente"); 
        	cliente.setNombre(nombreCliente);
        	cliente.setApellido(apellidoCliente);
        	cliente.setContrasenia(contrasenia);
        	cliente.setUsuario(nombreUsuario);   
        	cliente.setDireccion(direccionCliente);
        	cliente.setDNI(dniCliente); 
        	cliente.setNacionalidad(nacionalidadCliente);
        	cliente.setSexo(sexoCliente);
        	cliente.setLocalidad(loc); 
        	cliente.setFecha_de_nacimiento(fechaNacimientoCliente); 
        	mv.addObject("cliente",cliente);
        	mv.addObject("informarError",true);
        	mv.addObject("mensajeError",result); 
        	mv.setViewName("ABMCliente"); 
        	((ConfigurableApplicationContext)appContext).close();
        	return mv;
        }   
    }
     
    @RequestMapping("editCliente.html")
    public ModelAndView editarCliente(String nombreCuenta,Integer idUsuario, String nombreCliente, String apellidoCliente, Integer dniCliente, Date fechaNacimientoCliente, 
										String nacionalidadCliente, String direccionCliente, String sexoCliente, String provinciaCliente, Integer localidadCliente,
										String nombreUsuario, String contrasenia) {
        ModelAndView mv = new ModelAndView(); 
        
        mv.addObject("nombreCuenta",nombreCuenta); 

        List<Cuentas> cu = CuentaDao.obtenerTodasLasCuentasDeClientePorId(idUsuario);
        Localidad loc = LocalidadService.obtenerLocalidadPorId(localidadCliente);
        String result = UsuarioService.editarUsuario(idUsuario, nombreCliente, apellidoCliente, dniCliente, fechaNacimientoCliente, 
				nacionalidadCliente, direccionCliente, sexoCliente, provinciaCliente, localidadCliente,
				nombreUsuario, contrasenia); 
        
        if(result.equalsIgnoreCase("OK")) {
			mv.addObject("listaClientes",UsuarioDao.obtenerTodosLosClientes());
	        mv.addObject("informarUsuarioEditado",true);
			mv.setViewName("AdministradorHome");
			
        } else {
        	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class); 
        	Usuario cliente = (Usuario)appContext.getBean("UsuarioCliente"); 
        	cliente.setNombre(nombreCliente);
        	cliente.setApellido(apellidoCliente);
        	cliente.setContrasenia(contrasenia);
        	cliente.setUsuario(nombreUsuario);   
        	cliente.setDireccion(direccionCliente);
        	cliente.setDNI(dniCliente); 
        	cliente.setNacionalidad(nacionalidadCliente);
        	cliente.setLocalidad(loc); 
        	cliente.setSexo(sexoCliente);
        	cliente.setFecha_de_nacimiento(fechaNacimientoCliente);  
        	mv.addObject("listaCuentas",cu);
        	mv.addObject("cliente",cliente);
        	mv.addObject("informarError",true);
        	mv.addObject("mensajeError",result); 
        	mv.setViewName("ABMCliente"); 
        	((ConfigurableApplicationContext)appContext).close();
        }  
		
		
        return mv;
    }
    
    
}