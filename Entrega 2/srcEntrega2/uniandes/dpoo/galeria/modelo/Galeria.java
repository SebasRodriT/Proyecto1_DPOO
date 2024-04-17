package uniandes.dpoo.galeria.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Galeria {
	private String ubicacion;
	private int cantidadPiezas;
	private ArrayList<Pieza> piezasExhibidas = new ArrayList<Pieza>();
    private ArrayList<Pieza> piezasBodega = new ArrayList<Pieza>();
    private HashMap<String, Pieza> historicoPiezas = new HashMap<String, Pieza>();

    public Galeria(String ubicacion, int cantidadPiezas) {
    	this.ubicacion = ubicacion;
    	this.cantidadPiezas = cantidadPiezas;
    }

	public String getUbicacion() {
		return ubicacion;
	}

	public int getCantidadPiezas() {
		return cantidadPiezas;
	}
    
    public void verificarComprador(Comprador comprador) {
    	String nombreUsuario = usuario.
    	if ()
    	
    }
    
    public void agregarPiezaExhibida(Pieza pieza) {
    	this.piezasExhibidas.add(pieza);
    }
    
    public void agregarPiezaBodega(Pieza pieza) {
    	this.piezasBodega.add(pieza);
    }
    
    public void agregarPiezaHistorico(Pieza pieza) {
    	//To do:
    	
    }
    
    public void eliminarPiezaExhibida(Pieza pieza) {
    	this.piezasExhibidas.remove(pieza);
    }
    
    public void eliminarPiezaBodega(Pieza pieza) {
    	this.piezasBodega.remove(pieza);
    }
    
    public void buscarPiezaExhibida(Pieza pieza) {
    	Pieza piezaEncontrada = null;
    	String tituloObra = pieza.getTituloObra();
    	for (int i = 0; i < piezasExhibidas.size(); i++) {
    	    Pieza piezaLista = piezasExhibidas.get(i);
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
    	
    public void buscarPiezaBodega(Pieza pieza) {
    	Pieza piezaEncontrada = null;
    	String tituloObra = pieza.getTituloObra();
    	for (int i = 0; i < piezasBodega.size(); i++) {
    	    Pieza piezaLista = piezasBodega.get(i);
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
    
    public void buscarPiezahistorico(Pieza pieza) {
    	
    }
}
