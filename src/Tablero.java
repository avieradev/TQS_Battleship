import java.util.Random;

public class Tablero {
	final int FILAS = 10, COLUMNAS = 10;
    public Casilla [][] tableroJuego = new Casilla[FILAS][COLUMNAS];
    protected int totalBarcos;

    public Tablero(int totalBarcos) {
    	this.totalBarcos = totalBarcos;
    	for (int f = 0; f < FILAS; f ++) {
    		for (int c = 0; c < COLUMNAS ; c ++) {
    			tableroJuego[f][c] = new Casilla();
    		}
    	}
    }

    public int getEstadoCasilla(int f, int c) {
        return tableroJuego[f][c].getEstado();

    }

    public void setEstadoCasilla(int f, int c, int estado) {
    	
        tableroJuego[f][c].setEstado(estado);
    }
    
    public void printTablero() {
    	for (int head = 0; head < 10; head ++) {
    		switch (head) {
			case 0:
				System.out.print("A" + "\t");
				break;
			case 1:
				System.out.print("B" + "\t");
				break;
			case 2:
				System.out.print("C" + "\t");
				break;
			case 3:
				System.out.print("D" + "\t");
				break;
			case 4:
				System.out.print("E" + "\t");
				break;
			case 5:
				System.out.print("F" + "\t");
				break;
			case 6:
				System.out.print("G" + "\t");
				break;
			case 7:
				System.out.print("H" + "\t");
				break;
			case 8:
				System.out.print("I" + "\t");
				break;
			case 9:
				System.out.print("J" + "\t");
				break;
			}
    	}
    	System.out.print("\n");
    	for (int f = 0;f < FILAS; f ++) {
    		for (int c = 0;c < COLUMNAS; c ++) {
    			if(tableroJuego[f][c].getRevelada()) {
    				
    				System.out.print(getEstadoCasilla(f,c) + "\t");
    			}
    			else {
    				System.out.print("-" + "\t");
    			}
    		}
    		System.out.print("\n");
    	}
    }
    
    public void setBarcosAleatorios() {
    	//empiezo con barcos de 3 posiciones
    	int barcosColocados = 0;
    	int Random; //1 arriba, 2 dercha, 3 abajo, 4 izquierda
    	while (barcosColocados != totalBarcos) {
    		int cRand = generarRandom(9);
    		int fRand = generarRandom(9);
    		
    			setEstadoCasilla(fRand, cRand, 1);
    		
    		barcosColocados++;
    	}
    }
    
    public boolean compruebaAislada(int f, int c) {
    	//primero compruebo las cuatro esquinas del tablero
    	if(f == 0 && c == 0) {
    		return compruebaCasillaVacia(f + 1, c) && compruebaCasillaVacia(f, c+1);
    	}
    	if(f == 9 && c == 9) {
    		return compruebaCasillaVacia(f - 1, c) && compruebaCasillaVacia(f, c-1);
    	}
    	if(f == 0 && c == 9) {
    		return compruebaCasillaVacia(f + 1, c) && compruebaCasillaVacia(f, c-1);
    	}
    	if(f == 9 && c == 0) {
    		return compruebaCasillaVacia(f - 1, c) && compruebaCasillaVacia(f, c+1);
    	}
    	//ahora compruebo los bordes izquierda y derecha
    	if(f == 0) {
    		return compruebaCasillaVacia(f + 1, c) 
    				&& compruebaCasillaVacia(f, c -1) 
    				&& compruebaCasillaVacia(f, c + 1);
    	}
    	if(f == 9) {
    		return compruebaCasillaVacia(f - 1, c) 
    				&& compruebaCasillaVacia(f, c + 1) 
    				&& compruebaCasillaVacia(f, c - 1);
    	}
    	//ahora compuerbo los bordes arriba y abajo
    	if(c == 0) {
    		return compruebaCasillaVacia(f, c + 1) 
    				&& compruebaCasillaVacia(f + 1, c ) 
    				&& compruebaCasillaVacia(f - 1, c);
    	}
    	if(c == 9) {
    		return compruebaCasillaVacia(f, c - 1) 
    				&& compruebaCasillaVacia(f + 1, c) 
    				&& compruebaCasillaVacia(f - 1, c);
    	}
    	//ahora compruebo cualquier casilla en medio
    	return compruebaCasillaVacia(f - 1, c) 
    			&& compruebaCasillaVacia(f + 1, c) 
    			&& compruebaCasillaVacia(f, c + 1) 
    			&& compruebaCasillaVacia(f, c - 1);
    	
    }
    
    public boolean compruebaCasillaVacia(int f, int c) {
    	return getEstadoCasilla(f, c) == 0;
    }
    
    public int generarRandom(int max) {
    	Random random = new Random();
    	int valorDado = random.nextInt(max);
    	return valorDado;
    }

}