package uniandes.dpoo.galeria.modelo.usuario;



import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.Pieza;

public class Comprador extends Usuario {
    private int numeroTelefono;
    private String correo;
    private int valorMaxCompras;
    private int saldo;
    private HashMap<String, String> piezasCompradas;

    public Comprador(String nombre, int identificacion, int edad, String nombreUsuario, String password,
                     int numeroTelefono, String correo, int valorMaxCompras, int saldo) {
        super(nombre, identificacion, edad, nombreUsuario, password);
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.valorMaxCompras = valorMaxCompras;
        this.piezasCompradas = new HashMap<>();
        this.saldo = saldo;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public int getValorMaxCompras() {
        return valorMaxCompras;
    }

     public void comprarPieza(String nombrePieza, Pieza pieza) {
       
        double precioPieza = pieza.getPrecio(); 
        if (precioPieza <= valorMaxCompras) {
            
           
            pieza.marcarComoVendida();
            if (pieza.isVendida()){
               
                registrarCompra(nombrePieza, pieza);
                System.out.println("La pieza ha sido comprada exitosamente.");
            } else {
                System.out.println("La compra no pudo ser realizada.");
            }
        } else {
            System.out.println("La compra excede el valor máximo de compras permitido.");
        }
    }
     
    public void actualizarSaldo(int valor) {
    	saldo-= valor;
    }
    public void agregarPieza(Pieza pieza) {
    	String nombre = pieza.getTituloObra();
    	String valor = String.valueOf(pieza.getPrecio());
    	piezasCompradas.put(nombre, valor);
    	valorMaxCompras -= pieza.getPrecio();
    }
  

    private void registrarCompra(String idPieza, Pieza pieza) {
       
    	String valor = String.valueOf(pieza.getPrecio());
        piezasCompradas.put(idPieza, valor);
        valorMaxCompras -= pieza.getPrecio();
        
    }}