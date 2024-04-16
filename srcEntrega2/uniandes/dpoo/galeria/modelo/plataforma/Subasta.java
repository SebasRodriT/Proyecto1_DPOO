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
	private HashMap<String, HashMap<String, Integer>> ofertasAceptadasSubastas = new HashMap<String, HashMap<String, Integer>>();

	public Subasta() {}
	
	public void agregarPiezaSubastada(Pieza pieza) {
		
	}
	
	public void agregarPiezaASubastar(Pieza pieza) {
		
		if (!ofertasAceptadasSubastas.containsKey(pieza.getNombre())) {
			HashMap<String, HashMap<String, Integer>> ofertasPieza = new HashMap<String, HashMap<String, Integer>>();
			ofertasAceptadasSubastas.put(pieza.getNombre(), ofertasPieza);
		}
	}
	
	public void agregarOfertaSubasta(Usuario usuario, int precio, Pieza pieza) {
		
		if (ofertasAceptadasSubastas.containsKey(pieza.getNombre())){
			HashMap<String, Integer> ofertasPieza = ofertasAceptadasSubastas.get(pieza.getNombre());
			ofertasPieza.put(usuario.getNombre(), precio);
			ofertasAceptadasSubastas.put(pieza.getNombre(), ofertasPieza);
		}
		
		
	}
	
	public HashMap<String, HashMap<String, Integer>> getOfertas(){
		return this.ofertasAceptadasSubastas;
	}
	
	
	
}
