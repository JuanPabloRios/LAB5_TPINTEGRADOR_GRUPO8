package LAB5_TPINTEGRADOR_GRUPO8.service; 
import LAB5_TPINTEGRADOR_GRUPO8.dao.TipoDeUsuarioDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.UsuarioDao;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Localidad;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate;

import java.sql.Date;  
import java.util.List; 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext; 

public class UsuarioService {
	
    public static void eliminarUsuarioPorId(Integer idUsuario){ 
    	Usuario usuario = UsuarioDao.obtenerUsuarioPorID(idUsuario);     	
	    UsuarioDao.eliminarUsuario(usuario);
	    CuentaService.eliminarTodasLasCuentasDeClientePorId(idUsuario);
    }	
    
    //FALTA AGREGAR EL CAMPO DE LOCALIDAD Y PROVINCIA
    public static String crearUsuario(String nombreCliente, String apellidoCliente, Integer dniCliente, Date fechaNacimientoCliente, 
    	String nacionalidadCliente, String direccionCliente, String sexoCliente, String provinciaCliente, Integer localidadCliente,
		String nombreUsuario, String contrasenia){ 
	Boolean existeN = UsuarioService.existeNombreUsuario(nombreUsuario);
    	Boolean existeD = UsuarioService.existeDNI(dniCliente); 
	    	if(!existeN && !existeD) {
	    		Localidad loc = LocalidadService.obtenerLocalidadPorId(localidadCliente);
	    		
	    		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class); 
	            Usuario us = (Usuario)appContext.getBean("UsuarioCliente"); 
	            us.setTipoDeUsuario(TipoDeUsuarioDao.obtenerTipoUsuarioPorNombre("Cliente"));
	            us.setNombre(nombreCliente);
	            us.setApellido(apellidoCliente);
	            us.setContrasenia(contrasenia);
	            us.setUsuario(nombreUsuario);   
	            us.setDireccion(direccionCliente);
	            us.setDNI(dniCliente); 
	            us.setNacionalidad(nacionalidadCliente);
	            us.setSexo(sexoCliente);
	            us.setFecha_de_nacimiento(fechaNacimientoCliente);  
	            us.setLocalidad(loc);
	            UsuarioDao.insertarUsuario(us);
	        	((ConfigurableApplicationContext)appContext).close();
	        	return "OK";
	    	} else if(existeN == true) {
	    		return "El Nombre de Usuario ingresado ya existe";
	    	} else if(existeD == true) {
	    		return "El DNI ingresado ya existe";
	    	}
    }
    
    
    //FALTA AGREGAR LOCALIDAD Y PROVINCIA
    public static String editarUsuario(Integer idUsuario, String nombreCliente, String apellidoCliente, Integer dniCliente, Date fechaNacimientoCliente, 
			String nacionalidadCliente, String direccionCliente, String sexoCliente, String provinciaCliente, Integer localidadCliente,
			String nombreUsuario, String contrasenia){ 
		Boolean existeN = UsuarioService.existeNombreUsuario(nombreUsuario);
    		Boolean existeD = UsuarioService.existeDNI(dniCliente); 
    		Usuario us = UsuarioDao.obtenerUsuarioPorID(idUsuario); 
    		Localidad loc = LocalidadService.obtenerLocalidadPorId(localidadCliente);
	    	if(!existeN && !existeD) { 
		    	if(!us.getNombre().contains(nombreCliente)) { 
		    		us.setNombre(nombreCliente);
		    	}
		    	if(!us.getApellido().contains(apellidoCliente)) {
		    		us.setApellido(apellidoCliente);
		    	}
		    	
		    	if(!us.getContrasenia().contains(contrasenia)) {
		    		us.setContrasenia(contrasenia);
		    	}
		    	if(!us.getUsuario().contains(nombreUsuario)) {
		    		us.setUsuario(nombreUsuario);
		    	}
		    	
		    	if(us.getDireccion() != direccionCliente) {
		    		us.setDireccion(direccionCliente);
		    	}
		    	if(us.getDNI() != dniCliente) {
		    		us.setDNI(dniCliente);
		    	}
		    	if(!us.getNacionalidad().contains(nacionalidadCliente)) {   	    
		    		us.setNacionalidad(nacionalidadCliente);
		    	}
		    	if(!us.getSexo().contains(sexoCliente)) {    	    
		    		us.setSexo(sexoCliente);
		    	}
		    	if(!us.getFecha_de_nacimiento().equals(fechaNacimientoCliente)) {
		    		us.setFecha_de_nacimiento(fechaNacimientoCliente);  
		    	}
		    	if(us.getLocalidad().getIdLocalidad() != loc.getIdLocalidad()) {    	    
		    		us.setLocalidad(loc);
		    	}
		    	UsuarioDao.actualizarUsuario(us); 
	        	return "OK";
	    	} else if(us.getUsuario().contains(nombreUsuario) || us.getDNI() == dniCliente) {
		    	if(!us.getNombre().contains(nombreCliente)) { 
		    		us.setNombre(nombreCliente);
		    	}
		    	if(!us.getApellido().contains(apellidoCliente)) {
		    		us.setApellido(apellidoCliente);
		    	}
		    	
		    	if(!us.getContrasenia().contains(contrasenia)) {
		    		us.setContrasenia(contrasenia);
		    	}
		    	if(!us.getUsuario().contains(nombreUsuario)) {
		    		us.setUsuario(nombreUsuario);
		    	}
		    	
		    	if(us.getDireccion() != direccionCliente) {
		    		us.setDireccion(direccionCliente);
		    	}
		    	if(us.getDNI() != dniCliente) {
		    		us.setDNI(dniCliente);
		    	}
		    	if(!us.getNacionalidad().contains(nacionalidadCliente)) {   	    
		    		us.setNacionalidad(nacionalidadCliente);
		    	}
		    	if(!us.getSexo().contains(sexoCliente)) {    	    
		    		us.setSexo(sexoCliente);
		    	}
		    	if(!us.getFecha_de_nacimiento().equals(fechaNacimientoCliente)) {
		    		us.setFecha_de_nacimiento(fechaNacimientoCliente);  
		    	} 
		    	if(us.getLocalidad().getIdLocalidad() != loc.getIdLocalidad()) {    	    
		    		us.setLocalidad(loc);
		    	}
		    	UsuarioDao.actualizarUsuario(us); 
	        	return "OK";
	    	} else if(existeN == true) {
	    		return "El Nombre de Usuario ingresado ya existe";
	    	} else if(existeD == true) {
	    		return "El DNI ingresado ya existe";
	    	}
    }	

  //Busca si existe el nombre de usuario en la lista USUARIOS, DEVUELVE true si hay una copia y false si no la hay.
    public static Boolean existeNombreUsuario (String nombreUsuario){ 
    	Usuario us = UsuarioDao.obtenerUsuarioPorNombreDeUsuario(nombreUsuario);
    	if(us != null) {
    		return true;
    	}
    	return false;
    }	    

  //DEVUELVE true si se puede crear y false si no, por encontrar el DNI ya entre los USUARIOS
    public static Boolean existeDNI (Integer dniUsuario){ 
    	Usuario us = UsuarioDao.obtenerUsuarioPorDNI(dniUsuario);
    	if(us != null) {
    		return true;
    	}
    	return false;
    }	
}