public class Tablero {
    public Casilla [][] tableroJuego = new Casilla[10][10];
    protected int totalBarcos;

    public Tablero(int totalBarcos) {
    	this.totalBarcos = totalBarcos;
    	for (int col = 0; col < 10; col ++) {
    		for (int row = 0; row < 10; row ++) {
    			tableroJuego[col][row] = new Casilla();
    		}
    	}
    }

    public int getEstadoCasilla(int col, int row) {
        return tableroJuego[col][row].getEstado();

    }

    public void setEstadoCasilla(int col, int row, int estado) {
        tableroJuego[col][row].setEstado(estado);
    }
    
    public void printTablero() {
    	System.out.print("\t");
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
    	for (int col = 0;col < 10; col ++) {
    		System.out.print(col + "\t");
    		for (int row = 0;row < 10; row ++) {
    			if (tableroJuego[col][row].getEstado() == 0) {
    				System.out.print("-" + "\t");
    			}
    		}
    		System.out.print("\n");
    	}
    }
    
    public void setBarcosAleatorios() {
    	int barcosColocados = 0;
    	int Random; //1 arriba, 2 dercha, 3 abajo, 4 izquierda
    	while (barcosColocados != totalBarcos) {
    		int columnaRand = generarRandom(10);
    		int filaRand = generarRandom(10);
    		if(tableroJuego[columnaRand][filaRand].getEstado() == 0) {
    			if(columnaRand == 0 && filaRand == 0) {
    				if(tableroJuego[columnaRand + 1][filaRand].getEstado() == 0) {
    					
    				}
    			}
    		}
    		barcosColocados++;
    	}
    }
    
    public boolean compruebaCasilla() {
    	return true;
    }
    
    public int generarRandom(int max) {
    	int valorDado = (int)(Math.random()*max+1);
    	return valorDado;
    }

}