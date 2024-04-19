package uniandes.dpoo.galeria.modelo.plataforma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.pago.Pago;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

public class Plataforma {

	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private HashMap<String, ArrayList<String>> mapaPagos = new HashMap<String, ArrayList<String>>();
	private Subasta subasta;
	
	public Plataforma() {
		subasta = new Subasta();
	}
	
	
	public void vender(Comprador comprador, Pieza pieza) {
		if (comprador.getSaldo() >= pieza.getPrecio()) {
			
		}
	}
	
	
	public Comprador subastar(Pieza pieza) {
		
		HashMap<String, HashMap<String, Integer>> ofertas = subasta.getOfertas();
		HashMap<String, Integer> ofertasPieza = ofertas.get(pieza.getTituloObra());
		String ganador = "";
		int mayor = -1;
		for (String nombre : ofertasPieza.keySet()) {
			Integer valor = ofertasPieza.get(nombre);
			int valorInt = valor.intValue();
			if (valorInt > mayor) {
					mayor = valorInt;
					ganador = nombre;		
			}}
		Comprador ganadorSubasta= encontrarComprador(ganador);
		Pago pago = new Pago(ganadorSubasta, mayor);
		ganadorSubasta.agregarPieza(pieza);
		return ganadorSubasta;
		
		
	} 
	
	public void registrarUsuario (Usuario usuario) {
		usuarios.add(usuario);
	}
		
	
	public void agregarPago(Comprador comprador, int precio) {
		
	}

	public Comprador encontrarComprador(String nombre) {
    	int i = 0;
    	Comprador comprador = null;
    	while (i<usuarios.size()) {
    		Usuario usuario = usuarios.get(i);
    		if (usuario.getNombre().equals(nombre)) {
    			comprador = (Comprador) usuario;
    			return comprador;}
    		i++;}
		return comprador;
    		}
    	
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
}