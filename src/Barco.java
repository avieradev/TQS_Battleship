
public class Barco {
	protected int tamanoBarco;
	protected int estado[]; //array de 0 al iniciar, posicion de 1 cuando tocado
	
			public Barco(int tamanoBarco) {
				this.tamanoBarco = tamanoBarco;
				estado = new int[tamanoBarco];
				for (int x = 0; x < tamanoBarco; x ++) {
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
