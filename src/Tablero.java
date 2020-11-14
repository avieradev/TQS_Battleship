import java.util.Random;

public class Tablero {
	final int FILAS = 10, COLUMNAS = 10;
    public Casilla [][] tableroJuego = new Casilla[FILAS][COLUMNAS];
    protected int totalBarcos;
    protected int totalBarcosVivos;
    
    public Tablero(int totalBarcos) {
    	this.totalBarcos = totalBarcos;
    	totalBarcosVivos = totalBarcos;
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
    
    
    
    public void setCasillaRevelada(int f, int c)
    {
    	tableroJuego[f][c].setRevelada();
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
    	System.out.print("\n\n");
    	for (int f = 0;f < FILAS; f ++) {
    		System.out.print(f + "\t");
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
    
    public boolean compruebaHundida(int f, int c) {
    	
    	//FILA SUPERIOR
    	boolean hundida_arriba = true;
    	if(f-1 >= 0) {
    		if(tableroJuego[f-1][c].getEstado() == 1 && tableroJuego[f-1][c].getRevelada() == false) {
    			return false;
    		}
    		else if(tableroJuego[f-1][c].getEstado() == 1){
    			if(tableroJuego[f-1][c].getVisitada() == false) {
    				tableroJuego[f-1][c].setVisitada();
    				hundida_arriba = compruebaHundida(f-1,c);	
    			}
    			
    		}
    		
    	}
    	//FILA INFERIOR
    	boolean hundida_abajo = true;
    	if(f+1 < 10) {
    		if(tableroJuego[f+1][c].getEstado() == 1 && tableroJuego[f+1][c].getRevelada() == false) {
    			return false;
    		}
    		else if(tableroJuego[f+1][c].getEstado() == 1){
    			if(tableroJuego[f+1][c].getVisitada() == false) {
    				tableroJuego[f+1][c].setVisitada();
    				hundida_abajo = compruebaHundida(f+1,c);
    			}
    		}
    	}
    	//LADO IZQUIERDO
    	boolean hundida_izquierda = true;
    	if(c-1 >= 0) {
    		if(tableroJuego[f][c-1].getEstado() == 1 && tableroJuego[f][c-1].getRevelada() == false) {
    			return false;
    		}
    		else if(tableroJuego[f][c-1].getEstado() == 1){
    			if(tableroJuego[f][c-1].getVisitada() == false) {
    				tableroJuego[f][c-1].setVisitada();
    				hundida_izquierda = compruebaHundida(f,c-1);
    			}
    			
    		}
    	}
    	//LADO DERECHO
    	boolean hundida_derecha = true;
    	if(c+1 < 10) {
    		if(tableroJuego[f][c+1].getEstado() == 1 && tableroJuego[f][c+1].getRevelada() == false) {
    			return false;
    		}
    		else if(tableroJuego[f][c+1].getEstado() == 1){
    			if(tableroJuego[f][c+1].getVisitada() == false) {
    				tableroJuego[f][c+1].setVisitada();
    				hundida_izquierda = compruebaHundida(f,c+1);
    			}
    			
    		}
    	}
    	return (hundida_abajo && hundida_arriba && hundida_izquierda && hundida_derecha);
    }
    
    public void setBarcosAleatorios() {
    	//empiezo con barcos de 3 posiciones
    	int barcosColocados = 0;
    	while (barcosColocados != totalBarcos) {
    		int posicionRandom = generarRandom(3); //0 arriba, 1 dercha, 2 abajo, 3 izquierda
    		int cRand = generarRandom(9);
    		int fRand = generarRandom(9);
    		switch(posicionRandom) {
    		case 0:
    			
    			if(compruebaAislada(fRand, cRand)) {
    				if(compruebaAislada(fRand - 1, cRand)) {
    					if(compruebaAislada(fRand - 2, cRand)) {
    						
    						setEstadoCasilla(fRand, cRand, 1);
    						setEstadoCasilla(fRand - 1, cRand, 1);
    						setEstadoCasilla(fRand - 2, cRand, 1);
    						barcosColocados++;
    	
    					}
    				}
    			}
    		case 1:
    			
    			if(compruebaAislada(fRand, cRand)) {
    				if(compruebaAislada(fRand, cRand + 1)) {
    					if(compruebaAislada(fRand, cRand + 2)) {
    						
    						setEstadoCasilla(fRand, cRand + 1, 1);
    						setEstadoCasilla(fRand, cRand + 2, 1);
    						setEstadoCasilla(fRand, cRand, 1);
    						barcosColocados++;
    					}
    				}
    			}
    		case 2:
    			
    			if(compruebaAislada(fRand, cRand)) {
    				if(compruebaAislada(fRand + 1, cRand)) {
    					if(compruebaAislada(fRand + 2, cRand)) {
    						
    						setEstadoCasilla(fRand + 1, cRand, 1);
    						setEstadoCasilla(fRand + 2, cRand, 1);
    						setEstadoCasilla(fRand, cRand, 1);
    						barcosColocados++;
    					}
    				}
    			}
    		case 3:
    			
    			if(compruebaAislada(fRand, cRand)) {
    				if(compruebaAislada(fRand, cRand - 1)) {
    					if(compruebaAislada(fRand, cRand - 2)) {
    						
    						setEstadoCasilla(fRand, cRand - 1, 1);
    						setEstadoCasilla(fRand, cRand - 2, 1);
    						setEstadoCasilla(fRand, cRand, 1);
    						barcosColocados++;
    					}
    				}
    			}
    		
    		}
    		
    	}
    }
    
    public int getBarcosVivos() {
    	return totalBarcosVivos;
    }
    
   public boolean compruebaPosicionValida(int f, int c){
	   if(f < 0 || f > 9 || c < 0 || c > 9) {
		   return false;
	   }
	   else if(tableroJuego[f][c].getRevelada() == true)
	   {
		   return false;
	   }
	   else {
		   return true;   
	   }

   }
   
   public boolean compruebaAislada(int f, int c) {
    	if(f < 0 || f > 9 || c < 0 || c > 9) return false;
    	//COMPROBACION ESQUINAS
    	if(f == 0 && c == 0) {
    		return compruebaCasillaVacia(f + 1, c) && compruebaCasillaVacia(f, c+1)
    				&& compruebaCasillaVacia(f+1, c+1);
    	}
    	if(f == 9 && c == 9) {
    		return compruebaCasillaVacia(f - 1, c) && compruebaCasillaVacia(f, c-1)
    				&& compruebaCasillaVacia(f-1, c-1);
    	}
    	if(f == 0 && c == 9) {
    		return compruebaCasillaVacia(f + 1, c) && compruebaCasillaVacia(f, c-1)
    				&& compruebaCasillaVacia(f+1, c-1);
    	}
    	if(f == 9 && c == 0) {
    		return compruebaCasillaVacia(f - 1, c) && compruebaCasillaVacia(f, c+1)
    				&& compruebaCasillaVacia(f-1, c+1);
    	}
    	//COMPROBACION ARRIBA ABAJO
    	if(f == 0) {
    		return compruebaCasillaVacia(f + 1, c) 
    				&& compruebaCasillaVacia(f, c -1) && compruebaCasillaVacia(f, c + 1)
    				&& compruebaCasillaVacia(f +1, c -1) && compruebaCasillaVacia(f+1, c + 1);
    	}
    	if(f == 9) {
    		return compruebaCasillaVacia(f - 1, c) 
    				&& compruebaCasillaVacia(f, c - 1) && compruebaCasillaVacia(f, c + 1)
    				&& compruebaCasillaVacia(f-1, c -1) && compruebaCasillaVacia(f-1, c + 1);
    	}
    	//COMPROBACION DERECHA IZQUIERDA
    	if(c == 0) {
    		return compruebaCasillaVacia(f, c + 1) 
    				&& compruebaCasillaVacia(f + 1, c ) && compruebaCasillaVacia(f - 1, c)
    				&& compruebaCasillaVacia(f +1, c +1) && compruebaCasillaVacia(f-1, c + 1);
    	}
    	if(c == 9) {
    		return compruebaCasillaVacia(f, c - 1) 
    				&& compruebaCasillaVacia(f + 1, c) && compruebaCasillaVacia(f - 1, c)
    				&& compruebaCasillaVacia(f +1, c -1) && compruebaCasillaVacia(f-1, c - 1);
    	}
    	//COMPROBACION CASILLA INTERIOR
    	return compruebaCasillaVacia(f - 1, c) && compruebaCasillaVacia(f + 1, c) 
    			&& compruebaCasillaVacia(f, c + 1) && compruebaCasillaVacia(f, c - 1)
    			&& compruebaCasillaVacia(f + 1, c + 1) && compruebaCasillaVacia(f + 1, c - 1)
    			&& compruebaCasillaVacia(f - 1, c + 1) && compruebaCasillaVacia(f - 1, c - 1);
    	
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