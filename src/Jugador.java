import java.util.Scanner;

public class Jugador {
	public String nombre;
	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int insertaFila(Scanner sc) {
		System.out.print("Que fila quieres atacar?");
		return sc.nextInt();
	}
}
