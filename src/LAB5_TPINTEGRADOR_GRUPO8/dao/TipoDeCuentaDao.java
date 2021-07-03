package LAB5_TPINTEGRADOR_GRUPO8.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas;
import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate;

public class TipoDeCuentaDao {
	public static TiposDeCuentas obtenerTipoCuentaPorNombre(String tipoCuenta) { 
        try{
        
	        Session se = ConfigHibernate.obtenerSessionFactory().openSession();
	        List<TiposDeCuentas> ltpCuenta = (List<TiposDeCuentas>)se.createQuery("FROM TiposDeCuentas").list();   
	     
	        TiposDeCuentas tpCuenta = new TiposDeCuentas(); 
	        for(Integer i = 0; i< ltpCuenta.size(); i++) {  
	            if(ltpCuenta.get(i).getDescripcion().equals(tipoCuenta)) { 
	            	tpCuenta = ltpCuenta.get(i);
	                return tpCuenta;
	            }
	        } 
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
}
