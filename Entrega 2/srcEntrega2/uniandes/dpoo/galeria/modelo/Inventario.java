package uniandes.dpoo.galeria.modelo;

import java.util.ArrayList;

public class Inventario {
	private ArrayList<Pieza> inventarioPiezas = new ArrayList<Pieza>();
	
	public Inventario() {
	}
	
	public void agregarPiezainventario(Pieza pieza) {
		this.inventarioPiezas.add(pieza);
	}
	
	public void eliminarPiezainventario(Pieza pieza) {
    	this.inventarioPiezas.remove(pieza);
    }
	
	public ArrayList<Pieza> getInventarioPiezas() {
		return inventarioPiezas;
	}


}
