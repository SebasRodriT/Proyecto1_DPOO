package uniandes.dpoo.galeria.modelo;

import java.util.ArrayList;

import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;

public class Inventario {
	private ArrayList<Pieza> inventarioPiezas = new ArrayList<Pieza>();
	private static Inventario inventario;
	
	public Inventario() {
	}
	
	public synchronized static Inventario obtenerInstanciaInv() {
        if (inventario == null) {
        	inventario = new Inventario();
        }
        return inventario;
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

	public Pieza buscarPieza(String nombrePieza) {
		for (Pieza nPieza: inventarioPiezas) {
			if (nPieza.getTituloObra().equalsIgnoreCase(nombrePieza)){
				return nPieza;
			}
		}
		return null;
	}

}
