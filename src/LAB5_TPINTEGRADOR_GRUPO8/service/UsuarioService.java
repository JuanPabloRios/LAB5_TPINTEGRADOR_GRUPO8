package LAB5_TPINTEGRADOR_GRUPO8.service;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeUsuarios;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.selector.ConfigHibernate;
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session; 

public class UsuarioService {
	
    public static void eliminarUsuarioPorId(Integer idUsuario){ 
     	Usuario usuario = UsuarioSelector.readOne(idUsuario);     	
    	ConfigHibernate config = new ConfigHibernate();
    	usuario.setEstado(false);
    	Session session = config.abrirConexion();
    	session.beginTransaction();
    	
    	session.update(usuario);
    	
    	session.getTransaction().commit();
    	
    	config.cerrarSession();
    	
    }	
    
    public static void crearUsuario(String nombreCliente, String apellidoCliente, Integer dniCliente, Date fechaNacimientoCliente, 
			String nacionalidadCliente, String direccionCliente){ 
    	Boolean existe = UsuarioSelector.validarDNI(dniCliente);
    	if(!existe.booleanValue()) {
    		TiposDeUsuarios tp = UsuarioSelector.obtenerTipoUsuarioPorNombre("Cliente");    		
    		ConfigHibernate config = new ConfigHibernate();
        	Session session = config.abrirConexion();
        	session.beginTransaction();
        	
            Usuario us = new Usuario();
            us.setNombre(nombreCliente);
            us.setApellido(apellidoCliente);
            us.setContrasenia(nombreCliente);
            us.setUsuario(nombreCliente);   
            us.setDireccion(direccionCliente);
            us.setDNI(dniCliente);
            us.setEstado(true);
            us.setNacionalidad(nacionalidadCliente);
            us.setSexo("M");
            us.setFecha_de_nacimiento(fechaNacimientoCliente);  
            us.setTipoDeUsuario(tp);  
            session.save(us); 
        	
        	session.getTransaction().commit();
        	
        	config.cerrarSession();
    	}  	
    	System.out.println("fuera del IFF " );
    	
    }	
	
}
