package uniandes.dpoo.galeria.consola;

import java.util.ArrayList;
import java.util.Scanner;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.empleado.AdministradorGaleria;

public class ConsolaAdministrador {
	
	
    public static void main(String[] args) {
    	AdministradorGaleria administrador = AdministradorGaleria.obternerAdmin();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Menú que se muestra en bucle hasta que el usuario elige salir
        while (true) {
            // Imprime el menú
            System.out.println("Menú:");
            System.out.println("1. Ingresar una pieza al inventario");
            System.out.println("2. Confirmar venta Pieza");
            System.out.println("3. Confirmar devolucion Pieza");
            System.out.println("4. Ver historia de una Pieza");
            System.out.println("5. Ver historia de un Artista");
            System.out.println("6. Ver historia de un Comprador");
            System.out.println("7. Guardar administrador");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            
         
            opcion = scanner.nextInt();
            
           
            if (opcion == 1) {
                System.out.println("Has seleccionado la Opción 1.");
                //pendiente condicionales tipos pieza
        
                
            } else if (opcion == 2) {
                System.out.println("Has seleccionado la Opción 2.");
                System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
                String nombrePieza = scanner.nextLine();
                boolean rta = administrador.confirmarVenta(nombrePieza);
                if (rta == true) {
                	System.out.println("La pieza consultada ya fue vendida");
                } else {
                	System.out.println("La pieza consultada NO ha sido vendida");
                }
              
            } else if (opcion == 3) {
                System.out.println("Has seleccionado la Opción 3.");
                System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
                String nombrePieza = scanner.nextLine();
                boolean rta = administrador.confirmarDevolucion(nombrePieza);
                if (rta == true) {
                	System.out.println("La pieza consultada ha sido devuelta por el comprador anterior");
                } else {
                	System.out.println("La pieza consultada NO ha sido devuelta a la galeria");
                }
                
                
            } else if (opcion == 4) {
                System.out.println("Has seleccionado la Opción 4.");
                System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
                String nombrePieza = scanner.nextLine();
                Pieza rta = administrador.ConsultarPieza(nombrePieza);
                System.out.println("La pieza" + rta.getTituloObra()+ "fue creada en " + rta.getLugarCreacion() + 
                		" en el año de "+ rta.getAño() + " por " + rta.getAutor().getNombre() + 
                		"\n La tematica de la pieza es " + rta.getTematica());
                if (rta.isVendida() == true) {
                	System.out.println("La pieza fue vendida por un valor de " + rta.getPrecio() + " el dia " + rta.getFecha() +
                			".\n El dueño actual es "); //agregar dueño
                }else {
                    System.out.println("La pieza no ha sido vendida. Tiene un valor de " + rta.getPrecio());
                }
             
                
            } else if (opcion == 5) {
                System.out.println("Has seleccionado la Opción 5.");
                System.out.print("Por favor, ingresa el nombre del Artista a consultar: ");
                String nombreArtista = scanner.nextLine();
                ArrayList<Pieza> rta = administrador.consultarHistoriaArtista(nombreArtista);
                if (rta == null) {
                	System.out.println("El artista NO tiene o ha tenido ninguna pieza en la galeria");
                } else {
                	for (Pieza p: rta) {
                		
                		if (p.isVendida() == true) {
                		System.out.println("La pieza " + p.getTituloObra() + " fue hecha en el año de " + p.getAño() + ".\n "
                		+ "Fue vendida por un valor de " + p.getPrecio() + " el dia " + p.getFecha() );} 
                		else {
                		System.out.println("La pieza " + p.getTituloObra() + " fue hecha en el año de " + p.getAño() + ".\n "+
                		"La pieza no ha sido vendida y tiene un valor de " + p.getPrecio());
                			}
                	}
                }
                
                
            } else if (opcion == 6) {
                System.out.println("Has seleccionado la Opción 6.");
                //cosultar como funciona historia de un comprador 
                
            } else if (opcion == 7) {
                System.out.println("Has seleccionado la Opción 7.");
                //implementar persistencia
                
            } else if (opcion == 8) {
                System.out.println("Saliendo del programa...");
                
                scanner.close();
                return;
            } else {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }

            System.out.println();
        }
    }
}
