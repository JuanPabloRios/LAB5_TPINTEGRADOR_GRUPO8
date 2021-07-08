package LAB5_TPINTEGRADOR_GRUPO8.resources; 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder; 

// Esta clase nos crea los session factory
public class ConfigHibernate { 
	
	//Este es el metodo que usamos para obtener la sessionFactory instanciada.
	public static SessionFactory obtenerSessionFactory() { 
		Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
		return configuration.buildSessionFactory(serviceRegistry);
	} 
	
	//Este metodo cierra la conexion.
	public static void cerrarSessionFactory() {
		obtenerSessionFactory().close();
	}
}
