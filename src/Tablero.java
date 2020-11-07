public class Tablero {
    public Casilla [][] tableroJuego = new Casilla[10][10];

    public Tablero() {
    
    }

    public int getEstadoCasilla(int col, int row) {
        return tableroJuego[col][row].getEstado();

    }

    public void setEstadoCasilla(int col, int row, int estado) {
        tableroJuego[col][row].setEstado(estado);
    }

}