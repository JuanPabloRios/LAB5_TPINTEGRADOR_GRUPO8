package LAB5_TPINTEGRADOR_GRUPO8.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.dao.CuentaDao;
 

//Controller con algunas acciones que son comunes a todas las vistas
@Controller
public class Utils {
	
	@RequestMapping("salir.html")
	public ModelAndView redireccionarAPrincipal() { 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Principal");
		return mv;
	}
	
	public static String generarCBU() {
		Integer id = CuentaDao.obtenerUltimoIdDeCuenta();
		id+=1; 
		Integer length = String.valueOf(id).length(); 
		String nroCuenta = "1110000000001";
		nroCuenta = nroCuenta.substring(0,nroCuenta.length() - length);
		nroCuenta = nroCuenta + String.valueOf(id);
		String banco = "001";
		String sucursal = "0001";
		 
		Integer verificador1 = 
				Integer.valueOf(String.valueOf(banco.charAt(0))) * 7 +
				Integer.valueOf(String.valueOf(banco.charAt(1))) * 1 +
				Integer.valueOf(String.valueOf(banco.charAt(2))) * 3 +
				Integer.valueOf(String.valueOf(sucursal.charAt(0))) * 9 +
				Integer.valueOf(String.valueOf(sucursal.charAt(1))) * 7 +
				Integer.valueOf(String.valueOf(sucursal.charAt(2))) * 1 +
				Integer.valueOf(String.valueOf(sucursal.charAt(3))) * 3; 
		verificador1 = (10 - verificador1 % 10) % 10; 
		Integer verificador2 =
				Integer.valueOf(String.valueOf(nroCuenta.charAt(0))) * 3 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(1))) * 9 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(2))) * 7 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(3))) * 1 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(4))) * 3 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(5))) * 9 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(6))) * 7 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(7))) * 1 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(8))) * 3 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(9))) * 9 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(10))) * 7 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(11))) * 1 +
				Integer.valueOf(String.valueOf(nroCuenta.charAt(12))) * 3; 
		verificador2 = (10 - verificador2 % 10) % 10; 
		String resultado = banco + sucursal + String.valueOf(verificador1) + nroCuenta + String.valueOf(verificador2);
		return resultado;
	}
}
