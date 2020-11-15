import java.util.InputMismatchException;
import java.util.Scanner;

public class Juego {
	
	
	public Juego() {
		// TODO Auto-generated constructor stu
	}
	
	public static void main(String[] args) {
		int totalBarcos = 10;
		boolean eleccionValida = false;
		Scanner sc = new Scanner(System.in);
		
		//INICIALIZACION JUEGO
		System.out.println("¿Quieres inicializar los barcos aleatorios o quieres introducirlos uno a uno? (0: Aleatorios, 1: Introducir) ");
		int eleccion = sc.nextInt();
		Jugador jugador1 = new Jugador("Adria");
		do {
			if (eleccion == 0 || eleccion == 1) {
				eleccionValida = true;
			}else {
				System.out.println("Elección no valida");
				eleccion = sc.nextInt();				
			}
		}while(!eleccionValida);
		
		Tablero tablero1 = new Tablero();
		if(eleccion == 0) {
			tablero1.setBarcosAleatorios();
		}else{
			boolean barcoSeteado = false;
			System.out.println("Vamos a colocar los barcos!");
			do {
				try {
					System.out.println("Empezemos por el portaaviones. (tamaño 5)");
					System.out.println("Indica la fila.");
					int fila = sc.nextInt();
					System.out.println("Indica la columna.");
					int columna = sc.nextInt();
					System.out.println("Elige una orientación. (0: vertical, 1: horizontal)");
					int orientacion = sc.nextInt();
					barcoSeteado = tablero1.setBarcos(fila, columna, orientacion, 5);
				}catch(InputMismatchException ime) {
					System.out.println("¡Cuidado! Solo puedes insertar números. ");
					sc.next();
				}
			}while(!barcoSeteado);
			
			
			tablero1.setBarcos(1,1,1, 1);
		} 
		//VARIABLES 
		int fila = 0;
		int columna = 0;
		int estado = 0;
		boolean hundida = false;
		int turnos = 0;
		
		//BUCLE PRINCIPAL
		while(turnos <= 50 || totalBarcos != 0) {
			
			turnos++;
			tablero1.printTablero();
			System.out.println("TURNO: " + turnos);
			
			//BUCLE COMPROBAR POSICION
			boolean valid = false;
			while(!valid) {
				fila = jugador1.insertaFila(sc);
				columna = jugador1.insertaColumna(sc);
				valid = tablero1.compruebaPosicionValida(fila, columna);
				if(!valid) {
					System.out.println("CASILLA NO VALIDA");
					}
			}
			
			//DESVELAR CASILLA
			tablero1.setCasillaRevelada(fila, columna);
			estado = tablero1.getEstadoCasilla(fila, columna);
		 
			//SI ES BARCO
			if (estado == 1) {
				hundida = tablero1.compruebaHundida(fila, columna);
				
				//SI ES HUNDIDO
				if(hundida == true) {
					totalBarcos--;
				}
			}
		}
		
		if (totalBarcos == 0) {
			System.out.println("Felicidades, ¡has ganado!");
		}
		else
		{
			System.out.println("Derrota.");
		}
	}

}
