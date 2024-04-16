package uniandes.dpoo.galeria.modelo;

public class Fotografia {
	private String calidad;
	private boolean color;
	
	public Fotografia(String calidad,boolean color) {
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
