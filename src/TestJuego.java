import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	InterficieJugador jugadorPrueba = new mockobjectJugador();
	
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
		assertTrue(juegoPrueba.inicializacionPortaaviones(sc, jugadorPrueba, tablero1));
	}
	
	
	@Test
	public void testTurnoMaquina() {
		assertTrue(juegoPrueba.turnoMaquina(jugador2, tablero2, sc));
	}
	
	@Test
	public void testTurnoJugador() {
		assertTrue(juegoPrueba.turnoJugador(jugadorPrueba, tablero1, sc));
	}
	
}
