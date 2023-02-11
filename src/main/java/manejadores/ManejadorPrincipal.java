package manejadores;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ManejadorPrincipal {

	// único atributo estático.
	protected static SessionFactory sessionFactory;

	public static void inicioSessionFactory() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println(ex); // imprime la excepción.
		}
	}

	public static void finSessionFactory() {
		sessionFactory.close();
	}

}
