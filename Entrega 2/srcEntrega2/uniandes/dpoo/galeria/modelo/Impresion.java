package uniandes.dpoo.galeria.modelo;

public class Impresion extends Pieza{
	private String tipoImpresion;
	private String calidad;
	private String tamaño;
	
	public Impresion(String tipoImpresion, String calidad,String tamaño, boolean vendida ,String tituloObra, int año,String lugarCreacion, Artista autor, boolean exhibido, String tematica) {
		super(vendida, tituloObra, año, lugarCreacion, autor, exhibido, tematica);
		this.tipoImpresion = tipoImpresion;
		this.calidad = calidad;
		this.tamaño = tamaño;
	}

	public String getTipoImpresion() {
		return tipoImpresion;
	}

	public String getCalidad() {
		return calidad;
	}

	public String getTamaño() {
		return tamaño;
	}
	
	
}
