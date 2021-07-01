package LAB5_TPINTEGRADOR_GRUPO8.resources; 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; 

public class ConfigHibernate {
	private static final SessionFactory sessionFactory = crearSessionFactory(); 

	@SuppressWarnings("deprecation")
	private static SessionFactory crearSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("No fie posible crear la SessionFactory " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory obtenerSessionFactory() { 
        return sessionFactory;
	} 
	
	public static void cerrarSessionFactory() {
		obtenerSessionFactory().close();
	}
}
