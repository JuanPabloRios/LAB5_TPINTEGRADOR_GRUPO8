package LAB5_TPINTEGRADOR_GRUPO8.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.TipoMovimiento;
import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate;

public class TipoMovimientoDao {
	
	public static TipoMovimiento obtenerTipoMovimientoPorNombre(String tipoMovimiento) { 
        try{
        	Session se = ConfigHibernate.obtenerSessionFactory().openSession();
	        List<TipoMovimiento> ltpMovimiento = (List<TipoMovimiento>)se.createQuery("FROM TipoMovimiento").list();   
	        ConfigHibernate.cerrarSessionFactory();
	        for(Integer i = 0; i< ltpMovimiento.size(); i++) {  
	            if(ltpMovimiento.get(i).getDescripcion().equals(tipoMovimiento)) { 
	            	return ltpMovimiento.get(i); 
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
}	
