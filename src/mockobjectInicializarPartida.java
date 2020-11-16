
public class mockobjectInicializarPartida implements Teclado {
	int [] valoresFila = {0,1,2,3,4,5,6,7,8,9};
	int [] valoresColumna = {0,1,2,3,4,5,6,7,8,9};
	int [] valoresOrientacion = {1,1,0,1,0,1,0,1,0,0};
	public int fila;
	public int columna;
	public int orientacion;
	int i = 0;
	public int getFila() {
		return this.fila;
	}


	public int getColumna() {
		return this.columna;
	}


	public int getOrientacion() {
		return this.orientacion;
	}


	public void setFilaColumnaOrientacion() {
		fila = valoresFila[i];
		columna = valoresColumna[i];
		orientacion = valoresOrientacion[i];
		
		i++;
	}

}
