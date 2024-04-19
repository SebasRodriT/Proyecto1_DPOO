package uniandes.dpoo.galeria.modelo.empleado;

import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.usuario.Comprador;

import java.util.ArrayList;

public class CajeroGaleria extends Empleado {

   
    private HashMap<String, ArrayList<String>> registroPagos;

    public CajeroGaleria(String nombre, int identificacion, int edad) {
        super("Cajero", nombre, identificacion, edad);
        registroPagos = new HashMap<>();
    }

   
    public void registrarPago(Comprador comprador, String idPago, ArrayList<String> detallesPago) {
      
        if (comprador.completarPago(detallesPago)) {
           
            registroPagos.put(idPago, detallesPago);
          
            comprador.notificarPagoExitoso(idPago);
        } else {
           
            comprador.notificarPagoFallido(idPago);
        }
    }
   
    }
