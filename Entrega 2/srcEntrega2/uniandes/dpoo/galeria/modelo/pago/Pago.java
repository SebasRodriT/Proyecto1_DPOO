package uniandes.dpoo.galeria.modelo.pago;

import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.usuario.Comprador;

public class Pago {
	
	private int numeroFactura = 1;
	private int precio;
	private static HashMap<Integer, Comprador> pagos = new HashMap <>();
	
	public Pago(Comprador comprador, int nPrecio) {
		this.precio = nPrecio;
		Integer numeroF = numeroFactura+1;
		comprador.actualizarSaldo(nPrecio);
		pagos.put(numeroF, comprador);
		
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public int getPrecio() {
		return precio;
	}

	}
	

