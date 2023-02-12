package manejadores;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ManejadorPrincipal {

	// único atributo estático sobre el que ataco la BD, para las sesiones que voy a
	// usar cada vez que acceda a la BD.
	protected static SessionFactory sessionFactory;

	// métodos para generar la "fábrica" de sesiones y cerrarla.
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
