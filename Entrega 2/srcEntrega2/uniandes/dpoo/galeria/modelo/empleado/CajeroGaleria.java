package uniandes.dpoo.galeria.modelo.empleado;

import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.usuario.Comprador;


import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.pago.Pago;

public class CajeroGaleria extends Empleado {
    private Plataforma plataforma = new Plataforma();


   
    private HashMap<String, String>registroPagos;

    public CajeroGaleria(String nombre, int identificacion, int edad) {
        super("Cajero", nombre, identificacion, edad);
        registroPagos = new HashMap<>();
    }

   
    public boolean registrarPago(Comprador comprador, Pieza pieza, String idPago, String tipoPagoString) {
      
        try { plataforma.vender(comprador, pieza);
         int precio = pieza.getPrecio();    
         Pago pago = new Pago(comprador, precio);
         
           
            registroPagos.put(idPago, tipoPagoString);
            return true;
        } catch (Exception e) {
        	System.out.println("No se puso vender la pieza");
        	return false;
    
        }
   
    }
    }

