package aplicaciones;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.javabean.AgendaContactos;
import modelo.javabean.Contacto;

public class AppGestinAgenda {

    private static AgendaContactos adao;
    private static Scanner leer;

    static {
        adao = new AgendaContactos();
        leer = new Scanner(System.in);
    }

    public static void main(String[] args) {
        procAltaContacto();
        procBuscarUno();
        procBuscarTelefono();
        procBuscarEmail();
        procBuscarPorTresPrimeros();
        procCambiarDatos();
        procContactosPorEmpresa();
        procEliminarContacto();
    }

    public static void procAltaContacto() {
        System.out.println("Ingrese datos del contacto:");
        Contacto contacto = new Contacto();
        contacto.setNombre(leer.next());
        contacto.setApellidos(leer.next());
        contacto.setEmail(leer.next());
        contacto.setEmpresa(leer.next());
        contacto.setTelefono(leer.next());
        if (adao.altaContacto(contacto)) {
            System.out.println("Alta realizada con �xito.");
        } else {
            System.out.println("Problemas al dar de alta al contacto.");
        }
    }

    public static void procEliminarContacto() {
        System.out.println("Ingrese el nombre del contacto a eliminar:");
        String nombre = leer.next();
        Contacto contacto = adao.buscarUno(nombre);
        if (contacto != null) {
            if (adao.eliminarContacto(contacto)) {
                System.out.println("Contacto eliminado con �xito.");
            } else {
                System.out.println("Problemas al eliminar el contacto.");
            }
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }
    public static void procBuscarUno() {
        System.out.println("Ingrese el nombre del contacto a buscar:");
        String nombre = leer.next();
        Contacto contacto = adao.buscarUno(nombre);
        if (contacto != null) {
            System.out.println("Contacto encontrado: " + contacto);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public static void procBuscarTelefono() {
        System.out.println("Ingrese el n�mero de tel�fono a buscar:");
        String telefono = leer.next();
        Contacto contacto = adao.buscarTelefono(telefono);
        if (contacto != null) {
            System.out.println("Contacto encontrado: " + contacto);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public static void procBuscarEmail() {
        System.out.println("Ingrese el email a buscar:");
        String email = leer.next();
        Contacto contacto = adao.buscarEmail(email);
        if (contacto != null) {
            System.out.println("Contacto encontrado: " + contacto);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public static void procBuscarPorTresPrimeros() {
        System.out.println("Ingrese los tres primeros caracteres del nombre a buscar:");
        String tresPrimeros = leer.next();
        ArrayList<Contacto> resultados = adao.buscarContactosPorTresPrimeros(tresPrimeros);
        if (!resultados.isEmpty()) {
            System.out.println("Contactos encontrados: " + resultados);
        } else {
            System.out.println("Ning�n contacto encontrado.");
        }
    }

    public static void procCambiarDatos() {
        System.out.println("Ingrese el nombre del contacto a modificar:");
        String nombre = leer.next();
        Contacto contacto = adao.buscarUno(nombre);
        if (contacto != null) {
            System.out.println("Ingrese los nuevos datos del contacto:");
            contacto.setNombre(leer.next());
            contacto.setApellidos(leer.next());
            contacto.setEmail(leer.next());
            contacto.setEmpresa(leer.next());
            contacto.setTelefono(leer.next());
            if (adao.cambiarDatos(contacto)) {
                System.out.println("Datos cambiados con �xito.");
            } else {
                System.out.println("Problemas al cambiar los datos del contacto.");
            }
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public static void procContactosPorEmpresa() {
        System.out.println("Ingrese el nombre de la empresa para buscar contactos:");
        String empresa = leer.next();
        ArrayList<Contacto> resultados = adao.contactosPorEmpresa(empresa);
        if (!resultados.isEmpty()) {
            System.out.println("Contactos de la empresa " + empresa + ": " + resultados);
        } else {
            System.out.println("Ning�n contacto encontrado para la empresa " + empresa + ".");
        }
    }
    
}