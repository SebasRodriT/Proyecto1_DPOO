package testModelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Galeria;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

public class testGaleria {
	private Usuario user1 = new Usuario("Maria Ariza", 17657934, 25, "mari34", "MariAri3400", "Comprador");
	private Usuario user2 = new Usuario("Juan Pérez", 67856453, 35, "jupe45", "Juanpe2005", "Propietario");
	private Usuario user3 = new Usuario("Pedro Arias", 45638567, 29, "Juanpe01", "Pear2024*", "Comprador");
	private Comprador compradorExistente = new Comprador("Maria Ariza", 17657934, 25, "mari34", "MariAri3400", "300567895", "mari34@domain.com", 20000000);
    private Comprador compradorNoExistente = new Comprador("Maria Ariza", 17657934, 25, "mari34", "MariAri3400", "300567895", "mari34@domain.com", 20000000);
    Artista artista = new Artista("Leonardo Da Vinci", "Pintor");
    Pieza piezaExhibida = new Pieza(false, "La Mona Lisa", 1503, "Italia", artista,true, "Humanismo", 19890786);
    Pieza piezaEnBodega = new Pieza(false, "El Hombre de Vitruvio", 1490, "Italia", artista,true, "Humanismo", 17890786);
    Pieza piezaEnHistorico = new Pieza(false,"La Última Cena", 1495, "Italia", artista, true, "Religión", 15789000);
    
	@Test
	public void testVerificarCompradorExistente() {
		boolean encontrado = Galeria.verificarComprador(compradorExistente);
        assertTrue(encontrado); 
	}

	
	
	@Before
    public void setUp() {
        Galeria galeria = new Galeria("Italia", 120); 

        Artista artista = new Artista("Leonardo Da Vinci", "Pintor");
        Pieza piezaExhibida = new Pieza(false, "La Mona Lisa", 1503, "Italia", artista,true, "Humanismo", 19890786);
        Pieza piezaEnBodega = new Pieza(false, "El Hombre de Vitruvio", 1490, "Italia", artista,true, "Humanismo", 17890786);
        Pieza piezaEnHistorico = new Pieza(false,"La Última Cena", 1495, "Italia", artista, true, "Religión", 15789000);

        galeria.agregarPiezaExhibida(piezaExhibida);
        galeria.agregarPiezaBodega(piezaEnBodega);
        galeria.agregarPiezaHistorico(piezaEnHistorico);
    }

 
   

    @Test
    public void testBuscarPiezaExhibidaNoExistente() {
        Pieza piezaNoEncontrada = Galeria.buscarPiezaExhibida(new Pieza(false,"La Noche Estrellada", 1889, "Países Bajos", new Artista("Vincent Van Gogh", "Pintor"), false, "Impresionismo",  15689586 ));
        assertNull(piezaNoEncontrada); 
    }



    @Test
    public void testBuscarPiezaBodegaNoExistente() {
        // Act
        Pieza piezaNoEncontrada = Galeria.buscarPiezaBodega(new Pieza(false,"La Noche Estrellada", 1889, "Países Bajos", new Artista("Vincent Van Gogh", "Pintor"), false, "Impresionismo",  15689586 ));

        // Assert
        assertNull(piezaNoEncontrada); 
    }

    

    @Test
    public void testBuscarPiezaHistoricoNoExistente() {
        Pieza piezaNoEncontrada = Galeria.buscarPiezahistorico(new Pieza(false,"La Noche Estrellada", 1889, "Países Bajos", new Artista("Vincent Van Gogh", "Pintor"), false, "Impresionismo",  15689586 ));
        assertNull(piezaNoEncontrada); 
    }
}
