import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJugador {
	ArrayList<Integer> array_filas =    new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
	ArrayList<Integer> array_columnas = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
	ArrayList<Integer> array_orientacion = new ArrayList<Integer>(Arrays.asList(1,1,1,1,0,1,0,1,0,0));
	InterficieJugador jugadorPrueba = new mockobjectJugador(array_filas, array_columnas, array_orientacion);

	InterficieJugador jugadorPrueba2 = new Jugador("Real");
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNombre() {
		assertEquals(jugadorPrueba.getNombre(), "MockPlayer");
		assertEquals(jugadorPrueba2.getNombre(), "Real");
	}
	
	//@Test
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
