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

   
    public void registrarPago(Comprador comprador, String valor) {
      
        try { String idComprador = String.valueOf(comprador.getIdentificacion());
            registroPagos.put(idComprador, valor);
            
        } catch (Exception e) {
        	System.out.println("No se puso vender la pieza");
        	
    
        }
   
    }
    }

