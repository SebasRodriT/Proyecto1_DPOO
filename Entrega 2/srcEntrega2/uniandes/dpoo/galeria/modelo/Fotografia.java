package uniandes.dpoo.galeria.modelo;

public class Fotografia extends Pieza {
	//Pruuebas
	private String calidad;
	private boolean color;
	
	public Fotografia(String calidad,boolean color, boolean vendida ,String tituloObra, int año,String lugarCreacion, Artista autor, boolean exhibido, String tematica) {
		super(vendida, tituloObra, año, lugarCreacion, autor, exhibido, tematica);
		this.calidad = calidad;
		this.color = color;
	}

	public String getCalidad() {
		return calidad;
	}

	public boolean isColor() {
		return color;
	}
}
