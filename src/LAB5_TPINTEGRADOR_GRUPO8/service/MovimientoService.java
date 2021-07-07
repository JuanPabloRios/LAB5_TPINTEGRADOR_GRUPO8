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
	   public static String transferenciaCuenta( Double Monto, Integer CuentaDestino, Integer CuentaOrigen, String cbu){ 
	    		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class); 
	    		Cuentas cOrigen = CuentaDao.obtenerCuentaPorId(CuentaOrigen);
		        System.out.println("CON CBU " + cbu);

	    		if(cOrigen.getSaldo() >= Monto) {
				   if(cbu.isEmpty() && CuentaDestino != 0) { 

				        TipoMovimiento debito = TipoMovimientoDao.obtenerTipoMovimientoPorNombre("DEBITO");
				        TipoMovimiento credito = TipoMovimientoDao.obtenerTipoMovimientoPorNombre("CREDITO");
				        
				        Double mTotalOrigen = cOrigen.getSaldo()-Monto;
				        System.out.println("mTotalOrigen " + mTotalOrigen+" estado actual "+ cOrigen.getSaldo() +" MONTO "+ Monto);
				        cOrigen.setSaldo(mTotalOrigen);
				        
				        Movimientos mOrigen = (Movimientos)appContext.getBean("MovimientoDebito");
				        mOrigen.setDescripcion("Transferencia a Cuenta Propia " + CuentaDestino); 
				        mOrigen.setTipoMovimiento(debito);
				        mOrigen.setImporte(Monto);
				        mOrigen.setFecha(new Date(System.currentTimeMillis()));
				        mOrigen.setDetalle("Movimiento ");
				        mOrigen.setUsuario(cOrigen); 
				        
				        Cuentas cDestino = CuentaDao.obtenerCuentaPorId(CuentaDestino);
				    	Double mTotal = cDestino.getSaldo() + Monto; 
				    	
				        Movimientos mDestino = (Movimientos)appContext.getBean("MovimientoCredito");
				        mDestino.setDescripcion("Transferencia recibida " + CuentaOrigen); 
				        mDestino.setImporte(Monto);
				        mDestino.setTipoMovimiento(credito);
				        mDestino.setFecha(new Date(System.currentTimeMillis()));
				        mDestino.setDetalle("Movimiento ");
				        mDestino.setUsuario(cDestino); 
				        
				    	cDestino.setSaldo(mTotal);
				    	
				        System.out.println("mTotalOrigen " + mTotal+" estado actual "+ cDestino.getSaldo() +" MONTO "+ Monto);

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
				        mOrigen.setImporte(Monto);
				        mOrigen.setFecha(new Date(System.currentTimeMillis()));
				        mOrigen.setDetalle("Movimiento ");
				        mOrigen.setUsuario(cOrigen);  
				        
				        Cuentas cCbuDestino = CuentaDao.obtenerCuentaPorCBU(cbu);
				        Double mTotal = cCbuDestino.getSaldo() + Monto; 
				        
				        System.out.println("CON CBU " + cCbuDestino.getIdNroDeCuenta());
				        
				        Movimientos mDestino = new Movimientos();
				        mDestino.setDescripcion("Transferencia recibida " + CuentaOrigen); 
				        mDestino.setTipoMovimiento(credito);
				        mDestino.setImporte(Monto);
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
	    }
	    
}
