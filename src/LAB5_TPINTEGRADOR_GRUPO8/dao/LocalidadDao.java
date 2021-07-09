package LAB5_TPINTEGRADOR_GRUPO8.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Localidad;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate;

public class LocalidadDao {
	public static List<Localidad> obtenerTodasLasLocalidades(){ 
        List<Localidad> result = new ArrayList<>();
        try {
	        Session se = ConfigHibernate.obtenerSessionFactory().openSession(); 
	        result = (List<Localidad>)se.createQuery("FROM Localidad AS l ORDER BY l.provincia, l.nombre").list();  
        }
        catch (HibernateException he){
	        he.printStackTrace();
	    }
        finally {
	        ConfigHibernate.cerrarSessionFactory();
        }
        return result;
    }
	
	public static Localidad obtenerLocalidadPorId(Integer locId){  
        try {
	        Session se = ConfigHibernate.obtenerSessionFactory().openSession(); 
	        return (Localidad)se.get(Localidad.class,locId); 
        }
        catch (HibernateException he){
	        he.printStackTrace();
	        return null;
	    }
        finally {
	        ConfigHibernate.cerrarSessionFactory();
        } 
    }
}
