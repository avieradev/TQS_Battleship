import java.util.Scanner;

public class mockobjectJugador implements InterficieJugador {
	int [] valoresFila = {1,1,9,3,4,5,6,7,8,9};
	int [] valoresColumna = {0,0,2,3,4,5,6,7,8,9};
	int [] valoresOrientacion = {1,1,1,1,0,1,0,1,0,0};
	public int fila;
	public int columna;
	public int orientacion;
	int i = 0;
	
	public String getNombre() {
		return ("MockPlayer");
	}

	public int insertaFila(Scanner sc) {
		return valoresFila[i+1];
	}


	public int insertaColumna(Scanner sc) {
		return valoresColumna[i+1];
	}
	
	public int insertaOrientacion(Scanner sc) {
		return valoresOrientacion[i+1];
	}

	public int insertaValorInicial(Scanner sc) {
		return 1;
	}

}
