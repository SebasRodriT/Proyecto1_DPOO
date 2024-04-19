package uniandes.dpoo.galeria.modelo.empleado;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test.None;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

public class AdministradorGaleria extends Empleado {
    private ArrayList<Pieza> inventario = new ArrayList<>();
    private HashMap<Integer, Comprador> compradoresRegistrados = new HashMap<>();

    public AdministradorGaleria(String nombre, int identificacion, int edad) {
        super("Administrador", nombre, identificacion, edad);
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getIdentificacion() {
        return this.identificacion;
    }

    public int getEdad() {
        return this.edad;
    }

    public void registrarPiezaInventario(Pieza pieza) {
        inventario.add(pieza);
    }

    public void confirmarVenta(Comprador comprador, Pieza pieza, Integer precio) {
        if (inventario.contains(pieza) && compradoresRegistrados.containsKey(comprador.getIdentificacion())) {
            String nombrePieza = pieza.getTituloObra();
            comprador.comprarPieza(nombrePieza,pieza,precio);
            pieza.marcarComoVendida();
            inventario.remove(pieza);
        }
    }

    public void registrarDevolucion(Pieza pieza) {
        if (!inventario.contains(pieza)) {
            pieza.marcarComoDevolucion();
            inventario.add(pieza);
        }
    }

    public void verificarUsuario(Usuario usuario) {
        boolean usuarioActivo = false;
        boolean usuarioAutorizado = false;

        if (usuario.getNombre()!= null || usuario.getIdentificacion()!= 0 || usuario.getPassword()!= null){
             usuarioActivo = true;
             usuarioAutorizado = true;

        }
    
        if (usuarioActivo && usuarioAutorizado) {
            System.out.println("Usuario verificado con éxito: " + usuario.getNombre());
        } else {
            
            if (!usuarioActivo) {
                System.out.println("El usuario " + usuario.getNombre() + " está bloqueado.");
            }
            if (!usuarioAutorizado) {
                System.out.println("El usuario " + usuario.getNombre() + " no tiene los permisos necesarios.");
            }
        }
    }
    
    
        public void verificarOfertaCompra(Comprador comprador, Pieza pieza) {
            String nombrePieza = pieza.getTituloObra();
            
            int valor = comprador.getprecioPieza(pieza.getTituloObra());
            
           
            if (valor != 0) {
                System.out.println("Oferta aceptada para la pieza: " + pieza.getTituloObra() + " por el comprador: " + comprador.getNombre());
            } else {
                System.out.println("Oferta rechazada o inválida para la pieza: " + pieza.getTituloObra() + " por el comprador: " + comprador.getNombre());
            }
        }

    public void establecerLimiteCompras(Comprador comprador, int limite) {
        if (compradoresRegistrados.containsKey(comprador.getIdentificacion())) {
            comprador.establecerLimiteCompras(limite);
        }
    }

    public void modificarLimiteCompras(Comprador comprador) {
        if (compradoresRegistrados.containsKey(comprador.getIdentificacion())) {
            int limiteActual = comprador.getValorMaxCompras();
            comprador.establecerLimiteCompras((int) (limiteActual * 1.1)); 
        }
    }
}

