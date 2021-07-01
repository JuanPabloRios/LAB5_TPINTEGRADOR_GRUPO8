package LAB5_TPINTEGRADOR_GRUPO8.resources; 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; 

//Esta clase nos crea un solo sessionFactory que utilizamos en cada conexion con la bd.
public class ConfigHibernate {
	//La variable static final en combinacion con el metodo crearSessionFactory forman 
	// el patron de disenio singletone para usar siempre la misma instancia.
	private static final SessionFactory sessionFactory = crearSessionFactory(); 
	
	//este metodo es el que crea la instancia del SessionFactory
	@SuppressWarnings("deprecation")
	private static SessionFactory crearSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("No fie posible crear la SessionFactory " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	//Este es el metodo que usamos para obtener la sessionFactory instanciada.
	public static SessionFactory obtenerSessionFactory() { 
        return sessionFactory;
	} 
	
	//Este metodo cierra la conexion.
	public static void cerrarSessionFactory() {
		obtenerSessionFactory().close();
	}
}
