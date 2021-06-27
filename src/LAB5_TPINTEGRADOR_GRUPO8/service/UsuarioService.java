package LAB5_TPINTEGRADOR_GRUPO8.service;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeUsuarios;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.selector.ConfigHibernate;
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector;

import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext; 

public class UsuarioService {
	
    public static void eliminarUsuarioPorId(Integer idUsuario){ 
    	try {
	     	Usuario usuario = UsuarioSelector.readOne(idUsuario);     	
	    	ConfigHibernate config = new ConfigHibernate();
	    	usuario.setEstado(false);
	    	Session session = config.abrirConexion();
	    	session.beginTransaction();
	    	
	    	session.update(usuario);
	    	
	    	session.getTransaction().commit();
	    	
	    	config.cerrarSession();
	    }catch (HibernateException he){
	        he.printStackTrace();
	    }
    }	
    //FALTA AGREGAR EL CAMPO DE LOCALIDAD Y PROVINCIA
    public static void crearUsuario(String nombreCliente, String apellidoCliente, Integer dniCliente, Date fechaNacimientoCliente, 
    	String nacionalidadCliente, String direccionCliente, String sexoCliente, String provinciaCliente, String localidadCliente,
		String nombreUsuario, String contrasenia){ 
    	try{
	    	Boolean existe = UsuarioSelector.validarDNI(dniCliente);
	    	System.out.println("existe " + existe);
	    	if(!existe.booleanValue()) {
	    		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	    		ConfigHibernate config = new ConfigHibernate();
	        	Session session = config.abrirConexion();
	        	session.beginTransaction();
	        	
	            Usuario us = (Usuario)appContext.getBean("UsuarioCliente"); 
	            us.setTipoDeUsuario(UsuarioSelector.obtenerTipoUsuarioPorNombre("Cliente"));
	            us.setNombre(nombreCliente);
	            us.setApellido(apellidoCliente);
	            us.setContrasenia(contrasenia);
	            us.setUsuario(nombreUsuario);   
	            us.setDireccion(direccionCliente);
	            us.setDNI(dniCliente); 
	            us.setNacionalidad(nacionalidadCliente);
	            us.setSexo(sexoCliente);
	            us.setFecha_de_nacimiento(fechaNacimientoCliente);   
	            session.save(us); 
	        	
	        	session.getTransaction().commit();
	        	
	        	config.cerrarSession();
	    	}  	

	    }catch (HibernateException he){
	        he.printStackTrace();
	    }
    }
    
    
    //FALTA AGREGAR LOCALIDAD Y PROVINCIA
    public static void editarUsuario(Integer idUsuario, String nombreCliente, String apellidoCliente, Integer dniCliente, Date fechaNacimientoCliente, 
			String nacionalidadCliente, String direccionCliente, String sexoCliente, String provinciaCliente, String localidadCliente,
			String nombreUsuario, String contrasenia){ 
    	try {
	     	Usuario us = UsuarioSelector.readOne(idUsuario);
	    	ConfigHibernate config = new ConfigHibernate();
	    	Session session = config.abrirConexion();
	    	session.beginTransaction(); 
	    	if(!us.getNombre().contains(nombreCliente)) {
	    		System.out.println("setNombre " );
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
	    	session.update(us); 
	    	session.getTransaction().commit(); 
	    	config.cerrarSession(); 
	    }catch (HibernateException he){
	        he.printStackTrace();
	    }
    }	
    
	
}
