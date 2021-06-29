package LAB5_TPINTEGRADOR_GRUPO8.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeUsuarios;
import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate;

public class TipoDeUsuarioDao {
	public static TiposDeUsuarios obtenerTipoUsuarioPorNombre(String tipoUsuario) { 
        try {
			ConfigHibernate ch = new ConfigHibernate();
	        Session se = ch.abrirConexion(); 
	        List<TiposDeUsuarios> ltpUsuario = (List<TiposDeUsuarios>)se.createQuery("FROM TiposDeUsuarios").list();   
	        ch.cerrarSession();
	        TiposDeUsuarios tpUsuario = new TiposDeUsuarios(); 
	        for(Integer i = 0; i< ltpUsuario.size(); i++) {  
	            if(ltpUsuario.get(i).getDescripcion().equals(tipoUsuario)) { 
	            	tpUsuario = ltpUsuario.get(i);
	                return tpUsuario;
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
