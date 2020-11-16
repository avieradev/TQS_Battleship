import java.util.InputMismatchException;
import java.util.Scanner;

public class Juego {
	static int totalBarcosRival = 4; //son los barcos que le metemos al enemigo por defecto
	static int totalBarcosNuestros = 10;
	static int fila;
	static int columna;
	static int orientacion;
	static int estado;
	static boolean hundida;
	static int turnos;

	public Juego() {
		fila = 0;
		columna = 0;
		orientacion = 0;
		estado = 0;
		hundida = false;
		turnos = 0;
	}
	
	public void setTotalBarcosRival(int b) {
		totalBarcosRival = b;
	}
	
	public void setTotalBarcosNuestros(int b) {
		totalBarcosNuestros = b;
	}
	
	public int seleccionarTipo(int tipo, Scanner sc) {
		boolean eleccionValida = false;
		do {
			if (tipo == 0 || tipo == 1) {
				eleccionValida = true;
			}else {
				System.out.println("Elección no valida");
				tipo = sc.nextInt();				
			}
		}while(!eleccionValida);
		return tipo;
	}
	
	public Boolean inicializacionJuego(int tipo, Tablero tablero1, Tablero tablero2, InterficieJugador jugador1, Scanner sc) {
		
		inicializacionJuegoRandom(tablero2);
		if(tipo == 0) { //inicialitazacio random
			return inicializacionJuegoRandom(tablero1);
		}
		else { //inicizalitazacio triada pel player
			return inicializacionJuegoElegir(sc, jugador1, tablero1);
		}
	}
	
	public Boolean inicializacionJuegoRandom(Tablero tablero1) {
		tablero1.setBarcosAleatorios();
		return true;
	}
	
	public Boolean inicializacionJuegoElegir(Scanner sc, InterficieJugador jugador1, Tablero tablero1) {
		
		boolean portaaviones = false;
		boolean buques = false;
		boolean submarinos = false;
		boolean cruceros = false;
		boolean lanchas = false;
		
		System.out.println("Vamos a colocar los barcos!");
		
		System.out.println("Empezemos por el portaaviones. (tamaño 5)");
		portaaviones = inicializacionPortaaviones(sc, jugador1, tablero1);
		
		System.out.println("Vamos con los 2 buques. (tamaño 4)");
		buques = inicializacionBuques(sc, jugador1, tablero1);
		
		System.out.println("Vamos a por los 3 sumbarinos. (tamaño 3)");
		submarinos = inicializacionSubmarinos(sc, jugador1, tablero1);
		
		System.out.println("Vamos con los 4 cruceros. (tamaño 2)");
		cruceros = inicializacionCruceros(sc, jugador1, tablero1);
		
		System.out.println("Solo faltan 5 lanchas. (tamaño 1)");
		lanchas = inicializacionLanchas(sc, jugador1, tablero1);
		
		return (portaaviones && buques && submarinos && cruceros && lanchas);
	}
	
	public boolean inicializacionPortaaviones(Scanner sc, InterficieJugador jugador1, Tablero tablero1) {
		
		boolean portaaviones = false;
		do {
			try {
				fila = jugador1.insertaFila(sc);
				columna = jugador1.insertaColumna(sc);
				orientacion = jugador1.insertaOrientacion(sc);
				portaaviones = tablero1.setBarcos(fila, columna, orientacion, 5);
			}catch(InputMismatchException ime) {
				System.out.println("¡Cuidado! Solo puedes insertar números. ");
				sc.next();
			}
		}while(!portaaviones);
		return portaaviones;
	}
	
	public boolean inicializacionBuques(Scanner sc, InterficieJugador jugador1, Tablero tablero1) {
		
		boolean buque = false;
		for (int i = 0; i < 2; i++) {
			buque = false;
			do {
				try {
					fila = jugador1.insertaFila(sc);
					columna = jugador1.insertaColumna(sc);
					orientacion = jugador1.insertaOrientacion(sc);
					buque = tablero1.setBarcos(fila, columna, orientacion, 4);
				}catch(InputMismatchException ime) {
					System.out.println("¡Cuidado! Solo puedes insertar números. ");
					sc.next();
				}
			}while(!buque);
		}
		return buque;
	}
	
	public boolean inicializacionSubmarinos(Scanner sc, InterficieJugador jugador1, Tablero tablero1) {

		boolean submarino = false;
		for (int i = 0; i < 3; i++) {
			submarino = false;
			do {
				try {
					fila = jugador1.insertaFila(sc);
					columna = jugador1.insertaColumna(sc);
					orientacion = jugador1.insertaOrientacion(sc);
					submarino = tablero1.setBarcos(fila, columna, orientacion, 3);
				}catch(InputMismatchException ime) {
					System.out.println("¡Cuidado! Solo puedes insertar números. ");
					sc.next();
				}
			}while(!submarino);
		}
		return submarino;
	}
	
