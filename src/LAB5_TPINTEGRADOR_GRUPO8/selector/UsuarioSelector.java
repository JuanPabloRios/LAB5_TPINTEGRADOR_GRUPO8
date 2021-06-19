package LAB5_TPINTEGRADOR_GRUPO8.selector;
import java.util.List;

import org.hibernate.Session;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;

public class UsuarioSelector {
	
	public static List<Usuario> obtenerTodosLosUsarios(){ 
		ConfigHibernate ch = new ConfigHibernate();
		Session se = ch.abrirConexion(); 
		List<Usuario> result = (List<Usuario>)se.createQuery("FROM Usuario").list();
		ch.cerrarSession();
		return result;
	}
	
	public static Usuario obtenerUsuarioPorNombreDeUsuario(String nombreUsuario){ 
		List<Usuario> usuarios = UsuarioSelector.obtenerTodosLosUsarios();
		for(Integer i = 0; i< usuarios.size(); i++) {
			if(usuarios.get(i).getUsuario() == nombreUsuario) {
				return usuarios.get(i);
			}
		}
		return null;
	}
}
