package manejadores;

import org.hibernate.Session;
import entidades.Alumno;

public class Acceso {

	public void insertarAlumno(Alumno alumno) {

		// abro la sesión
		Session session = ManejadorPrincipal.sessionFactory.openSession();
		// comienzo la transacción, la preparo.
		session.beginTransaction();
		// guardo el objeto
		session.persist(alumno);
		// sobre la base de datos usando la transacción persisto el objeto
		// es ahora cuando realmente se ejecuta la actualización de la BD
		session.getTransaction().commit();
		// cierro la sesion
		session.close();
	}

	public void listarAlumnos() {

		// abro la sesión
		Session session = ManejadorPrincipal.sessionFactory.openSession();
		int i = 1; // EN SQL el primer id es 1 (no es 0)
		// obtengo el primer alumno
		Alumno alumno = session.get(Alumno.class, i);
		// si el primer alumno existe lo imprimo y sigo sacando hasta q
		// no queden más (me devuelva get un null.)
		while (alumno != null) {
			System.out.println(alumno.toString());
			i++;
			alumno = session.get(Alumno.class, i);
		}
		// cierro la sesion
		session.close();

	}

	public Alumno getAlumno(int id) {
		// abro la sesión
		Session session = ManejadorPrincipal.sessionFactory.openSession();
		
		Alumno alumno=session.get(Alumno.class, id);
		
		// cierro la sesion
		session.close();
		
		return alumno;

	}

}
