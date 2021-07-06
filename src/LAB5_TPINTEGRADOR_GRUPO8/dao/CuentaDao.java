package LAB5_TPINTEGRADOR_GRUPO8.dao; 
import java.util.ArrayList; 
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate; 

public class CuentaDao {

    public static List<Cuentas> obtenerTodasLasCuentasDeClientePorId(Integer usuarioId){ 
         
        List<Cuentas> result = new ArrayList<>();
        try {
        	Session se = ConfigHibernate.obtenerSessionFactory().openSession();
            List<Cuentas> cuentasClientes = (List<Cuentas>)se.createQuery("FROM Cuentas").list();
	        for(Integer i = 0; i< cuentasClientes.size(); i++) { 
	            if(cuentasClientes.get(i).getUsuario().getIdusuario() ==  usuarioId) {
	                result.add(cuentasClientes.get(i));
	            }
	        }
        }
        catch(HibernateException he){
        	he.printStackTrace();
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
        finally {
        	ConfigHibernate.cerrarSessionFactory();
        }
        return result;
    }
    
    
    public static List<Cuentas> obtenerTodasLasCuentas(){  
        List<Cuentas> result = new ArrayList<>();
        try {
        	Session se = ConfigHibernate.obtenerSessionFactory().openSession();
            List<Cuentas> cuentasClientes = (List<Cuentas>)se.createQuery("FROM Cuentas").list();
	        for(Integer i = 0; i < cuentasClientes.size(); i++) {  
	        	result.add(cuentasClientes.get(i)); 
	        }
        }
        catch(HibernateException he){
        	he.printStackTrace();
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
        finally {
        	ConfigHibernate.cerrarSessionFactory();
        }
        return result;
    }
    
    public static Cuentas obtenerCuentaPorId(Integer idCuenta) {
    	try {

        Session session = ConfigHibernate.obtenerSessionFactory().openSession();
    	session.beginTransaction();
    	Cuentas cuenta = (Cuentas)session.get(Cuentas.class,idCuenta); 
    	
    	return cuenta;
    	}
    	catch(HibernateException he){
        	he.printStackTrace();
        }
    	catch(Exception ex){
        	ex.printStackTrace();
        }
    	finally {
    		ConfigHibernate.cerrarSessionFactory();
    	}
		return null;
    }
    
    public static Cuentas obtenerCuentaPorCBU(String cbu){ 
        try {
        	List<Cuentas> cuentas = CuentaDao.obtenerTodasLasCuentas();
	        for(Integer i = 0; i< cuentas.size(); i++) { 
	            if(cbu.equals(cuentas.get(i).getCBU())) {
	                return cuentas.get(i);
	            }
	        }
        }
        catch(HibernateException he){
        	he.printStackTrace();
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
        return null;
    }
    
    public static String eliminarCuenta(Cuentas cu){   	
    	try{
	    	Session session = ConfigHibernate.obtenerSessionFactory().openSession();
	    	session.beginTransaction(); 
	    	cu.setEstado(false);
	    	session.update(cu); 
	    	session.getTransaction().commit(); 
	    	
    	}
    	catch (HibernateException he){
	        he.printStackTrace();
	    } 
        catch (Exception ex){
	        ex.printStackTrace();
	    }
    	finally {
    	ConfigHibernate.cerrarSessionFactory();
    	}
		return null;
    }
    
    public static String actualizarCuenta(Cuentas ca) { 

    	try {
    		Session session = ConfigHibernate.obtenerSessionFactory().openSession();
    		session.beginTransaction();
    		session.update(ca); 
    		session.getTransaction().commit(); 
    	}
    	catch(HibernateException he){
        	he.printStackTrace();
        	return "Ocurrio una excepcion durante la Modificacion";
        }
    	catch(Exception ex){
        	ex.printStackTrace();
        	return "Ocurrio una excepcion durante la Modificacion";
        }
    	finally{
    		ConfigHibernate.cerrarSessionFactory();
    	}
    	return "OK";
    }

	public static String insertarCuenta(Cuentas cuenta) {
	try {
    	Session session = ConfigHibernate.obtenerSessionFactory().openSession();
    	session.beginTransaction();  
    	session.save(cuenta);  
    	session.getTransaction().commit(); 
    	ConfigHibernate.cerrarSessionFactory();
	}
	catch (HibernateException he){
        he.printStackTrace();
    } 
    catch (Exception ex){
        ex.printStackTrace();
    }
	finally{
		ConfigHibernate.cerrarSessionFactory();
	}
        return null;
	}
    
}