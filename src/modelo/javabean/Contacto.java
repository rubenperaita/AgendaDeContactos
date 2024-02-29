package modelo.javabean;

import java.util.Objects;

public class Contacto {
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private String empresa;
	
	
	public Contacto(String nombre, String apellidos, String telefono, String email, String empresa) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.empresa = empresa;
	}


	public Contacto() {
		super();
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


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	@Override
	public int hashCode() {
		return Objects.hash(apellidos, email, empresa, nombre, telefono);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(email, other.email)
				&& Objects.equals(empresa, other.empresa) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}


	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", email=" + email
				+ ", empresa=" + empresa + "]";
	}
	
	
}
