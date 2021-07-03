package LAB5_TPINTEGRADOR_GRUPO8.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Movimientos;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate;

public class MovimientoDao {

	
    public static List<Movimientos> obtenerTodosLosMovimientosDeClientePorId(Integer idCuenta){ 
        List<Movimientos> result = new ArrayList<>();
        try {
	        Session se = ConfigHibernate.obtenerSessionFactory().openSession(); 
	        List<Movimientos> movimientosClientes = (List<Movimientos>)se.createQuery("FROM Movimientos").list(); 
	        for(Integer i = 0; i< movimientosClientes.size(); i++) { 
	            if(movimientosClientes.get(i).getUsuario().getIdNroDeCuenta() ==  idCuenta) {
	                result.add(movimientosClientes.get(i));
	            }
	        }
        }
        catch (HibernateException he){
	        he.printStackTrace();
	    }
        finally {
	        ConfigHibernate.cerrarSessionFactory();
        }
	        return result;
    }
    
    public static String insertarMovimiento(Movimientos mov) { 
    	try {  
	        Session se = ConfigHibernate.obtenerSessionFactory().openSession(); 
	        se.beginTransaction();
	        se.save(mov);
	        se.getTransaction().commit();
	        ConfigHibernate.cerrarSessionFactory();
	    	return "OK";
    	}
    	catch (HibernateException he){
	        he.printStackTrace();
	        return "Ocurrió una excepcion durante la transacción";
	    }
    	catch (Exception ex){
    		ex.printStackTrace();
	        return "Ocurrió una excepcion durante la transacción";
	    }
    }
    
 
    
}
