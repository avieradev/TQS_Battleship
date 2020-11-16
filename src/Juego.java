import java.util.InputMismatchException;
import java.util.Scanner;

public class Juego {
	static int totalBarcos = 10;
	static int fila;
	static int columna;
	static int estado;
	static boolean hundida;
	static int turnos;
	Jugador jugador1 = new Jugador("Adria");
	Tablero tablero1 = new Tablero();
	Jugador jugador2 = new Jugador("Maquina");
	Tablero tablero2 = new Tablero();
	Scanner sc = new Scanner(System.in);
	
	public Juego() {
		fila = 0;
		columna = 0;
		estado = 0;
		hundida = false;
		turnos = 0;
	}
	
	public Boolean inicializar() {
		try {
			boolean eleccionValida = false;
			
			//INICIALIZACION JUEGO
			System.out.println("¿Quieres inicializar los barcos aleatorios o quieres introducirlos uno a uno? (0: Aleatorios, 1: Introducir) ");
			int eleccion = sc.nextInt();
			
			tablero2.setBarcosAleatorios();
			do {
				if (eleccion == 0 || eleccion == 1) {
					eleccionValida = true;
				}else {
					System.out.println("Elección no valida");
					eleccion = sc.nextInt();				
				}
			}while(!eleccionValida);
			
			if(eleccion == 0) {
				tablero1.setBarcosAleatorios();
			}else{
				boolean portaaviones = false;
				
				System.out.println("Vamos a colocar los barcos!");
				System.out.println("Empezemos por el portaaviones. (tamaño 5)");
				do {
					try {
						System.out.println("Indica la fila.");
						int fila = sc.nextInt();
						System.out.println("Indica la columna.");
						int columna = sc.nextInt();
						System.out.println("Elige una orientación. (0: vertical, 1: horizontal)");
						int orientacion = sc.nextInt();
						portaaviones = tablero1.setBarcos(fila, columna, orientacion, 5);
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
							System.out.println("Indica la fila.");
							int fila = sc.nextInt();
							System.out.println("Indica la columna.");
							int columna = sc.nextInt();
							System.out.println("Elige una orientación. (0: vertical, 1: horizontal)");
							int orientacion = sc.nextInt();
							buque = tablero1.setBarcos(fila, columna, orientacion, 4);
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
							System.out.println("Indica la fila.");
							int fila = sc.nextInt();
							System.out.println("Indica la columna.");
							int columna = sc.nextInt();
							System.out.println("Elige una orientación. (0: vertical, 1: horizontal)");
							int orientacion = sc.nextInt();
							submarino = tablero1.setBarcos(fila, columna, orientacion, 3);
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
							System.out.println("Indica la fila.");
							int fila = sc.nextInt();
							System.out.println("Indica la columna.");
							int columna = sc.nextInt();
							System.out.println("Elige una orientación. (0: vertical, 1: horizontal)");
							int orientacion = sc.nextInt();
							crucero = tablero1.setBarcos(fila, columna, orientacion, 2);
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
							System.out.println("Indica la fila.");
							int fila = sc.nextInt();
							System.out.println("Indica la columna.");
							int columna = sc.nextInt();
							System.out.println("Elige una orientación. (0: vertical, 1: horizontal)");
							int orientacion = sc.nextInt();
							lancha = tablero1.setBarcos(fila, columna, orientacion, 1);
						}catch(InputMismatchException ime) {
							System.out.println("¡Cuidado! Solo puedes insertar números. ");
								sc.next();
							}
						}while(!lancha);
					}	
				} 
		}catch(Error e) {
			return false;
		}
		return true;
	}
	
	public Boolean jugar() {
		try {
			while(turnos <= 50 || totalBarcos != 0) {
				
				turnos++;
				tablero2.printTablero();
				System.out.println("TURNO " + jugador1.getNombre() + ": " + turnos);
				
				//BUCLE COMPROBAR POSICION
				boolean valid = false;
				while(!valid) {
					fila = jugador1.insertaFila(sc);
					columna = jugador1.insertaColumna(sc);
					valid = tablero2.compruebaPosicionValida(fila, columna);
					if(!valid) {
						System.out.println("CASILLA NO VALIDA");
						}
				}
				
				//DESVELAR CASILLA
				tablero2.setCasillaRevelada(fila, columna);
				estado = tablero2.getEstadoCasilla(fila, columna);
			 
				//SI ES BARCO
				if (estado == 1) {
					hundida = tablero2.compruebaHundida(fila, columna);
					
					//SI ES HUNDIDO
					if(hundida == true) {
						totalBarcos--;
					}
				}
				
				
				System.out.println("TURNO " + jugador2.getNombre() + ": " + turnos);
				
				//BUCLE COMPROBAR POSICION
				boolean validJ2 = false;
				while(!validJ2) {
					fila = tablero1.generarRandom(9);
					columna = tablero1.generarRandom(9);
					System.out.println(jugador2.getNombre() + " ataca la casilla " + fila + "," + columna);
					validJ2 = tablero1.compruebaPosicionValida(fila, columna);
					if(!validJ2) {
						System.out.println("CASILLA NO VALIDA");
						}
				}
				
				//DESVELAR CASILLA
				tablero1.setCasillaRevelada(fila, columna);
				estado = tablero1.getEstadoCasilla(fila, columna);
				switch(estado) {
				case 0:
					System.out.println(jugador2.getNombre() + " toca Agua...");
					break;
				case 1:
					//SI ES BARCO
					System.out.println(jugador2.getNombre() + " toca Barco!");
					hundida = tablero1.compruebaHundida(fila, columna);
					
					//SI ES HUNDIDO
					if(hundida == true) {
						totalBarcos--;
					}
					break;
				}
				
			}
		}catch(Error e) {
			return false;
		}
		return true;
	}
	
	public Boolean compruebaGanador() {
			if (totalBarcos == 0) {
				System.out.println("Felicidades, ¡has ganado!");
				return true;
			}
			else
			{
				System.out.println("Derrota.");
				return false;
			}
	}
	public static void main(String[] args) {
		
		Juego juego = new Juego();
		
		juego.inicializar();
		
		juego.jugar();
		
		juego.compruebaGanador();

	}

}
