package uniandes.dpoo.galeria.modelo.plataforma;

import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;

public class Venta {
	
	private ArrayList<Pieza> piezasVendidas = new ArrayList<Pieza>();
	private ArrayList<Comprador> compradores = new ArrayList<Comprador>();
	
	public Venta() {}
	
	public void agregarPiezaVendida(Pieza pieza) {
		piezasVendidas.add(pieza);
	}
	
	public void agregarComprador(Comprador comprador) {
		compradores.add(comprador);
	}
	
}
