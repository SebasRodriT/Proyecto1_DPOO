package uniandes.dpoo.galeria.modelo;

public class Pintura {
	private String tecnica;
	private String estilo;
	private double alto;
	private double ancho;
	
	public Pintura(String tecnica, String estilo, double alto, double ancho) {
		this.tecnica = tecnica;
		this.estilo = estilo;
		this.alto = alto;
		this.ancho = ancho;
	}

	public String getTecnica() {
		return tecnica;
	}

	public String getEstilo() {
		return estilo;
	}

	public double getAlto() {
		return alto;
	}

	public double getAncho() {
		return ancho;
	}
	
	
}
