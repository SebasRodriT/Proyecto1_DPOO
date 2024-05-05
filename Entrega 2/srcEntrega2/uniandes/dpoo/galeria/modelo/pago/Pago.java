package uniandes.dpoo.galeria.modelo.pago;



import uniandes.dpoo.galeria.modelo.empleado.CajeroGaleria;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;

public class Pago {
	
	private int numeroFactura = 1;
	private int precio;
	private static CajeroGaleria cajero = new CajeroGaleria("Sebastian Rios", 11364587, 40);
	
	public Pago(Comprador comprador, int nPrecio) {
		this.precio = nPrecio;
		this.numeroFactura += 1;
		comprador.actualizarSaldo(nPrecio);
		cajero.registrarPago(comprador, this);
		
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public int getPrecio() {
		return precio;
	}
	

	}

