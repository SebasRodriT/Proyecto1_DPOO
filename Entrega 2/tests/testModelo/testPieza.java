package testModelo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Pieza;

public class testPieza {
	Artista artista = new Artista("Leonardo Da Vinci", "Pintor");
	Pieza pieza = new Pieza(false, "La Mona Lisa", 1503, "Italia", artista,true, "Humanismo", 19890786);
	
	@Test
	public void testMarcarComoVendida() throws Exception{
		pieza.marcarComoVendida();
		assertTrue(pieza.isVendida());
	}
	
	@Test
	public void testMarcarComoDevolucion() throws Exception{
		pieza.marcarComoDevolucion();
		assertTrue(pieza.isExhibido());
	}
}
