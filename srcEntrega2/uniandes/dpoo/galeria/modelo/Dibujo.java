package uniandes.dpoo.galeria.modelo;

public class Dibujo {
	private String medio;
	private String tecnica;
	private String estilo;
	private String tamaño;
	
	public Dibujo(String medio,String tecnica,String estilo,String tamaño) {
		this.medio = medio;
		this.tecnica = tecnica;
		this.estilo = estilo;
		this.tamaño = tamaño;
	}

	public String getMedio() {
		return medio;
	}

	public String getTecnica() {
		return tecnica;
	}

	public String getEstilo() {
		return estilo;
	}

	public String getTamaño() {
		return tamaño;
	}
	
	
}
