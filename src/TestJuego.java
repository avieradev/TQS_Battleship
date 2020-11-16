import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJuego {
	Juego juegoPrueba = new Juego();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVictoria() {
		assertFalse(juegoPrueba.compruebaGanador());
	}
	@Test
	public void testInicializar() {
		assertTrue(juegoPrueba.inicializar());
	}
	
} 
