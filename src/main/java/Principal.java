import java.util.Scanner;

import entidades.Alumno;
import manejadores.ManejadorPrincipal;
import manejadores.Acceso;

public class Principal {

	public static void main(String[] args) {

		boolean fin = false; // para controlar cuando termino de meter datos
		Scanner sc = new Scanner(System.in);
		String terminar; // para respuesta de si quieres terminar.

		Acceso acceso = new Acceso();

		// creamos la fábrica de sesiones.
		ManejadorPrincipal.inicioSessionFactory();

		System.out.println("INTRODUCE ALUMNOS");

		while (!fin) {
			// hay q crear alumno cada vez por id incremental.
			Alumno nuevoAlumno = new Alumno();
			System.out.print("Nombre del alumno: ");
			nuevoAlumno.setNombre(sc.nextLine());

			System.out.print("Apellidos del alumno: ");
			nuevoAlumno.setApellidos(sc.nextLine());

			System.out.print("Curso del alumno: ");
			nuevoAlumno.setCurso(sc.nextLine());

			System.out.print("Numero de asignaturas matriculadas del alumno: ");
			nuevoAlumno.setNum_asig_matric(sc.nextInt());

			System.out.print("Edad del alumno: ");
			nuevoAlumno.setEdad(sc.nextInt());
			sc.nextLine(); // para capturar el enter después del int y q no de error

			acceso.insertarAlumno(nuevoAlumno); // recogida información completa, la meto en BD

			System.out.println("TERMINAR?");
			System.out.println("[Pulsar SI para terminar o cualquier otra cosa para continuar]");
			terminar = sc.nextLine();
			if (terminar.equals("SI")) {
				fin = true;
			}
		}

		// cerramos sc
		sc.close();

		acceso.listarAlumnos();

		// cerramos la fábrica de sesiones.
		ManejadorPrincipal.finSessionFactory();

	}

}
