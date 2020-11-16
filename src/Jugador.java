import java.util.Scanner;

public class Jugador implements InterficieJugador {
	public String nombre;
	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int insertaFila(Scanner sc) {
		System.out.print("Que fila quieres?");
		return sc.nextInt();
	}
	
	public int insertaColumna(Scanner sc) {
		System.out.print("Que columna quieres?");
		return sc.nextInt();
	}
	public int insertaOrientacion(Scanner sc) {
		System.out.print("Que orientación quieres? (0: vertical, 1: horizontal)");
		return sc.nextInt();
	}
	
	public int insertaValorInicial(Scanner sc) {
		return sc.nextInt();
	}
}
