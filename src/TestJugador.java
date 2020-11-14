import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJugador {
	InterficieJugador jugadorPrueba = new mockobjectJugador();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNombre() {
		assertEquals(jugadorPrueba.getNombre(), "MockPlayer");
	}
	
	@Test
	public void testInsertafila() {
		Scanner sc = new Scanner(System.in);
		assertEquals(jugadorPrueba.insertaFila(sc), 0);
	}
	
	@Test
	public void testInsertaColumna() {
		Scanner sc = new Scanner(System.in);
		assertEquals(jugadorPrueba.insertaColumna(sc), 0);
	}

}
