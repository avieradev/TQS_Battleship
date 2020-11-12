import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJugador {
	Jugador jugadorPrueba = new Jugador("Pepe");
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNombre() {
		assertEquals(jugadorPrueba.getNombre(), "Pepe");
	}

}
