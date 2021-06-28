package LAB5_TPINTEGRADOR_GRUPO8.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Movimientos;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate;

public class MovimientoDao {

	
    public static List<Movimientos> obtenerTodosLosMovimientosDeClientePorId(Integer idCuenta){ 
        ConfigHibernate ch = new ConfigHibernate();
        Session se = ch.abrirConexion(); 
        List<Movimientos> movimientosClientes = (List<Movimientos>)se.createQuery("FROM Movimientos").list(); 
        List<Movimientos> result = new ArrayList<>();
        for(Integer i = 0; i< movimientosClientes.size(); i++) { 
            if(movimientosClientes.get(i).getUsuario().getIdNroDeCuenta() ==  idCuenta) {
                result.add(movimientosClientes.get(i));
            }
        }
        ch.cerrarSession();
        return result;
    }
    
    public static String insertarMovimiento(Movimientos mov) { 
    	ConfigHibernate ch = new ConfigHibernate();       
        Session se = ch.abrirConexion(); 
        se.beginTransaction();
        se.save(mov);
        se.getTransaction().commit();
        ch.cerrarSession();
    	return "OK";
    }
    
 
    
}
