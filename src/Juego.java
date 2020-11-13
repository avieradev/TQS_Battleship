import java.util.Scanner;

public class Juego {

	public Juego() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Tablero tablero1 = new Tablero(4);
		Jugador jugador1 = new Jugador("Adri");
		tablero1.setBarcosAleatorios();
		int fila;
		int columna;
		
		int ganar = 50;
		while(ganar > 50) {
			tablero1.printTablero();	
			Scanner sc = new Scanner(System.in);
			fila = jugador1.insertaFila(sc);
			columna = jugador1.insertaColumna(sc);
			
		}
	}

}
