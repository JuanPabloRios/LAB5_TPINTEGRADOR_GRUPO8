package LAB5_TPINTEGRADOR_GRUPO8.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeUsuarios;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;

@Controller
public class PrincipalController {
		
	
	public PrincipalController() {
		SessionFactory sessionFactory;
		//instancia de configuration(para configurar)
		Configuration configuration = new Configuration();
		configuration.configure();
		
		//con el getproperties obtenemos los datos del xml para crear la instancia de serviceRegistry
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		//construimos una sessionFactory mediante el configuration, que es una sesion hacia la DB 
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		//realizar consultas.
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		TiposDeUsuarios tpCliente = new TiposDeUsuarios();
		tpCliente.setDescripcion("Cliente");
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Ezequiel");
		usuario.setApellido("Rios");
		
		usuario.setTipoDeUsuario(tpCliente);
		
		session.save(tpCliente);
		session.save(usuario);
		
		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();
	}
	
	@RequestMapping("redireccionar_Principal.html")
	public ModelAndView redireccionarAPrincipal() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Principal");
		return mv;
	}
	
	@RequestMapping("redirigirLogin.html")
	public ModelAndView redirigirAHome(String txtUsuario, String txtClave) {
		System.out.println("Usuario " + txtUsuario);
		System.out.println("Clave " + txtClave);
		//ACA VA LA BUSQUEDA DE USER Y PASS Y SEGUN RESULTADO REDIRIGE A ALGUN HOME O A ERROR
		
		
		
		//VOY A REDIRECCIONAR A LA PAGINA HOME DEL ADMIN POR AHORA
		ModelAndView mv = new ModelAndView();
		mv.addObject("nombreCuenta","Nombre y Apellido");
		mv.setViewName("AdministradorHome");
		return mv;
	} 
}
