package uniandes.dpoo.galeria.modelo.plataforma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

public class Plataforma {

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private HashMap<String, ArrayList<String>> mapaPagos = new HashMap<String, ArrayList<String>>();
	private Subasta subasta;
	
	public Plataforma() {
		subasta = new Subasta();
	}
	
	
	public void vender(Comprador comprador, Pieza pieza) {
		if (comprador.getSaldo() >= pieza.getPrecio()) {
			//hacerpago
			//descontarsaldo
		}
	}
	
	
	public String subastar(Pieza pieza) {
		
		HashMap<String, HashMap<String, Integer>> ofertas = subasta.getOfertas();
		HashMap<String, Integer> ofertasPieza = ofertas.get(pieza.getNombre());
		String ganador = "";
		int mayor = -1;
		for (String nombre : ofertasPieza.keySet()) {
			Integer valor = ofertasPieza.get(nombre);
			int valorInt = valor.intValue();
			if (valorInt > mayor) {
					mayor = valorInt;
					ganador = nombre;		
			}}
		//Encontar cliente
		//hacerPago
		//agregarpieza
		return ganador;
		
		
	} 
	public void agregarUsuario(Usuario usuario) {
		
		usuarios.add(usuario);
		
	}
	public void agregarPago(Comprador comprador, int precio) {
		
	}
}