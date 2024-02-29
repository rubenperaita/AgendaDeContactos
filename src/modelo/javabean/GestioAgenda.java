package modelo.javabean;

import java.util.ArrayList;

public interface GestioAgenda {
	
	boolean altaContacto (Contacto contacto);
	boolean eliminarContacto (Contacto contacto);
	Contacto buscarUno (String nombre);
	Contacto buscarTelefono (String telefono);
	Contacto buscarEmail (String email);
	ArrayList<Contacto> buscarContactosPorTresPrimeros(String nombre);
	boolean cambiarDatos (Contacto contacto);
	ArrayList<Contacto> contactosPorEmpresa(String empresa);
	
}
