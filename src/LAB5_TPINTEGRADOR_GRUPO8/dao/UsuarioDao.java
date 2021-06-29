package LAB5_TPINTEGRADOR_GRUPO8.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder; 
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate;

public class UsuarioDao {
    
    //DEVUELVE UNA LISTA CON TODOS LOS USUARIOS DE LA BASE DE DATOS
    public static List<Usuario> obtenerTodosLosUsarios(){ 
        try{
        	ConfigHibernate ch = new ConfigHibernate();
	        Session se = ch.abrirConexion(); 
	        List<Usuario> result = (List<Usuario>)se.createQuery("FROM Usuario").list(); 
	        ch.cerrarSession();
	        return result;
        }
        catch (HibernateException he){
	        he.printStackTrace();
	    } 
        catch (Exception ex){
	        ex.printStackTrace();
	    }
		return null;
    }
    
    //DEVUELVE UNA LISTA CON TODOS LOS USUARIOS TIPO CLIENTE CON ESTADO TRUE
    public static List<Usuario> obtenerTodosLosClientes(){ 
        ConfigHibernate ch = new ConfigHibernate();
        List<Usuario> result = new ArrayList<>();
        try{
        	Session se = ch.abrirConexion(); 
	        List<Usuario> usuarios = (List<Usuario>)se.createQuery("FROM Usuario").list(); 
	        for(Integer i = 0; i< usuarios.size(); i++) { 
	            if(usuarios.get(i).getTipoDeUsuario().getDescripcion().equals("Cliente") && usuarios.get(i).getEstado()) {
	                result.add(usuarios.get(i));
	            }
	        }
        }
        catch (HibernateException he){
	        he.printStackTrace();
	    } 
        catch (Exception ex){
	        ex.printStackTrace();
	    }
        ch.cerrarSession();
        return result;
    }
    
    //DEVUELVE EL USUARIO CON EL MISMO NOMBRE SI NO DEVUELVE NULL
    public static Usuario obtenerUsuarioPorNombreDeUsuario(String nombreUsuario){ 
        try {
	    	List<Usuario> usuarios = UsuarioDao.obtenerTodosLosUsarios(); 
	        for(Integer i = 0; i< usuarios.size(); i++) { 
	            if(nombreUsuario.equals(usuarios.get(i).getUsuario())) {
	                return usuarios.get(i);
	            }
	        }
        }
        catch (HibernateException he){
	        he.printStackTrace();
	    } 
        catch (Exception ex){
	        ex.printStackTrace();
	    }
		return null; 
    }
    
  //DEVUELVE EL USUARIO CON EL MISMO NOMBRE SI NO DEVUELVE NULL
    public static String eliminarUsuario(Usuario user){   	
    	try{ConfigHibernate config = new ConfigHibernate(); 
	    	Session session = config.abrirConexion();
	    	session.beginTransaction(); 
	    	user.setEstado(false);
	    	session.update(user); 
	    	session.getTransaction().commit(); 
	    	config.cerrarSession();
    	}
    	catch (HibernateException he){
	        he.printStackTrace();
	    } 
        catch (Exception ex){
	        ex.printStackTrace();
	    }
		return null;
    }
    
    public static String insertarUsuario(Usuario user){   	
    	try {
	    	ConfigHibernate config = new ConfigHibernate(); 
	    	Session session = config.abrirConexion();
	    	session.beginTransaction();  
	    	session.save(user);  
	    	session.getTransaction().commit(); 
	    	config.cerrarSession();
    	}
    	catch (HibernateException he){
	        he.printStackTrace();
	    } 
        catch (Exception ex){
	        ex.printStackTrace();
	    }
		return null;
    }
    
    public static String actualizarUsuario(Usuario user){   	
    	try {
	    	ConfigHibernate config = new ConfigHibernate(); 
	    	Session session = config.abrirConexion();
	    	session.beginTransaction();  
	    	session.update(user);  
	    	session.getTransaction().commit(); 
	    	config.cerrarSession();
    	}
    	catch (HibernateException he){
	        he.printStackTrace();
	    } 
        catch (Exception ex){
	        ex.printStackTrace();
	    }
		return null;
    }
    
    public static Usuario obtenerUsuarioPorDNI(Integer DNI){ 
    	try {
	    	ConfigHibernate config = new ConfigHibernate();
	    	Session session = config.abrirConexion(); 
	    	session.beginTransaction(); 
	    	List<Usuario> usuarios = (List<Usuario>)session.createQuery("FROM Usuario").list(); 
	    	config.cerrarSession();
	        for(Integer i = 0; i< usuarios.size(); i++) { 
	            if(usuarios.get(i).getTipoDeUsuario().getDescripcion().equals("Cliente") && usuarios.get(i).getEstado() && usuarios.get(i).getDNI() == DNI ) {
	                return usuarios.get(i);
	            }
	        } 
    	}
    	catch (HibernateException he){
	        he.printStackTrace();
	    } 
        catch (Exception ex){
	        ex.printStackTrace();
	    }
		return null;
    	
    }
    
    //DEVUELVE EL USUARIO CON EL MISMO ID
    public static Usuario obtenerUsuarioPorID(Integer idUsuario){ 
    	try {
	    	ConfigHibernate config = new ConfigHibernate();
	    	Session session = config.abrirConexion(); 
	    	session.beginTransaction();
	    	Usuario usuario = (Usuario)session.get(Usuario.class,idUsuario); 
	    	config.cerrarSession();
	    	return usuario;
    	}
    	catch (HibernateException he){
	        he.printStackTrace();
	    } 
        catch (Exception ex){
	        ex.printStackTrace();
	    }
		return null;
    }  
        
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        try {
    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
        }
        catch (HibernateException he){
	        he.printStackTrace();
	    } 
        catch (Exception ex){
	        ex.printStackTrace();
	    }
    } 
}