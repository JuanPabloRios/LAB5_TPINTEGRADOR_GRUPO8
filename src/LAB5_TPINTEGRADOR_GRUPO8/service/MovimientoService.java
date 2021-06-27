package LAB5_TPINTEGRADOR_GRUPO8.service;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Movimientos;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.selector.ConfigHibernate;
import LAB5_TPINTEGRADOR_GRUPO8.selector.CuentaSelector;

public class MovimientoService {
	   public static String transferenciaCuenta(Integer idUsuario, Double Monto, Integer CuentaDestino, Integer CuentaOrigen, String cbu){ 
	        try {
	    		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	    		
	    		Cuentas cOrigen = CuentaSelector.obtenerCuentaPorId(CuentaOrigen);
	    		if(cOrigen.getSaldo() >= Monto) {
				   if(!cbu.isEmpty()) {
					    ConfigHibernate ch = new ConfigHibernate();       
				        Session se = ch.abrirConexion(); 
				        se.beginTransaction();
				        
				        Double mTotalOrigen = cOrigen.getSaldo()-Monto;
				        cOrigen.setSaldo(mTotalOrigen);
				        
				        Movimientos mOrigen = new Movimientos();
				        mOrigen.setDescripcion("Transferencia a Cuenta Propia " + CuentaDestino); 
				        mOrigen.setImporte(mTotalOrigen);
				        mOrigen.setFecha(new Date(System.currentTimeMillis()));
				        mOrigen.setDetalle("Movimiento ");
				        mOrigen.setUsuario(cOrigen);
			            
				        
				        Cuentas cDestino = CuentaSelector.obtenerCuentaPorId(CuentaDestino);
				    	Double mTotal = cDestino.getSaldo() + Monto; 
				    	
				        Movimientos mDestino = new Movimientos();
				        mDestino.setDescripcion("Transferencia recibida " + CuentaOrigen); 
				        mDestino.setImporte(mTotal);
				        mDestino.setFecha(new Date(System.currentTimeMillis()));
				        mDestino.setDetalle("Movimiento ");
				        mDestino.setUsuario(cDestino);
			            se.save(mDestino);
				    	
				    	
				    	cDestino.setSaldo(mTotal);
				    	
				    	se.save(mOrigen);
				    	se.save(mDestino);
				    	se.update(cOrigen);
				    	se.update(cDestino);
				    	se.getTransaction().commit(); 
				        ch.cerrarSession();	   
				    	((ConfigurableApplicationContext)appContext).close();
				        return "OK";
				   }else {
					    ConfigHibernate ch = new ConfigHibernate();       
				        Session se = ch.abrirConexion(); 
				        se.beginTransaction();
				        
				        
				        
				        Double mTotalOrigen = cOrigen.getSaldo()-Monto;
				        cOrigen.setSaldo(mTotalOrigen);
				        
				        Movimientos mOrigen = new Movimientos();
				        mOrigen.setDescripcion("Transferencia por Cbu " + cbu); 
				        mOrigen.setImporte(mTotalOrigen);
				        mOrigen.setFecha(new Date(System.currentTimeMillis()));
				        mOrigen.setDetalle("Movimiento ");
				        mOrigen.setUsuario(cOrigen);
			            
				        
				        
				        Cuentas cCbuDestino = CuentaSelector.obtenerCuentaPorCBU(cbu);
				        Double mTotal = cCbuDestino.getSaldo() + Monto; 
				    	
				        Movimientos mDestino = new Movimientos();
				        mDestino.setDescripcion("Transferencia recibida " + CuentaOrigen); 
				        mDestino.setImporte(mTotal);
				        mDestino.setFecha(new Date(System.currentTimeMillis()));
				        mDestino.setDetalle("Movimiento ");
				        mDestino.setUsuario(cCbuDestino);
			            se.save(mDestino);
				    	
				        
				        cCbuDestino.setSaldo(mTotal);
				    	se.save(mOrigen);
				    	se.save(mDestino);
				    	se.update(cOrigen);
				    	se.update(cCbuDestino);
				      
				    	se.getTransaction().commit(); 
				        ch.cerrarSession();	   
				    	((ConfigurableApplicationContext)appContext).close();
					   return "OK";
				   }
			   }else {
				   return "Saldo insuficiente para realizar la transferencia.";
			   }
		   
	        }catch (HibernateException he){
		        he.printStackTrace();
		        return "Ocurrio una excepcion durante la Modificacion";
		    }
	    }
	    
}
