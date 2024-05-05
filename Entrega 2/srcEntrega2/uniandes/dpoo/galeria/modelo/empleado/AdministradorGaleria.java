package uniandes.dpoo.galeria.modelo.empleado;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test.None;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

public class AdministradorGaleria extends Empleado {
	private static AdministradorGaleria administrador;
    private ArrayList<Pieza> inventario = new ArrayList<>();
    private HashMap<Integer, Comprador> compradoresRegistrados = new HashMap<>();
    private Plataforma plataforma;
    private static int limite = 1000000000;
  
    
    
    private AdministradorGaleria(String nombre, int identificacion, int edad) {
        super("Administrador", nombre, identificacion, edad);
        this.plataforma = Plataforma.obtenerInstancia();
    }
    
   
    
    public static synchronized AdministradorGaleria obternerAdmin() {
    	if (administrador == null) {
    		administrador = new AdministradorGaleria("Juan Garcia", 10654218, 38);
    	}
    	return administrador;
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

    public void confirmarVenta(Comprador comprador, Pieza pieza, String fecha) throws Exception {
       
            String nombrePieza = pieza.getTituloObra();
            plataforma.vender(comprador, pieza);
            pieza.marcarComoVendida(fecha);
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
    
    
        public void verificarOfertaCompra(Comprador comprador, Pieza pieza, String fecha) throws Exception {
            int valor = pieza.getPrecio();
            int oferta = comprador.getValorMaxCompras();
           
            if (oferta>=valor) {
                System.out.println("Oferta aceptada para la pieza: " + pieza.getTituloObra() + " por el comprador: " + comprador.getNombre());
                confirmarVenta(comprador, pieza, fecha);
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
}
