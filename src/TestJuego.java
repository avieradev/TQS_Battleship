import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJuego {
	Juego juegoPrueba = new Juego();
	Jugador jugador1 = new Jugador("Adria");
	Tablero tablero1 = new Tablero(); //DONDE COLOCAREMOS NUESTROS BARCOS
	Jugador jugador2 = new Jugador("Maquina");
	Tablero tablero2 = new Tablero(); //DONDE LOS PONDRA LA MAQUINA
	Scanner sc = new Scanner(System.in);
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVictoria() {
		assertFalse(juegoPrueba.compruebaGanador());
		juegoPrueba.setTotalBarcosNuestros(0);
		assertFalse(juegoPrueba.compruebaGanador());
		juegoPrueba.setTotalBarcosNuestros(1);
		juegoPrueba.setTotalBarcosRival(0);
		assertTrue(juegoPrueba.compruebaGanador());
	}
	
	@Test //CAJA NEGRA VER QUE SE PUEDE INICIALIZAR
	public void testInicializacionJuego() {
		assertTrue(juegoPrueba.inicializacionJuego(0, tablero1, tablero2, jugador1, sc));
	}
	
	@Test
	public void testInicializacionPortaaviones() {
		ArrayList<Integer> array_filas =    new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		ArrayList<Integer> array_columnas = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
		ArrayList<Integer> array_orientacion = new ArrayList<Integer>(Arrays.asList(1,1,1,1,0,1,0,1,0,0));
		InterficieJugador jugadorPrueba = new mockobjectJugador(array_filas, array_columnas, array_orientacion);
		assertTrue(juegoPrueba.inicializacionPortaaviones(sc, jugadorPrueba, tablero1));
	}

	@Test
	public void testInicializacionBuques() {
		ArrayList<Integer> array_filas =    new ArrayList<Integer>(Arrays.asList(0, 2, 3, 4, 5));
		ArrayList<Integer> array_columnas = new ArrayList<Integer>(Arrays.asList(0, 2, 3, 4, 5));
		ArrayList<Integer> array_orientacion = new ArrayList<Integer>(Arrays.asList(1,1,1,1,0,1,0,1,0,0));
		InterficieJugador jugadorPrueba = new mockobjectJugador(array_filas, array_columnas, array_orientacion);
		assertFalse(juegoPrueba.inicializacionBuques(sc, jugadorPrueba, tablero1));
	}
	
	@Test
	public void testInicializacionSubmarinos() {
		ArrayList<Integer> array_filas =    new ArrayList<Integer>(Arrays.asList(0, 2, 3, 4, 5));
		ArrayList<Integer> array_columnas = new ArrayList<Integer>(Arrays.asList(0, 2, 3, 4, 5));
		ArrayList<Integer> array_orientacion = new ArrayList<Integer>(Arrays.asList(1,1,1,1,0,1,0,1,0,0));
		InterficieJugador jugadorPrueba = new mockobjectJugador(array_filas, array_columnas, array_orientacion);
		assertFalse(juegoPrueba.inicializacionSubmarinos(sc, jugadorPrueba, tablero1));
	}
	
	@Test
	public void testInicializacionCruceros() {
		ArrayList<Integer> array_filas =    new ArrayList<Integer>(Arrays.asList(0, 2, 3, 4, 5));
		ArrayList<Integer> array_columnas = new ArrayList<Integer>(Arrays.asList(0, 2, 3, 4, 5));
		ArrayList<Integer> array_orientacion = new ArrayList<Integer>(Arrays.asList(1,1,1,1,0,1,0,1,0,0));
		InterficieJugador jugadorPrueba = new mockobjectJugador(array_filas, array_columnas, array_orientacion);
		assertFalse(juegoPrueba.inicializacionCruceros(sc, jugadorPrueba, tablero1));
	}
	
	@Test
	public void testInicializacionLanchas() {
		ArrayList<Integer> array_filas =    new ArrayList<Integer>(Arrays.asList(0, 2, 3, 4, 5));
		ArrayList<Integer> array_columnas = new ArrayList<Integer>(Arrays.asList(0, 2, 3, 4, 5));
		ArrayList<Integer> array_orientacion = new ArrayList<Integer>(Arrays.asList(1,1,1,1,0,1,0,1,0,0));
		InterficieJugador jugadorPrueba = new mockobjectJugador(array_filas, array_columnas, array_orientacion);
		assertFalse(juegoPrueba.inicializacionLanchas(sc, jugadorPrueba, tablero1));
	}
	
	
	
	
	
	@Test
	public void testTurnoMaquina() {
		assertTrue(juegoPrueba.turnoMaquina(jugador2, tablero2, sc));
	}
	
	@Test
	public void testTurnoJugador() {
		ArrayList<Integer> array_filas =    new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		ArrayList<Integer> array_columnas = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
		ArrayList<Integer> array_orientacion = new ArrayList<Integer>(Arrays.asList(1,1,1,1,0,1,0,1,0,0));
		InterficieJugador jugadorPrueba = new mockobjectJugador(array_filas, array_columnas, array_orientacion);
		assertTrue(juegoPrueba.turnoJugador(jugadorPrueba, tablero1, sc));
	}
	
}
