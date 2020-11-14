import java.util.Scanner;

public class Juego {

	public Juego() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		Tablero tablero1 = new Tablero(4);
		Jugador jugador1 = new Jugador("Adri");
		tablero1.setBarcosAleatorios();
		int fila = 0;
		int columna = 0;
		
		int ganar = 50;
		while(ganar > 0) {
			tablero1.printTablero();	
			Scanner sc = new Scanner(System.in);
			boolean valid = false;
			while(!valid) {
			fila = jugador1.insertaFila(sc);
			columna = jugador1.insertaColumna(sc);
			tablero1.compruebaPosicionValida(fila, columna);
			}
			tablero1.getEstadoCasilla(fila, columna);	
		}
	}

}
