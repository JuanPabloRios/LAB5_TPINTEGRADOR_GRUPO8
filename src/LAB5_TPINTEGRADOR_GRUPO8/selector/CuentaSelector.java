package LAB5_TPINTEGRADOR_GRUPO8.selector; 
import java.util.ArrayList; 
import java.util.List; 
import org.hibernate.Session; 
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas; 

public class CuentaSelector {

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
    	ConfigHibernate ch = new ConfigHibernate();
        Session se = ch.abrirConexion(); 
        List<Cuentas> cuentasClientes = (List<Cuentas>)se.createQuery("FROM Cuentas").list();  
        for(Integer i = 0; i< cuentasClientes.size(); i++) { 
            if(idCuenta == cuentasClientes.get(i).getIdNroDeCuenta()) {
                return cuentasClientes.get(i);
            }
        } 
        return null;
    }
}