package uniandes.dpoo.galeria.modelo.usuario;



import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.Pieza;

public class Comprador extends Usuario {
    private int numeroTelefono;
    private String correo;
    private int valorMaxCompras;
    private HashMap<String, Integer> piezasCompradas;
    private HashMap<Pieza, String> listapieza;
    

    public Comprador(String nombre, int identificacion, int edad, String nombreUsuario, String password,
                     int numeroTelefono, String correo, int valorMaxCompras) {
        super(nombre, identificacion, edad, nombreUsuario, password, "Comprador");
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
    
    public void establecerLimiteCompras(Integer limite){
        this.valorMaxCompras = limite;

    }

    public HashMap<Pieza,String> getlistapiez (){
        return listapieza;
    }

     public void comprarPieza(String nombrePieza, Pieza pieza, int precioPieza) {

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
       
         
       
        piezasCompradas.put(idPieza, pieza.getPrecio());
        listapieza.put(pieza, pieza.getTituloObra());
       
        valorMaxCompras -= pieza.getPrecio();
    }

    public int getprecioPieza(String nombrePieza){
        Integer valor=0;
        for (Pieza key : listapieza.keySet()) {
            if (listapieza.get(key).equals(nombrePieza)){
                valor = key.getPrecio();
            }
        }
        return valor;
        
    }

}
    