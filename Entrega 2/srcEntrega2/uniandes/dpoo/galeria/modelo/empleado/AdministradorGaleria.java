package uniandes.dpoo.galeria.modelo.empleado;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void confirmarVenta(Comprador comprador, Pieza pieza) {
        if (inventario.contains(pieza) && compradoresRegistrados.containsKey(comprador.getIdentificacion())) {
            String nombrePieza = pieza.getTituloObra();
            comprador.comprarPieza(nombrePieza,pieza);
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
        // Esta implementación dependerá de cómo se definan los usuarios en su sistema.
        // Por ejemplo, podría ser una comprobación de estado o de permisos.
    }

    public void verificarOfertaCompra(Comprador comprador, Pieza pieza) {
        // Supongamos que esta es una verificación simple para ver si la oferta es aceptable.
        // La lógica específica dependerá de las reglas del negocio.
        if (comprador.hacerOferta(pieza) && pieza.aceptarOferta(comprador.getOferta())) {
            // La oferta del comprador es aceptada.
        }
    }

    public void establecerLimiteCompras(Comprador comprador, int limite) {
        if (compradoresRegistrados.containsKey(comprador.getIdentificacion())) {
            comprador.setLimiteCompras(limite);
        }
    }

    public void modificarLimiteCompras(Comprador comprador) {
        if (compradoresRegistrados.containsKey(comprador.getIdentificacion())) {
            int limiteActual = comprador.getLimiteCompras();
            comprador.setLimiteCompras((int) (limiteActual * 1.1)); // Aumenta el límite en un 10%
        }
    }
}