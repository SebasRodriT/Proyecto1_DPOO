package uniandes.dpoo.galeria.modelo.plataforma;

import java.util.ArrayList;
import java.util.HashMap;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

public class Subasta {
	private ArrayList<String> piezasSubastadas = new ArrayList<String>();
	private ArrayList<String> piezasASubastar = new ArrayList<String>();
	private ArrayList<String> usuariosSubasta = new ArrayList<String>();
	private HashMap<String, HashMap<Comprador, Integer>> ofertasSubasta = new HashMap<String, HashMap<Comprador, Integer>>();
	private HashMap<String, HashMap<Comprador, Integer>> ofertasAceptadasSubastas = new HashMap<String, HashMap<Comprador, Integer>>();

	public Subasta() {}
	
	public void agregarPiezaSubastada(Pieza pieza) {
		
	}
	
	public void agregarPiezaASubastar(Pieza pieza) {
		
	}
	
	public void agregarOfertaSubasta(Usuario usuario, int precio) {
		
	}
	
	
}
