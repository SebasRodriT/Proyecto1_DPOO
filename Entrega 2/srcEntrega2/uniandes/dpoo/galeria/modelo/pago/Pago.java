package uniandes.dpoo.galeria.modelo.pago;

import uniandes.dpoo.galeria.modelo.usuario.Comprador;

public class Pago {
	
	private int numeroFactura = 1;
	private int precio;
	private String tipoPago;
	
	public Pago(Comprador comprador, int nPrecio, String nTipoPago) {
		this.precio = nPrecio;
		this.tipoPago = nTipoPago;
		//descontar dinero 
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public int getPrecio() {
		return precio;
	}

	public String getTipoPago() {
		return tipoPago;
	}}
	

