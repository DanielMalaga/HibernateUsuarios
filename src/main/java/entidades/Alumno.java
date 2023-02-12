package entidades;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // estamos usando anotaciones de hibernate
@Table(name = "usuario")
public class Alumno implements Serializable {
	// los nombres de columnas serán iguales a los atributos de
	// la clase, por lo que no hace falta especificar column.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // clave primaria mismo nombre.

	// resto de atributos.
	private String nombre;
	private String apellidos;
	private String curso;
	private int num_asig_matric;
	private int edad;

	// getter y setter de todos los atributos.
	// excepción: setter de id al ser autoincremental.
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getNum_asig_matric() {
		return num_asig_matric;
	}

	public void setNum_asig_matric(int num_asig_matric) {
		this.num_asig_matric = num_asig_matric;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return ("[ID: " + this.id + ", NOMBRE Y APELLIDOS: " + this.nombre + " " + this.apellidos + ", CURSO: "
				+ this.curso + ", NUM ASIGNATURAS MATRICULADO: " + this.num_asig_matric + ", EDAD: " + this.edad + "]");
	}

}
