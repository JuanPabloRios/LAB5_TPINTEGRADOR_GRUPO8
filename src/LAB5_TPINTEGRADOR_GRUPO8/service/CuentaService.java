package LAB5_TPINTEGRADOR_GRUPO8.service;


import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import LAB5_TPINTEGRADOR_GRUPO8.dao.CuentaDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.UsuarioDao;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;


import LAB5_TPINTEGRADOR_GRUPO8.dao.CuentaDao;
import LAB5_TPINTEGRADOR_GRUPO8.dao.TipoDeUsuarioDao;

import LAB5_TPINTEGRADOR_GRUPO8.resources.ConfigHibernate;

public class CuentaService {
	  
	public static void eliminarTodasLasCuentasDeClientePorId(Integer idUsuario){ 
    	CuentaDao.eliminarTodasLasCuentasDeClientePorId(idUsuario);     	
    } 
	
	public static Boolean existeCBU(String cbu){ 
    	Cuentas cu = CuentaDao.obtenerCuentaPorCBU(cbu);  
    	if(cu != null) {
    		return true;
    	}
    	return false;
    } 
  
    public static void eliminarCuentaPorId(Integer idNroDeCuenta){  
    	Cuentas cuenta = CuentaDao.obtenerCuentaPorId(idNroDeCuenta);     	
	    CuentaDao.eliminarCuenta(cuenta);
    }
	 
	  public static String editarCuenta(Integer numeroCuenta, Double saldo , TiposDeCuentas tipoCuenta, Integer idUsuario ){ 
	    	try{ 
		     	Cuentas ca = CuentaDao.obtenerCuentaPorId(numeroCuenta);
		     	Usuario us = UsuarioDao.obtenerUsuarioPorID(idUsuario);
		     	
		    	Boolean actualizar = false;
		    	
		     	if(!ca.getSaldo().equals(saldo)) { 
		    		ca.setSaldo(saldo);
		    		actualizar = true;
		    	}
		    	
		    	if(ca.getTipoCuenta().getDescripcion() != tipoCuenta.getDescripcion()) {
		    		ca.setTipoCuenta(tipoCuenta);
		    		actualizar = true;
		    	}
		    	
		    	if(ca.getUsuario().getIdusuario() != us.getIdusuario()) {
		    		ca.setUsuario(us);
		    		actualizar = true;
		    	}
		    	
		    	if(actualizar) {
			    	CuentaDao.actualizarCuenta(ca); 
		    	}
	        	return "OK";
		    }catch (HibernateException he){
		        he.printStackTrace();
		        return "Ocurrio una excepcion durante la Modificacion";
		    }
	    } 
	    
		public static String crearCuenta(Double saldo, String CBU, Date fechaCuenta,TiposDeCuentas tpCuenta,Integer numeroCuenta, Integer idUsuario ){ 
	    	try{
		    	Boolean limiteCantCuentas = false; // = CuentaService.limiteCuentas(); // FALTA ESTO!!! y qeu el saldo inicial es $10.000
		    	
		    	if(!limiteCantCuentas) {
		    		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class); 
		            Cuentas cuenta = (Cuentas)appContext.getBean("cuenta"); 
		            Usuario usuario= UsuarioDao.obtenerUsuarioPorID(idUsuario);
		           
		        	
		        	cuenta.setSaldo(saldo);
		        	cuenta.setCBU(CBU);
		        	cuenta.setTipoCuenta(tpCuenta);
		        	cuenta.setFechaCreacion(fechaCuenta);
		        	cuenta.setUsuario(usuario);
		        	CuentaDao.insertarCuenta(cuenta);
		        	((ConfigurableApplicationContext)appContext).close();
		        	return "OK";
		    	} else {
		    		return "El cliente tiene un limite de cuatro cuentas";
		    	}
		    }catch (HibernateException he){
		        he.printStackTrace();
		        return "Ocurrio una excepcion durante el guardado";
		    } 
		
	}

	private static Boolean limiteCuentas() {
		// TODO 
		return null;
	}	

}
