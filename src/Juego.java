
public class Juego {

	public Juego() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tablero tablero = new Tablero(4);

		tablero.setEstadoCasilla(1, 0, 1);
		System.out.print(tablero.getEstadoCasilla(1, 1));
		tablero.printTablero();	
	}

}
