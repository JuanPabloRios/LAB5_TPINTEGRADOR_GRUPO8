package LAB5_TPINTEGRADOR_GRUPO8.controller;
import LAB5_TPINTEGRADOR_GRUPO8.data.creator.*; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView; 
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;
import LAB5_TPINTEGRADOR_GRUPO8.selector.CuentaSelector;
import LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector; 

//Controlador de la vista Principal
@Controller
public class PrincipalController { 
	
	//Metodo inicial, es el que toma Spring para redireccionar a la pantalla de login
	@RequestMapping("redireccionar_Principal.html")
	public ModelAndView redireccionarAPrincipal() {
		DataCreator.createData();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Principal");
		return mv;
	}
	
	//Handler del boton de login, valida el usuario y redirige a cada home o devuelve un error
	@RequestMapping("redirigirLogin.html")
	public ModelAndView redirigirAHome(String txtUsuario, String txtClave) {   
		Usuario us = UsuarioSelector.obtenerUsuarioPorNombreDeUsuario(txtUsuario); 
		Boolean errorDeUsuario = false;
		if(us == null ) { 
			errorDeUsuario = true;
		} else if(!txtClave.equals(us.getContrasenia())) {
			errorDeUsuario = true; 
		} 
		ModelAndView mv = new ModelAndView();
		if(errorDeUsuario) { 
			mv.addObject("errorDeUsuario",true);
			mv.setViewName("Principal");
		} else {  
			mv.addObject("nombreCuenta",us.getNombre() + " " + us.getApellido());
			mv.addObject("usuario",us);
			if(us.getTipoDeUsuario().getDescripcion().equals("Administrador")) {
				mv.addObject("listaClientes",UsuarioSelector.obtenerTodosLosClientes());
				mv.setViewName("AdministradorHome");
			} else {
				mv.addObject("listaCuentas", CuentaSelector.obtenerTodasLasCuentasDeClientePorId(us.getIdusuario()));  
				mv.setViewName("HomeCliente");
			} 
		} 
		return mv;
	} 
}
