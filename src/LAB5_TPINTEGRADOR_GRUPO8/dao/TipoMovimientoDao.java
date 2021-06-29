package LAB5_TPINTEGRADOR_GRUPO8.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.TipoMovimiento;
import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate;

public class TipoMovimientoDao {
	
	public static TipoMovimiento obtenerTipoMovimientoPorNombre(String tipoMovimiento) { 
        try{
        	ConfigHibernate ch = new ConfigHibernate();
	        Session se = ch.abrirConexion(); 
	        List<TipoMovimiento> ltpMovimiento = (List<TipoMovimiento>)se.createQuery("FROM TipoMovimiento").list();   
	        ch.cerrarSession(); 
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
