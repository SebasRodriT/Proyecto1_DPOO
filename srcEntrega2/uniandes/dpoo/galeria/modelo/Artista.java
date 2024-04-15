package uniandes.dpoo.galeria.modelo;

import java.util.ArrayList;

public class Artista {
	
	private String nombre;
	private String tipoArtista;
	private ArrayList<String> piezas = new ArrayList<String>();
	
	
	public Artista(String nombre, String tipoArtista) {
		this.nombre = nombre;
		this.tipoArtista = tipoArtista;
	}


	public String getNombre() {
		return nombre;
	}


	public String getTipoArtista() {
		return tipoArtista;
	}
	
	public void agregarPieza(Pieza pieza) {
		
	}
}
