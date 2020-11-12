public class Tablero {
    public Casilla [][] tableroJuego = new Casilla[10][10];

    public Tablero() {
    	for (int col = 0; col < 10; col ++) {
    		for (int row = 0; row < 10; row ++) {
    			tableroJuego[col][row] = new Casilla();
    		}
    	}
    }

    public int getEstadoCasilla(int col, int row) {
        return tableroJuego[col][row].getEstado();

    }

    public void setEstadoCasilla(int col, int row, int estado) {
        tableroJuego[col][row].setEstado(estado);
    }

}