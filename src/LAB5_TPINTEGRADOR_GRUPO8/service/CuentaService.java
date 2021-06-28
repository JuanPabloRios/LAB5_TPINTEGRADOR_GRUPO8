package LAB5_TPINTEGRADOR_GRUPO8.service;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import LAB5_TPINTEGRADOR_GRUPO8.dao.CuentaDao;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate;

public class CuentaService {
	
	  public static String editarCuenta(Integer numeroCuenta, Double saldo , TiposDeCuentas tipoCuenta){ 
	    	try {  
		     	Cuentas ca = CuentaDao.obtenerCuentaPorId(numeroCuenta);	 
		    	if(!ca.getSaldo().equals(saldo)) { 
		    		ca.setSaldo(saldo);
		    	}
		    	if(ca.getTipoCuenta().getDescripcion() != tipoCuenta.getDescripcion()) {
		    		ca.setTipoCuenta(tipoCuenta);
		    	}
		    	CuentaDao.actualizarCuenta(ca); 
	        	return "OK";
		    }catch (HibernateException he){
		        he.printStackTrace();
		        return "Ocurrio una excepcion durante la Modificacion";
		    }
	    }	
}
