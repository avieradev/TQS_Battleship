import java.util.Scanner;

public class Juego {
	
	
	public Juego() {
		// TODO Auto-generated constructor stu
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//INICIALIZACION JUEGO
		System.out.println("¿Cuantos barcos quieres?: ");
		int totalBarcos = sc.nextInt();
		Jugador jugador1 = new Jugador("Adria");
		Tablero tablero1 = new Tablero(totalBarcos);
		tablero1.setBarcosAleatorios();
		
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
					//tablero1.revelarAdyacentes(fila, columna);
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
