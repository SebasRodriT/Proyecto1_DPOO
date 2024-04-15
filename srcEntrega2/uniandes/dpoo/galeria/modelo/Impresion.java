package uniandes.dpoo.galeria.modelo;

public class Impresion {
	private String tipoImpresion;
	private String calidad;
	private String tamaño;
	
	public Impresion(String tipoImpresion, String calidad,String tamaño) {
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
