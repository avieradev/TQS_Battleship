import java.util.Scanner;

public interface InterficieJugador {	
	public String getNombre();
	
	public int insertaFila(Scanner sc);
	
	public int insertaColumna(Scanner sc);
	
	public int insertaOrientacion(Scanner sc);
	
	public int insertaValorInicial(Scanner sc);
}
