package uniandes.dpoo.galeria.modelo;

public class Video {
	private String calidadImagen;
	private String formatoVideo;
	private String relacionAspecto;
	
	public Video (String calidadImagen, String formatoVideo, String relacionAspecto) {
		this.calidadImagen = calidadImagen;
		this.formatoVideo = formatoVideo;
		this.relacionAspecto = relacionAspecto;
	}

	public String getCalidadImagen() {
		return calidadImagen;
	}

	public String getFormatoVideo() {
		return formatoVideo;
	}

	public String getRelacionAspecto() {
		return relacionAspecto;
	}
	
	
}
