package uniandes.dpoo.galeria.modelo.plataforma;

import java.util.ArrayList;
import java.util.HashMap;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

public class Subasta {
	private static ArrayList<String> piezasSubastadas = new ArrayList<String>();
	private static ArrayList<String> usuariosSubasta = new ArrayList<String>();
	private static HashMap<String, HashMap<String, Integer>> ofertasAceptadasSubastas = new HashMap<String, HashMap<String, Integer>>();


	public Subasta(){}
	
	public void agregarPiezaASubastar(Pieza pieza) {
		
		if (!(ofertasAceptadasSubastas.containsKey(pieza.getTituloObra()))) {
			HashMap<String, Integer> ofertasPieza = new HashMap<String,  Integer>();
			ofertasAceptadasSubastas.put(pieza.getTituloObra(), ofertasPieza);
		}
	}
	
	public void agregarOfertaSubasta(Usuario usuario, int precio, Pieza pieza) {
		
		if (ofertasAceptadasSubastas.containsKey(pieza.getTituloObra())){
			HashMap<String, Integer> ofertasPieza = ofertasAceptadasSubastas.get(pieza.getTituloObra());
			ofertasPieza.put(usuario.getNombre(), precio);
			ofertasAceptadasSubastas.put(pieza.getTituloObra(), ofertasPieza);
		}
		
		
	}
	
	public HashMap<String, HashMap<String, Integer>> getOfertas(){
		return Subasta.ofertasAceptadasSubastas;
	}
	
	
	public void finalizar(Pieza pieza) {
		
		String nombre = pieza.getTituloObra();
		ofertasAceptadasSubastas.remove(nombre);
		
	}
}
