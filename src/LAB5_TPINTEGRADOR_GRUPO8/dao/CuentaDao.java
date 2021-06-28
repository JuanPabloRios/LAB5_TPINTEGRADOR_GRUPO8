package LAB5_TPINTEGRADOR_GRUPO8.dao; 
import java.util.ArrayList; 
import java.util.List; 
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
        ConfigHibernate ch = new ConfigHibernate();
        Session se = ch.abrirConexion(); 
        List<Cuentas> cuentasClientes = (List<Cuentas>)se.createQuery("FROM Cuentas").list(); 
        List<Cuentas> result = new ArrayList<>();
        for(Integer i = 0; i< cuentasClientes.size(); i++) { 
            if(cuentasClientes.get(i).getUsuario().getIdusuario() ==  usuarioId) {
                result.add(cuentasClientes.get(i));
            }
        }
        ch.cerrarSession();
        return result;
    }
    
    //FALTA EL CAMPO ESTADO EN LAS CUENTAS
    public static List<Cuentas> obtenerTodasLasCuentas(){ 
        ConfigHibernate ch = new ConfigHibernate();
        Session se = ch.abrirConexion(); 
        List<Cuentas> cuentasClientes = (List<Cuentas>)se.createQuery("FROM Cuentas").list(); 
        List<Cuentas> result = new ArrayList<>();
        for(Integer i = 0; i < cuentasClientes.size(); i++) {  
        	result.add(cuentasClientes.get(i)); 
        }
        ch.cerrarSession();
        return result;
    }
    
    public static Cuentas obtenerCuentaPorId(Integer idCuenta) {
    	ConfigHibernate config = new ConfigHibernate();
    	Session session = config.abrirConexion(); 
    	session.beginTransaction();
    	Cuentas cuenta = (Cuentas)session.get(Cuentas.class,idCuenta); 
    	config.cerrarSession();
    	return cuenta;
    }
    
    public static Cuentas obtenerCuentaPorCBU(String cbu){ 
        List<Cuentas> cuentas = CuentaDao.obtenerTodasLasCuentas(); 
        for(Integer i = 0; i< cuentas.size(); i++) { 
            if(cbu.equals(cuentas.get(i).getCBU())) {
                return cuentas.get(i);
            }
        }
        return null;
    }
    
    public static String actualizarCuenta(Cuentas ca) { 
     	ConfigHibernate config = new ConfigHibernate();
    	Session session = config.abrirConexion(); 
    	session.beginTransaction();
    	session.update(ca); 
    	session.getTransaction().commit(); 
    	config.cerrarSession();  
    	return "OK";
    }
    
}