package LAB5_TPINTEGRADOR_GRUPO8.selector;

import java.util.List;

import org.hibernate.Session;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas;

public class TipoDeCuentaSelector {
	public static TiposDeCuentas obtenerTipoCuentaPorNombre(String tipoCuenta) { 
        ConfigHibernate ch = new ConfigHibernate();
        Session se = ch.abrirConexion(); 
        List<TiposDeCuentas> ltpCuenta = (List<TiposDeCuentas>)se.createQuery("FROM TiposDeCuentas").list();   
        ch.cerrarSession();
        TiposDeCuentas tpCuenta = new TiposDeCuentas(); 
        for(Integer i = 0; i< ltpCuenta.size(); i++) {  
            if(ltpCuenta.get(i).getDescripcion().equals(tipoCuenta)) { 
            	tpCuenta = ltpCuenta.get(i);
                return tpCuenta;
            }
        } 
    	return null;
    }
}