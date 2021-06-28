package LAB5_TPINTEGRADOR_GRUPO8.service;


import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.resources.Config;
import LAB5_TPINTEGRADOR_GRUPO8.selector.ConfigHibernate;
import LAB5_TPINTEGRADOR_GRUPO8.selector.CuentaSelector;
import LAB5_TPINTEGRADOR_GRUPO8.selector.TipoDeUsuarioSelector;

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

	public static String crearCuenta(String nombreCuenta, Double saldo, String CBU, Date fechaCuenta, String tipoCuenta, Integer numeroCuenta){ 
	    	try{
		    	Boolean limiteCantCuentas = CuentaService.limiteCuentas(); 
		    	
		    	if(!limiteCantCuentas) {
		    		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		    		ConfigHibernate config = new ConfigHibernate();
		        	Session session = config.abrirConexion();
		        	session.beginTransaction();
		        	
		            Cuentas cu = (Cuentas)appContext.getBean("Cuenta"); 
		            cu.setTipoDeUsuario(TipoDeUsuarioSelector.obtenerTipoUsuarioPorNombre("Cliente"));
		            cu.setNombre(nombreCliente);
		            cu.setApellido(apellidoCliente);
		            cu.setContrasenia(contrasenia);
		            cu.setUsuario(nombreUsuario);   
		            cu.setDireccion(direccionCliente);
		            cu.setDNI(dniCliente); 
		            cu.setNacionalidad(nacionalidadCliente);
		            cu.setSexo(sexoCliente);
		            cu.setFecha_de_nacimiento(fechaNacimientoCliente);   
		            session.save(cu);  
		        	session.getTransaction().commit(); 
		        	config.cerrarSession();

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
