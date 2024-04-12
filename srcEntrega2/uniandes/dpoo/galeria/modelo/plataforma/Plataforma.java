package uniandes.dpoo.galeria.modelo.plataforma;

import java.util.ArrayList;
import java.util.HashMap;

public class Plataforma {

	private ArrayList<String> usuarios = new ArrayList<String>();
	private HashMap<String, ArrayList<String>> mapaPagos = new HashMap<String, ArrayList<String>>();
	
	public Plataforma() {}
	
	public void vender(Comprador comprador, Pieza pieza) {
	}
	public void subastar(Comprador comprador, Pieza pieza) {
		
	} 
	public void agregarUsuario(Usuario usuario) {
		
	}
	public void agregarPago(Comprador comprador, int precio) {
		
	}
}
