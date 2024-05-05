package uniandes.dpoo.galeria.modelo;


public class Pieza {
	protected boolean vendida;
	protected String tituloObra;
	protected int año;
	protected String lugarCreacion;
	protected Artista autor;
	protected boolean exhibido;
	protected String tematica;

	protected int precio;
	
	
	public Pieza(boolean vendida ,String tituloObra, int año,String lugarCreacion, Artista autor, boolean exhibido, String tematica, int precio) {
		this.vendida = vendida;
		this.tituloObra = tituloObra;
		this.año = año;
		this.lugarCreacion = lugarCreacion;
		this.autor = autor;
		this.exhibido = exhibido;
		this.tematica = tematica;
		this.precio = precio;

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
	
	public int getPrecio() {
		return precio;
	}
	
	public void marcarComoVendida() {
		this.vendida = true;
	}

	public void marcarComoDevolucion() {
		vendida = false;
	}
}
