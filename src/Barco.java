
public class Barco {
	protected int tamano;
	protected int estado[]; //array de 0 al iniciar, posicion de 1 cuando tocado
	
			public Barco(int tamano) {
				this.tamano = tamano;
				estado = new int[tamano];
				for (int x = 0; x < tamano; x ++) {
					 estado[x] = 0;
				}
			}
			public void setTocadoParte(int posicion) {
				estado[posicion] = 1;
			}
			public boolean getEstado() {
				
				return true;
			}
			public int getEstadoParte(int posicion) {
				return estado[posicion];
			}
}
