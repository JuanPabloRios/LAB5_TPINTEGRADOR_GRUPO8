package LAB5_TPINTEGRADOR_GRUPO8.service;

import java.sql.Date;

import org.hibernate.HibernateException; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import LAB5_TPINTEGRADOR_GRUPO8.dao.CuentaDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.MovimientoDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.TipoMovimientoDao;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Movimientos;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TipoMovimiento; 
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config; 

public class MovimientoService {
	   public static String transferenciaCuenta(Integer idUsuario, Double Monto, Integer CuentaDestino, Integer CuentaOrigen, String cbu){ 
	        try {
	    		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class); 
	    		Cuentas cOrigen = CuentaDao.obtenerCuentaPorId(CuentaOrigen);
	    		if(cOrigen.getSaldo() >= Monto) {
				   if(!cbu.isEmpty()) { 

				        TipoMovimiento debito = TipoMovimientoDao.obtenerTipoMovimientoPorNombre("DEBITO");
				        TipoMovimiento credito = TipoMovimientoDao.obtenerTipoMovimientoPorNombre("CREDITO");
				        
				        Double mTotalOrigen = cOrigen.getSaldo()-Monto;
				        cOrigen.setSaldo(mTotalOrigen);
				        
				        Movimientos mOrigen = (Movimientos)appContext.getBean("MovimientoDebito");
				        mOrigen.setDescripcion("Transferencia a Cuenta Propia " + CuentaDestino); 
				        mOrigen.setTipoMovimiento(debito);
				        mOrigen.setImporte(mTotalOrigen);
				        mOrigen.setFecha(new Date(System.currentTimeMillis()));
				        mOrigen.setDetalle("Movimiento ");
				        mOrigen.setUsuario(cOrigen); 
				        
				        Cuentas cDestino = CuentaDao.obtenerCuentaPorId(CuentaDestino);
				    	Double mTotal = cDestino.getSaldo() + Monto; 
				    	
				        Movimientos mDestino = (Movimientos)appContext.getBean("MovimientoCredito");
				        mDestino.setDescripcion("Transferencia recibida " + CuentaOrigen); 
				        mDestino.setImporte(mTotal);
				        mDestino.setTipoMovimiento(credito);
				        mDestino.setFecha(new Date(System.currentTimeMillis()));
				        mDestino.setDetalle("Movimiento ");
				        mDestino.setUsuario(cDestino); 
				    	cDestino.setSaldo(mTotal);
				    	
				    	MovimientoDao.insertarMovimiento(mOrigen);
				    	MovimientoDao.insertarMovimiento(mDestino); 
				    	CuentaDao.actualizarCuenta(cOrigen); 
				    	CuentaDao.actualizarCuenta(cDestino);  
				    	
				    	((ConfigurableApplicationContext)appContext).close();
				        return "OK";
				   }else {  
					   
					   	TipoMovimiento debito = TipoMovimientoDao.obtenerTipoMovimientoPorNombre("DEBITO");
				        TipoMovimiento credito = TipoMovimientoDao.obtenerTipoMovimientoPorNombre("CREDITO");
				        Double mTotalOrigen = cOrigen.getSaldo()-Monto;
				        cOrigen.setSaldo(mTotalOrigen);
				        
				        Movimientos mOrigen = new Movimientos();
				        mOrigen.setDescripcion("Transferencia por Cbu " + cbu); 
				        mOrigen.setTipoMovimiento(debito);
				        mOrigen.setImporte(mTotalOrigen);
				        mOrigen.setFecha(new Date(System.currentTimeMillis()));
				        mOrigen.setDetalle("Movimiento ");
				        mOrigen.setUsuario(cOrigen);  
				        
				        Cuentas cCbuDestino = CuentaDao.obtenerCuentaPorCBU(cbu);
				        Double mTotal = cCbuDestino.getSaldo() + Monto; 
				    	
				        Movimientos mDestino = new Movimientos();
				        mDestino.setDescripcion("Transferencia recibida " + CuentaOrigen); 
				        mDestino.setTipoMovimiento(credito);
				        mDestino.setImporte(mTotal);
				        mDestino.setFecha(new Date(System.currentTimeMillis()));
				        mDestino.setDetalle("Movimiento ");
				        mDestino.setUsuario(cCbuDestino); 
				    	
				        
				        cCbuDestino.setSaldo(mTotal);
				        MovimientoDao.insertarMovimiento(mOrigen);
				    	MovimientoDao.insertarMovimiento(mDestino); 
				    	CuentaDao.actualizarCuenta(cOrigen); 
				    	CuentaDao.actualizarCuenta(cCbuDestino);  
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
