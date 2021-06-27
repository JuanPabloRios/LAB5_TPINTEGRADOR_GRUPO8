package LAB5_TPINTEGRADOR_GRUPO8.service; 
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.selector.ConfigHibernate;
import LAB5_TPINTEGRADOR_GRUPO8.selector.TipoDeUsuarioSelector;
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector; 
import java.sql.Date;  
import java.util.List; 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext; 

public class UsuarioService {
	
    public static void eliminarUsuarioPorId(Integer idUsuario){ 
    	try {
	     	Usuario usuario = UsuarioSelector.obtenerUsuarioPorID(idUsuario);     	
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
    public static String crearUsuario(String nombreCliente, String apellidoCliente, Integer dniCliente, Date fechaNacimientoCliente, 
    	String nacionalidadCliente, String direccionCliente, String sexoCliente, String provinciaCliente, String localidadCliente,
		String nombreUsuario, String contrasenia){ 
    	try{
	    	Boolean existe = UsuarioService.existeDNI(dniCliente); 
	    	if(!existe) {
	    		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	    		ConfigHibernate config = new ConfigHibernate();
	        	Session session = config.abrirConexion();
	        	session.beginTransaction();
	        	
	            Usuario us = (Usuario)appContext.getBean("UsuarioCliente"); 
	            us.setTipoDeUsuario(TipoDeUsuarioSelector.obtenerTipoUsuarioPorNombre("Cliente"));
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

	        	((ConfigurableApplicationContext)appContext).close();
	        	return "OK";
	    	} else {
	    		return "El DNI ingresado ya existe";
	    	}
	    }catch (HibernateException he){
	        he.printStackTrace();
	        return "Ocurrio una excepcion durante el guardado";
	    } 
    }
    
    
    //FALTA AGREGAR LOCALIDAD Y PROVINCIA
    public static void editarUsuario(Integer idUsuario, String nombreCliente, String apellidoCliente, Integer dniCliente, Date fechaNacimientoCliente, 
			String nacionalidadCliente, String direccionCliente, String sexoCliente, String provinciaCliente, String localidadCliente,
			String nombreUsuario, String contrasenia){ 
    	try {
	     	Usuario us = UsuarioSelector.obtenerUsuarioPorID(idUsuario);
	    	ConfigHibernate config = new ConfigHibernate();
	    	Session session = config.abrirConexion();
	    	session.beginTransaction(); 
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
	    	session.update(us); 
	    	session.getTransaction().commit(); 
	    	config.cerrarSession(); 
	    }catch (HibernateException he){
	        he.printStackTrace();
	    }
    }	
    
  //DEVUELVE true si se puede crear y false si no, por encontrar el DNI ya entre los USUARIOS
    public static Boolean existeDNI (Integer dniUsuario){ 
    	ConfigHibernate config = new ConfigHibernate();
    	Session session = config.abrirConexion(); 
    	session.beginTransaction(); 
    	List<Usuario> usuarios = (List<Usuario>)session.createQuery("FROM Usuario").list(); 
    	config.cerrarSession();
        for(Integer i = 0; i< usuarios.size(); i++) { 
            if(usuarios.get(i).getTipoDeUsuario().getDescripcion().equals("Cliente") && usuarios.get(i).getEstado() && usuarios.get(i).getDNI() == dniUsuario ) {
                return true;
            }
        } 
    	return false;
    }	
}
