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
		Scanner sc = new Scanner(System.in);
		int fila;
		int columna;
		int orientacion;
		Tablero tableroPrueba1 = new Tablero();
		Tablero tableroPrueba2 = new Tablero();
		InterficieJugador jugador1 = new mockobjectJugador();
		
		boolean eleccionValida = false;
		
		//INICIALIZACION JUEGO
		System.out.println("¿Quieres inicializar los barcos aleatorios o quieres introducirlos uno a uno? (0: Aleatorios, 1: Introducir) ");
		int eleccion = jugador1.insertaValorInicial(sc);
		
		tableroPrueba2.setBarcosAleatorios();
		do {
			if (eleccion == 0 || eleccion == 1) {
				eleccionValida = true;
			}else {
				System.out.println("Elección no valida");
				eleccion = jugador1.insertaValorInicial(sc);				
			}
		}while(!eleccionValida);
		
		if(eleccion == 0) {
			tableroPrueba1.setBarcosAleatorios();
		}else{
			boolean portaaviones = false;
			
			System.out.println("Vamos a colocar los barcos!");
			System.out.println("Empezemos por el portaaviones. (tamaño 5)");
			do {
				try {
					fila = jugador1.insertaFila(sc);
					columna = jugador1.insertaColumna(sc);
					orientacion = jugador1.insertaOrientacion(sc);
					portaaviones = tableroPrueba1.setBarcos(fila, columna, orientacion, 5);
				}catch(InputMismatchException ime) {
					System.out.println("¡Cuidado! Solo puedes insertar números. ");
					sc.next();
				}
			}while(!portaaviones);
			
			
			
			System.out.println("Vamos con los 2 buques. (tamaño 4)");
			for (int i = 0; i < 2; i++) {
				boolean buque = false;
				do {
					try {
						fila = jugador1.insertaFila(sc);
						columna = jugador1.insertaColumna(sc);
						orientacion = jugador1.insertaOrientacion(sc);
						buque = tableroPrueba1.setBarcos(fila, columna, orientacion, 4);
					}catch(InputMismatchException ime) {
						System.out.println("¡Cuidado! Solo puedes insertar números. ");
						sc.next();
					}
				}while(!buque);
			}
			
			
			
			System.out.println("Vamos a por los 3 sumbarinos. (tamaño 3)");
			for (int i = 0; i < 3; i++) {
				boolean submarino = false;
				do {
					try {
						fila = jugador1.insertaFila(sc);
						columna = jugador1.insertaColumna(sc);
						orientacion = jugador1.insertaOrientacion(sc);
						submarino = tableroPrueba1.setBarcos(fila, columna, orientacion, 3);
					}catch(InputMismatchException ime) {
						System.out.println("¡Cuidado! Solo puedes insertar números. ");
						sc.next();
					}
				}while(!submarino);
			}
			
			System.out.println("Vamos con los 4 cruceros. (tamaño 2)");
			for (int i = 0; i < 4; i++) {
				boolean crucero = false;
				do {
					try {
						fila = jugador1.insertaFila(sc);
						columna = jugador1.insertaColumna(sc);
						orientacion = jugador1.insertaOrientacion(sc);
						crucero = tableroPrueba1.setBarcos(fila, columna, orientacion, 2);
					}catch(InputMismatchException ime) {
						System.out.println("¡Cuidado! Solo puedes insertar números. ");
						sc.next();
					}
				}while(!crucero);
			}
			
			System.out.println("Solo faltan 5 lanchas. (tamaño 1)");
			for (int i = 0; i < 5; i++) {
				boolean lancha = false;
				do {
					try {
						fila = jugador1.insertaFila(sc);
						columna = jugador1.insertaColumna(sc);
						orientacion = jugador1.insertaOrientacion(sc);
						lancha = tableroPrueba1.setBarcos(fila, columna, orientacion, 1);
					}catch(InputMismatchException ime) {
						System.out.println("¡Cuidado! Solo puedes insertar números. ");
							sc.next();
						}
					}while(!lancha);
				}	
			} 
	}
	
} 
