package LAB5_TPINTEGRADOR_GRUPO8.service;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.selector.ConfigHibernate;
import LAB5_TPINTEGRADOR_GRUPO8.selector.CuentaSelector;

public class CuentaService {
	
	  public static String editarCuenta(Integer numeroCuenta, Double saldo , TiposDeCuentas tipoCuenta){ 
	    	try {
	    		
	    		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		     	Cuentas ca = CuentaSelector.obtenerCuentaPorId(numeroCuenta);	     	
		     	ConfigHibernate config = new ConfigHibernate();
		    	Session session = config.abrirConexion();
		    	
		    	session.beginTransaction(); 
		    	
		    	if(!ca.getSaldo().equals(saldo)) { 
		    		ca.setSaldo(saldo);
		    	}
		    	if(ca.getTipoCuenta().getDescripcion() != tipoCuenta.getDescripcion()) {
		    		ca.setTipoCuenta(tipoCuenta);
		    	}
	
		    	session.update(ca); 
		    	session.getTransaction().commit(); 
		    	config.cerrarSession(); 
		    	((ConfigurableApplicationContext)appContext).close();
	        	return "OK";
		    }catch (HibernateException he){
		        he.printStackTrace();
		        return "Ocurrio una excepcion durante la Modificacion";
		    }
	    }	
}
