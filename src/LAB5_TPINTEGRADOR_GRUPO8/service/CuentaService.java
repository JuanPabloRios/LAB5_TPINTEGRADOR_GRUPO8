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

	public static void eliminarCuentaPorId(Integer idNroDeCuenta){ 
		Cuentas cuenta = CuentaDao.obtenerCuentaPorId(idNroDeCuenta);     	
		CuentaDao.eliminarCuenta(cuenta);
	}

	public static String editarCuenta(Integer numeroCuenta, Double saldo , TiposDeCuentas tipoCuenta){ 
		try{ 
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

	public static String crearCuenta(Double saldo, String CBU, Date fechaCuenta,TiposDeCuentas tpCuenta,Integer numeroCuenta, Integer idUsuario ){ 
		try{

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

		}catch (HibernateException he){
			he.printStackTrace();
			return "Ocurrio una excepcion durante el guardado";
		} 

	}

	public static String limiteCuentas(Integer idUsuario) {
		try {

			Usuario usuario= UsuarioDao.obtenerUsuarioPorID(idUsuario);
			
			String v= UsuarioDao.
			if() {



				return "OK";
			}else return "el usuario no puede tener mas de 4 cuentas";
		}catch(HibernateException he){
			he.printStackTrace();
			return "Ocurrio una excepcion durante validacion de cantidad de cuentas";
		}


	}

}
