package modelo.javabean;

import java.util.ArrayList;


public class AgendaContactos implements GestioAgenda {
	private String nombreAgenda;
	private ArrayList<Contacto> contactos;
	
	public AgendaContactos(){
		nombreAgenda = "Mi Agenda";
		contactos = new ArrayList<>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		contactos.add(new Contacto("Ruben", "Peraita", "663478475", "ruben@ifp.es", "ifp"));
		contactos.add(new Contacto("Tomas", "Escudero", "663485458", "tomas@ifp.es", "ifp"));
		contactos.add(new Contacto("Joking", "Mel", "679083875", "joking@ifp.es", "ifp"));
		contactos.add(new Contacto("Sofia Camila", "Samano", "642923854", "@ifp.es", "ifp"));
	}

	@Override
	public boolean altaContacto(Contacto contacto) {
		if (!contactos.contains(contacto)) {
			contactos.add(contacto);
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminarContacto(Contacto contacto) {
		return contactos.remove(contacto);
	}

	@Override
	public Contacto buscarUno(String nombre) {
		Contacto contacto = new Contacto();
		contacto.setNombre(nombre);
		int pos = contactos.indexOf(contacto);
		if (pos== -1)
		return null;
		else
			return contactos.get(pos);
	}

	@Override
	public Contacto buscarTelefono(String telefono) {
		for (Contacto ele: contactos) {
			if (telefono.equals(ele.getTelefono()))
				return ele;
			
		}
		return null;
	}

	@Override
	public Contacto buscarEmail(String email) {
		for (Contacto ele: contactos) {
			if (email.equals(ele.getEmail()))
				return ele;
		}
		return null;
	}

	@Override
	public ArrayList<Contacto> buscarContactosPorTresPrimeros(String nombre) {
		ArrayList<Contacto> resultados = new ArrayList<>();
	    for (Contacto ele : contactos) {
	        if (ele.getNombre().startsWith(nombre.substring(0, Math.min(nombre.length(), 3)))) {
	            resultados.add(ele);
	        }
	    }
	    return resultados;
	}

	@Override
	public boolean cambiarDatos(Contacto contacto) {
		int index = contactos.indexOf(contacto);
	    if (index != -1) {
	        contactos.set(index, contacto);
	        return true;
	    }
	    return false;
	}

	@Override
	public ArrayList<Contacto> contactosPorEmpresa(String empresa) {
		ArrayList<Contacto> resultados = new ArrayList<>();
	    for (Contacto ele : contactos) {
	        if (empresa.equals(ele.getEmpresa())) {
	            resultados.add(ele);
	        }
	    }
	    return resultados;
	}
	
	
	
}
