import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class mockobjectJugador implements InterficieJugador {
	int [] valoresFila =    {0, 0, 0, 0, 0};
	int [] valoresColumna = {0, 1, 2, 3, 4};
	int [] valoresOrientacion = {1,1,1,1,0,1,0,1,0,0};
	ArrayList<Integer> array_filas =    new ArrayList<Integer>();
	ArrayList<Integer> array_columnas = new ArrayList<Integer>();
	ArrayList<Integer> array_orientacion = new ArrayList<Integer>();

	
	public int fila;
	public int columna;
	public int orientacion;
	int i = 0;
	int j = 0;
	int k = 0;
	public mockobjectJugador(ArrayList<Integer> filas,
			ArrayList<Integer> cols, ArrayList<Integer> orien){
		array_filas = filas;
		array_columnas = cols;
		array_orientacion = orien;
	}
	
	public String getNombre() {
		return ("MockPlayer");
	}

	public int insertaFila(Scanner sc) {
		
		return array_filas.remove(0);
		
	}


	public int insertaColumna(Scanner sc) {
		return array_columnas.remove(0);
		
	}
	
	public int insertaOrientacion(Scanner sc) {
		return array_orientacion.remove(0);
		
	}

	public int insertaValorInicial(Scanner sc) {
		return 1;
	}

}
