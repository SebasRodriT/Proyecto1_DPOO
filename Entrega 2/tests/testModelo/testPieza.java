package testModelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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
	
	@Test
	public void testAgregarPiezainventario(){
		pieza.agregarPiezainventario(pieza);
		assertTrue(pieza.getInventarioPiezas().contains(pieza), "La pieza debería estar en la lista de inventario de piezas");
	}
	
	@Test
	public void testEliminarPiezaInventario() {
		pieza.agregarPiezainventario(pieza);
		assertTrue(pieza.getInventarioPiezas().contains(pieza), "La pieza debería estar en la lista de inventario de piezas");
		
		pieza.eliminarPiezainventario(pieza);
		assertFalse(pieza.getInventarioPiezas().contains(pieza), "La pieza no debería estar en la lista de inventario de piezas");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testBuscarPiezaInventario() {
		pieza.agregarPiezainventario(pieza);
		Pieza piezaEncontrada = pieza.buscarPiezaInventario(pieza);
		assertNotNull(piezaEncontrada, "La pieza debería haber sido encontrada");
		assertEquals(pieza.getTituloObra(), piezaEncontrada.getTituloObra(), "El título de la obra debe coincidir");
	}
	
	@SuppressWarnings("static-access")
	@Test
    public void testBuscarPiezaInventarioNoExistente() {
        Pieza piezaNoEncontrada = pieza.buscarPiezaInventario(new Pieza(false,"La Noche Estrellada", 1889, "Países Bajos", new Artista("Vincent Van Gogh", "Pintor"), false, "Impresionismo",  15689586 ));
        assertNull(piezaNoEncontrada); 
    }
}