	public boolean inicializacionCruceros(Scanner sc, InterficieJugador jugador1, Tablero tablero1) {
		
		boolean crucero = false;
		for (int i = 0; i < 4; i++) {
			crucero = false;
			do {
				try {
					fila = jugador1.insertaFila(sc);
					columna = jugador1.insertaColumna(sc);
					orientacion = jugador1.insertaOrientacion(sc);
					crucero = tablero1.setBarcos(fila, columna, orientacion, 2);
				}catch(InputMismatchException ime) {
					System.out.println("¡Cuidado! Solo puedes insertar números. ");
					sc.next();
				}
			}while(!crucero);
		}
		return crucero;
	}
		
	public boolean inicializacionLanchas(Scanner sc, InterficieJugador jugador1, Tablero tablero1) {
		
		boolean lancha = false;
		for (int i = 0; i < 5; i++) {
			lancha = false;
			do {
				try {
					System.out.println("Indica la fila.");
					int fila = jugador1.insertaFila(sc);
					System.out.println("Indica la columna.");
					int columna = jugador1.insertaColumna(sc);
					System.out.println("Elige una orientación. (0: vertical, 1: horizontal)");
					int orientacion = jugador1.insertaOrientacion(sc);
					lancha = tablero1.setBarcos(fila, columna, orientacion, 1);
				}catch(InputMismatchException ime) {
					System.out.println("¡Cuidado! Solo puedes insertar números. ");
						sc.next();
					}
				}while(!lancha);
			}
		return lancha;
	} 
	
	public boolean movimientoJugador(InterficieJugador jugador1, Tablero tablero2, Scanner sc) {
		tablero2.printTablero();
		System.out.println("TURNO " + jugador1.getNombre());
		boolean seguir = false;
		
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
			seguir = true;
			//SI ES HUNDIDO
			if(hundida == true) {
				totalBarcosRival--;
			}
		}
		return seguir;
	}
	
	public boolean movimientoMaquina(InterficieJugador jugador2, Tablero tablero1, Scanner sc) {

		tablero1.printTablero();		
		System.out.println("TURNO " + jugador2.getNombre() + ": " + turnos);
		boolean seguir = false;		
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
				totalBarcosNuestros--;
			}
			seguir = true;
			break;
		}
		return seguir;		
	}
	
	public boolean turnoJugador(InterficieJugador jugador1, Tablero tablero2, Scanner sc) {
		boolean movimiento = true;
		while (movimiento) {
			movimiento = movimientoJugador(jugador1, tablero2, sc);
		}
		return true;
	}
	
	public boolean turnoMaquina(InterficieJugador jugador2, Tablero tablero1, Scanner sc) {
		boolean movimientoMaquina = true;
		while (movimientoMaquina) {
			movimientoMaquina = movimientoMaquina(jugador2, tablero1, sc);
		}
		return true;
	}
	
	public Boolean compruebaGanador() {
			
		if (totalBarcosRival == 0) {
			System.out.println("Felicidades, ¡has ganado!");
			return true;
		}
		else if(totalBarcosNuestros == 0)
		{
			System.out.println("Derrota.");
			return false;
		}
		return false;
	}
	public static void main(String[] args) {
		
		Juego juego = new Juego();
		Jugador jugador1 = new Jugador("Adria");
		Tablero tablero1 = new Tablero(); //DONDE COLOCAREMOS NUESTROS BARCOS
		Jugador jugador2 = new Jugador("Maquina");
		Tablero tablero2 = new Tablero(); //DONDE LOS PONDRA LA MAQUINA
		Scanner sc = new Scanner(System.in);
		
		
		//INICIALIZACION JUEGO
		System.out.println("¿Quieres inicializar los barcos aleatorios o quieres introducirlos uno a uno? (0: Aleatorios, 1: Introducir) ");
		int tipo = sc.nextInt();
		
		tipo = juego.seleccionarTipo(tipo, sc); //seleccionamos como queremos inicializar
		
		
		if (juego.inicializacionJuego(tipo, tablero1, tablero2, jugador1, sc)){ //si inicializamos bien
			
			while(totalBarcosNuestros != 0 || totalBarcosRival != 0) {
				juego.turnoJugador(jugador1, tablero2, sc);
				juego.turnoMaquina(jugador2, tablero1, sc);
			}
			juego.compruebaGanador();
		}
		else{
			System.out.println("Error al meter barcos");
		}
	}

}
