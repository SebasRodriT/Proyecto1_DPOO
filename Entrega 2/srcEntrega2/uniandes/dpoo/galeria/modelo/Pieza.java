package uniandes.dpoo.galeria.modelo;

import java.util.ArrayList;

public class Pieza {
	protected boolean vendida;
	protected String tituloObra;
	protected int año;
	protected String lugarCreacion;
	protected Artista autor;
	protected boolean exhibido;
	protected String tematica;
	
	//Agregar uml y get
	protected int precio;
	

	private ArrayList<Pieza> inventarioPiezas = new ArrayList<Pieza>();
	
	public Pieza(boolean vendida ,String tituloObra, int año,String lugarCreacion, Artista autor, boolean exhibido, String tematica, int precio) {
		this.vendida = vendida;
		this.tituloObra = tituloObra;
		this.año = año;
		this.lugarCreacion = lugarCreacion;
		this.autor = autor;
		this.exhibido = exhibido;
		this.tematica = tematica;
		this.precio = precio;

	}

	public boolean isVendida() {
		return vendida;
	}

	public String getTituloObra() {
		return tituloObra;
	}

	public int getAño() {
		return año;
	}

	public String getLugarCreacion() {
		return lugarCreacion;
	}

	public Artista getAutor() {
		return autor;
	}

	public boolean isExhibido() {
		return exhibido;
	}

	public String getTematica() {
		return tematica;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void marcarComoVendida() {
		this.vendida = true;
	}

	public void marcarComoDevolucion() {
		vendida = false;
	}
	
	public void agregarPiezainventario(Pieza pieza) {
    	this.inventarioPiezas.add(pieza);
    }
    
    public void eliminarPiezainventario(Pieza pieza) {
    	this.inventarioPiezas.remove(pieza);
    }
	
	public void buscarPiezaInventario(Pieza pieza) {
		Pieza piezaEncontrada = null;
    	String tituloObra = pieza.getTituloObra();
    	for (int i = 0; i < inventarioPiezas.size(); i++) {
    	    Pieza piezaLista = inventarioPiezas.get(i);
    	    if (piezaLista.getTituloObra().equals(tituloObra)) {
    	        piezaEncontrada = piezaLista;
    	        break; // Terminamos la búsqueda si encontramos la pieza
    	    }
    	}

    	// Verificar si se encontró la pieza y mostrar el resultado
    	if (piezaEncontrada != null) {
    	    System.out.println("Pieza encontrada: " + piezaEncontrada.getTituloObra());
    	    System.out.println("Autor pieza encontrada: " + piezaEncontrada.getAutor().getNombre());
    	    System.out.println("Año pieza encontrada: " + piezaEncontrada.getAño());
    	} else {
    	    System.out.println("Pieza no encontrada");
    	}
	}
	
	public Pieza buscarPieza(String nombre) {
		Pieza rta = null;
		for (int i = 0; i < inventarioPiezas.size(); i++) {
			Pieza pieza = inventarioPiezas.get(i);
			if (pieza.getTituloObra().equalsIgnoreCase(nombre)) {
				rta = pieza;
				return rta;
			}
		}
		return rta;
	}
}
