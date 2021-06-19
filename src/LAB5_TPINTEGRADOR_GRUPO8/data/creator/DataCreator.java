package LAB5_TPINTEGRADOR_GRUPO8.data.creator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeUsuarios;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario;

public class DataCreator {
	public static void createData() {
		SessionFactory sessionFactory;
		//instancia de configuration(para configurar)
		Configuration configuration = new Configuration();
		configuration.configure(); 
		//con el getproperties obtenemos los datos del xml para crear la instancia de serviceRegistry
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
		//construimos una sessionFactory mediante el configuration, que es una sesion hacia la DB 
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		 
		Session session = sessionFactory.openSession(); 
		session.beginTransaction(); 
		
		TiposDeUsuarios tpCliente = new TiposDeUsuarios();
		tpCliente.setDescripcion("Cliente");
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Ezequiel");
		usuario.setApellido("Rios");
		usuario.setContrasenia("pepe");
		usuario.setDireccion("Av. Siempreviva 123");
		usuario.setDNI(32444555);
		usuario.setEstado("1");
		usuario.setNacionalidad("Argentino");
		usuario.setSexo("M");
		usuario.setUsuario("gato");  
		usuario.setTipoDeUsuario(tpCliente); 
		session.save(tpCliente);
		session.save(usuario);
		
		session.getTransaction().commit();
		session.close(); 
		sessionFactory.close();
	}
}
