import java.util.Scanner;

public class mockobjectJugador implements InterficieJugador {
	int [] valoresFila =    {0, 0, 0, 0, 0};
	int [] valoresColumna = {0, 1, 2, 3, 4};
	int [] valoresOrientacion = {1,1,1,1,0,1,0,1,0,0};
	public int fila;
	public int columna;
	public int orientacion;
	int i = 0;
	int j = 0;
	int k = 0;
	
	public String getNombre() {
		return ("MockPlayer");
	}

	public int insertaFila(Scanner sc) {
		
		i++;
		return valoresFila[0+i];
		
	}


	public int insertaColumna(Scanner sc) {
		j++;
		return valoresColumna[0+j];
		
	}
	
	public int insertaOrientacion(Scanner sc) {
		k++;
		return valoresOrientacion[0+k];
		
	}

	public int insertaValorInicial(Scanner sc) {
		return 1;
	}

}
