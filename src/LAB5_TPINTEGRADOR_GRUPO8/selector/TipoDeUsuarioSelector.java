package LAB5_TPINTEGRADOR_GRUPO8.selector;

import java.util.List;

import org.hibernate.Session;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeUsuarios;

public class TipoDeUsuarioSelector {
	public static TiposDeUsuarios obtenerTipoUsuarioPorNombre(String tipoUsuario) { 
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
    	return null;
    }
}
