package uniandes.dpoo.galeria.modelo;

import java.util.ArrayList;

public class Pieza {
	private boolean vendida;
	private String tituloObra;
	private int año;
	private String lugarCreacion;
	private Artista autor;
	private boolean exhibido;
	private String tematica;
	private ArrayList<String> inventarioPiezas = new ArrayList<String>();
	
	public Pieza(boolean vendida ,String tituloObra, int año,String lugarCreacion, Artista autor, boolean exhibido, String tematica) {
		this.vendida = vendida;
		this.tituloObra = tituloObra;
		this.año = año;
		this.lugarCreacion = lugarCreacion;
		this.autor = autor;
		this.exhibido = exhibido;
		this.tematica = tematica;
	}

	public boolean isVendida() {
		return vendida;
	}

	public String getTituloObra() {
		return tituloObra;
	}

	public int getAño() {
		return año;
	}

	public String getLugarCreacion() {
		return lugarCreacion;
	}

	public Artista getAutor() {
		return autor;
	}

	public boolean isExhibido() {
		return exhibido;
	}

	public String getTematica() {
		return tematica;
	}
	
	
}
