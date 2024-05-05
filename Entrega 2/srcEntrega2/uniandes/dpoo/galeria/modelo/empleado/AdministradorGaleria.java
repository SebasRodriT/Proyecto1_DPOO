package uniandes.dpoo.galeria.modelo.empleado;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test.None;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

public class AdministradorGaleria extends Empleado {
    private ArrayList<Pieza> inventario = new ArrayList<>();
    private HashMap<Integer, Comprador> compradoresRegistrados = new HashMap<>();
    private Plataforma plataforma = new Plataforma();
    private static int limite = 1000000000;

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

    public void confirmarVenta(Comprador comprador, Pieza pieza) throws Exception {
       
            String nombrePieza = pieza.getTituloObra();
            plataforma.vender(comprador, pieza);
            pieza.marcarComoVendida();
            inventario.remove(pieza);
            comprador.agregarPieza(pieza);
            
        
    }

    public void registrarDevolucion(Comprador comprador, Pieza pieza) {
        if (!inventario.contains(pieza)) {
            pieza.marcarComoDevolucion();
            inventario.add(pieza);
            hacerDevolucion(comprador, pieza.getPrecio());
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
        	System.out.println("El usuario " + usuario.getNombre() + " está autorizado.");
        } else {
            
            if (!usuarioActivo) {
                System.out.println("El usuario " + usuario.getNombre() + " está bloqueado.");
            }
            if (!usuarioAutorizado) {
                System.out.println("El usuario " + usuario.getNombre() + " no tiene los permisos necesarios.");
            }
        }
    }
    
    
        public void verificarOfertaCompra(Comprador comprador, Pieza pieza) throws Exception {
            int valor = pieza.getPrecio();
            int oferta = comprador.getValorMaxCompras();
           
            if (oferta>=valor) {
                System.out.println("Oferta aceptada para la pieza: " + pieza.getTituloObra() + " por el comprador: " + comprador.getNombre());
                confirmarVenta(comprador, pieza);
            } else {
                System.out.println("Oferta rechazada o inválida para la pieza: " + pieza.getTituloObra() + " por el comprador: " + comprador.getNombre());
            }
        }

    public void establecerLimiteCompras(Comprador comprador) {
        
            comprador.establecerLimiteCompras(limite);
    }

    public int modificarLimiteCompras(Comprador comprador) {
        
            if (comprador.getSaldo() > comprador.getValorMaxCompras()) {
            	return comprador.getSaldo();
            }
			return comprador.getValorMaxCompras();
        
    }
    
    public void hacerDevolucion(Comprador comprador, int valor) {
    	comprador.actualizarSaldoDevolucion(valor);
    }
    
    //Requerimiento 3: Proyecto 2
    // Verificar Historia Comprador: Historia de piezas que ha comprado
    public void historiaPiezasCompradas(Comprador comprador, String fecha) {
    	ArrayList<Pieza> piezas = comprador.getPiezasCompradas();
    	System.out.println("Nombre: " + comprador.getNombre());
    	System.out.println("Nombre Usuario: " + comprador.getNombreUsuario());
    	for (int i = 0; i < piezas.size(); i++) {
            String elemento = piezas.get(i).getTituloObra();
            System.out.println("Titulo Obra:" + elemento);
        }
    }
    
    //Verificar historia de coleeccion: Historia de piezas que posee
    public void historiaPiezasColeccion(Comprador comprador, String fecha) {
    	ArrayList<Pieza> piezas = comprador.getPiezasCompradas();
    	System.out.println("Nombre: " + comprador.getNombre());
    	System.out.println("Nombre Usuario: " + comprador.getNombreUsuario());
    	for (int i = 0; i < piezas.size(); i++) {
            String elemento = piezas.get(i).getTituloObra();
            System.out.println("Titulo Obra:" + elemento);
        }
    }
    
}

