package uniandes.dpoo.galeria.modelo.usuario;

import java.util.HashMap;
import java.util.Scanner;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;
import uniandes.dpoo.galeria.modelo.plataforma.Subasta;

public class Usuario {
    protected String nombre;
    protected int identificacion;
    protected int edad;
    protected String nombreUsuario;
    protected String password;
    private String road;

    public Usuario(String nombre, int identificacion, int edad, String nombreUsuario, String password, String road) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.road = road;

    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

  
   public void ofertarSubasta(Pieza pieza, Usuario usuario) {
        Subasta subasta = new Subasta(pieza);

       
        
        if (subasta != null) {
            subasta.agregarOfertaSubasta(usuario, pieza.getPrecio(), pieza);
        }
    }


    public void ingresarPlataforma() {

        Scanner scanner = new Scanner(System.in);
       
       
        if ("Comprador".equals(road)) {
            System.out.println("Inicio de sesión exitoso en el comprador.");
            boolean salir = false;
            Comprador comprador = new Comprador(nombre, identificacion, edad, nombreUsuario, password, identificacion, nombre, edad);

            while (!salir) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Comprar Pieza");
                System.out.println("2. Establecer Límite de Compras");
                System.out.println("3. Salir");

                int opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre de la pieza que desea comprar:");
                        String nombrePieza = scanner.nextLine();
                        HashMap<Pieza,String> listapieza = comprador.getlistapiez();
                        Pieza pie = null;
                        for (Pieza key : listapieza.keySet()) {
                            if (listapieza.get(key).equals(nombrePieza)){
                                pie = key;

                            }
                        }
                        
                        Pieza pieza = pie;

                        System.out.println("Ingrese el precio de la pieza:");
                        int precioPieza = scanner.nextInt();
                        comprador.comprarPieza(nombrePieza, pieza, precioPieza);
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo límite de compras:");
                        int nuevoLimite = scanner.nextInt();
                        comprador.establecerLimiteCompras(nuevoLimite);
                        break;
                    case 3:
                        salir = true;
                        System.out.println("Saliendo de la consola de comprador...");
                        break;
                    default:
                        System.out.println("Opción no reconocida, por favor intente de nuevo.");
                        break;
                }
            }
        }
        else if ("Propietario".equals(road)) {
            System.out.println("Inicio de sesión exitoso en el propietario.");
            boolean salir = false;
            Propietario propietario = new Propietario(nombre, identificacion, edad, nombreUsuario, password, edad, nombre);
            

            while (!salir) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Agregar Pieza a Poseer");
                System.out.println("2. Agregar Pieza al Histórico de Ventas");
                System.out.println("3. Salir");

                int opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el ID de la pieza que desea agregar:");
                        String idPiezaPoseer = scanner.nextLine();
                        propietario.agregarPiezaQuePosee(idPiezaPoseer);
                        break;
                    case 2:
                        System.out.println("Ingrese el ID de la pieza vendida para agregar al histórico:");
                        String idPiezaVendida = scanner.nextLine();
                        propietario.agregarPiezaHistorico(idPiezaVendida);
                        break;
                    case 3:
                        salir = true;
                        System.out.println("Saliendo de la consola de propietario...");
                        break;
                    default:
                        System.out.println("Opción no reconocida, por favor intente de nuevo.");
                        break;
                }
            }
        } else {
            System.out.println("Inicio de sesión fallido del comprador.");
        }
        
        scanner.close();
    
    }
}

