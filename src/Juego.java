import java.util.Scanner;

public class Juego {

	public Juego() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Tablero tablero = new Tablero(4);
		Jugador jugador = new Jugador("Adri");
		tablero.setBarcosAleatorios();
		boolean ganar = false;
		while(!ganar) {
			tablero.printTablero();	
			Scanner sc = new Scanner(System.in);
			jugador.insertaFila(sc);
			
		}
	}

}
