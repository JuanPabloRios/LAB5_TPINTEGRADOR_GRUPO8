package LAB5_TPINTEGRADOR_GRUPO8.selector;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Movimientos;

public class MovimientoSelector {

	
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
    
    
 
    
}
