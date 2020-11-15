import java.util.Random;
import java.util.Scanner;

public class Tablero {
	final int FILAS = 10, COLUMNAS = 10;
	final int PORTAAVIONES = 5, BUQUE = 4, SUBMARINO = 3, CRUCERO = 2, LANCHA = 1;
    public Casilla [][] tableroJuego = new Casilla[FILAS][COLUMNAS];
    protected int totalBarcos = 5;
    protected int totalBarcosVivos;
    
    public Tablero() {

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
    
    public void resetCasilla(int f, int c) {

        tableroJuego[f][c].reset();
    }
    
    public void setCasillaRevelada(int f, int c)
    {
    	tableroJuego[f][c].setRevelada();
    }
    
    public boolean getCasillaRevelada(int f, int c) {
    	return tableroJuego[f][c].getRevelada();
    }
    
    public void printTablero() {
    	System.out.print("0: Agua, 1: Tocado, 2: Hundido" + "\n");
    	System.out.print("\t");
    	for (int head = 0; head < 10; head ++) {
				System.out.print(head + "\t");
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
    			if(tableroJuego[f-1][c].getRevelada()) {
    				
    				if(tableroJuego[f-1][c].getVisitada() == false) {
    					tableroJuego[f-1][c].setVisitada();
    					setEstadoCasilla(f-1,c,2);
    					revelaZona(f-1,c);
    					hundida_arriba = compruebaHundida(f-1,c);
    					
    				}
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
    			if(tableroJuego[f+1][c].getRevelada()) {
    				
    				if(tableroJuego[f+1][c].getVisitada() == false) {
    					tableroJuego[f+1][c].setVisitada();
    					setEstadoCasilla(f+1,c,2);
    					revelaZona(f+1,c);
    					hundida_abajo = compruebaHundida(f+1,c);
    					
    				}
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
    			if(tableroJuego[f][c-1].getRevelada()) {
    				
    				if(tableroJuego[f][c-1].getVisitada() == false) {
    					tableroJuego[f][c-1].setVisitada();
    					setEstadoCasilla(f,c-1,2);
    					revelaZona(f,c-1);
    					hundida_izquierda = compruebaHundida(f,c-1);
    					
    				}
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
    			if(tableroJuego[f][c+1].getRevelada()) {
    				
    				if(tableroJuego[f][c+1].getVisitada() == false) {
    					tableroJuego[f][c+1].setVisitada();
    					setEstadoCasilla(f,c+1,2);
    					revelaZona(f,c+1);
    					hundida_derecha = compruebaHundida(f,c+1);
    				}
    			}
   			
    		}
    	}
    	if (hundida_abajo && hundida_arriba && hundida_izquierda && hundida_derecha) {
    		setEstadoCasilla(f,c,2);
    		revelaZona(f,c);
    	}
    	return (hundida_abajo && hundida_arriba && hundida_izquierda && hundida_derecha);
    }
    
    public void revelaZona(int f, int c) {
    	
    	setCasillaRevelada(f,c);
    	//COMPROBACION ESQUINAS
    	if(f == 0 && c == 0) {
    		setCasillaRevelada(f + 1, c);
    		setCasillaRevelada(f, c+1);
    		setCasillaRevelada(f+1, c+1);
    	}
    	else if(f == 9 && c == 9) {
    		setCasillaRevelada(f - 1, c);
    		setCasillaRevelada(f, c-1);
    		setCasillaRevelada(f-1, c-1);
    	}
    	else if(f == 0 && c == 9) {
    		setCasillaRevelada(f + 1, c);
    		setCasillaRevelada(f, c-1);
    		setCasillaRevelada(f+1, c-1);
    	}
    	else if(f == 9 && c == 0) {
    		setCasillaRevelada(f - 1, c);
    		setCasillaRevelada(f, c+1);
    		setCasillaRevelada(f-1, c+1);
    	}
    	//COMPROBACION ARRIBA ABAJO
    	else if(f == 0) {
    		setCasillaRevelada(f + 1, c); 
    		setCasillaRevelada(f, c -1);
    		setCasillaRevelada(f, c + 1);
    		setCasillaRevelada(f +1, c -1);
    		setCasillaRevelada(f+1, c + 1);
    	}
    	else if(f == 9) {
    		setCasillaRevelada(f - 1, c);
    		setCasillaRevelada(f, c - 1);
    		setCasillaRevelada(f, c + 1);
    		setCasillaRevelada(f-1, c -1);
    		setCasillaRevelada(f-1, c + 1);
    	}
    	//COMPROBACION DERECHA IZQUIERDA
    	else if(c == 0) {
    		setCasillaRevelada(f, c + 1); 
    		setCasillaRevelada(f + 1, c );
    		setCasillaRevelada(f - 1, c);
    		setCasillaRevelada(f +1, c +1);
    		setCasillaRevelada(f-1, c + 1);
    	}
    	else if(c == 9) {
    		setCasillaRevelada(f, c - 1);
    		setCasillaRevelada(f + 1, c);
    		setCasillaRevelada(f - 1, c);
    		setCasillaRevelada(f +1, c -1); 
    		setCasillaRevelada(f-1, c - 1);
    	}
    	else{
    	setCasillaRevelada(f - 1, c);
    	setCasillaRevelada(f + 1, c);
    	setCasillaRevelada(f, c + 1);
    	setCasillaRevelada(f, c - 1);
    	setCasillaRevelada(f + 1, c + 1);
    	setCasillaRevelada(f + 1, c - 1);
    	setCasillaRevelada(f - 1, c + 1);
    	setCasillaRevelada(f - 1, c - 1);
    	}
    	
    	
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
    
    
    public void setBarcos(Scanner sc) {
    	int barcosSets = 0;
    	while (barcosSets != 10) {
    		System.out.print("Donde quieres empezar a colocar el portaaviones?" + "\n");
    		System.out.print("Introduce la fila:" + "\n");
    		sc.nextInt();
    		System.out.print("Introduce la columna:" + "\n");
    		sc.nextInt();
    		System.out.print("Introduce la orientación: (0: vertical, 1: horizontal)" + "\n");
    		sc.nextInt();
    	}
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