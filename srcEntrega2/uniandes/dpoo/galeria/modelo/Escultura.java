package uniandes.dpoo.galeria.modelo;

import java.util.ArrayList;

public class Escultura {
	private double alto;
	private double ancho;
	private double peso;
	private boolean necesitaElectricidad;
	private ArrayList<String> materialesDeConstruccion = new ArrayList<String>();
	private ArrayList<String> elementosDeInstalacion = new ArrayList<String>();
	
	public Escultura(double alto, double ancho, double peso, boolean necesitaElectricidad) {
		this.alto = alto;
		this.ancho = ancho;
		this.peso = peso;
		this.necesitaElectricidad = necesitaElectricidad;
	}

	public double getAlto() {
		return alto;
	}

	public double getAncho() {
		return ancho;
	}

	public double getPeso() {
		return peso;
	}

	public boolean isNecesitaElectricidad() {
		return necesitaElectricidad;
	}
	
	
}
