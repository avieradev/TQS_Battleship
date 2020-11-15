import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Tablero {
	final int FILAS = 10, COLUMNAS = 10;
	final int PORTAAVIONES = 5, BUQUE = 4, SUBMARINO = 3, CRUCERO = 2, LANCHA = 1;
	Stack<Integer> fila = new Stack<Integer>();
	Stack<Integer> columna = new Stack<Integer>();
    public Casilla [][] tableroJuego = new Casilla[FILAS][COLUMNAS];
    protected int totalBarcos = 5;
    
    public Tablero() {
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
    	//SABEMOS QUE COMO MUCHO HARÁ +4 ARRIBA/ABAJO O +4 DERECHA/IZQUIERDA
    	
    	int i = 1;
    	int direccion = 0; //0DERECHA 1IZQUIERDA 2ABAJO 3ARRIBA
    	int desplazamiento = 0;
    	boolean derecha = false;
    	boolean izquierda = false;
    	boolean arriba = false;
    	boolean abajo= false;
    	//MIRAMOS SI VA A LA DERECHA
    	while ( i <= 5) {
    		if(c+i>=10) {
    			derecha = true;
    			if (i > 1) {
    				direccion = 0;
    				desplazamiento = i;
    			}
    			break; //NOS PASAMOS POR LA DERECHA
    		}
    		else {
    			if(tableroJuego[f][c+i].getEstado() == 1) {
    				if(tableroJuego[f][c+i].getRevelada()){
    					i++;
    				}
    				else {
    					derecha = false;
    					break;
    				}
    			}
    			else{
    				if (i > 1) {
        				direccion = 0;
        				desplazamiento = i;
        			}
    				derecha = true;
    				break;
    			}
    		}
    	}
    	if(i > 5) {
    		return false;
    	}
    	//MIRAMOS SI VA A LA IZQUIERDA
    	i = 1;
    	while ( i <= 5) {
    		if(c-i < 0) {
    			if (i > 1) {
    				direccion = 1;
    				desplazamiento = i;
    			}
    			izquierda = true;
    			break; //NOS PASAMOS POR LA IZQUIERDA
    		}
    		else {
    			if(tableroJuego[f][c-i].getEstado() == 1) {
    				if(tableroJuego[f][c-i].getRevelada()){
    					i++;//SEGUIMOS
    				}
    				else {//AUN HAY UNA POR REVELARA
    					izquierda = false;
    					break;
    				}
    			}
    			else{//HA ENCONTRADO AGUA
    				if (i > 1) {
        				direccion = 1;
        				desplazamiento = i;
        			}
    				izquierda = true;
    				break;
    			}
    		}
    	}
    	if(i > 5) {
    		return false;
    	}
    	//MIRAMOS SI VA ABAJO
    	i = 1;
    	while ( i <= 5) {
    		if(f+i>=10) {
    			if (i > 1) {
    				direccion = 2;
    				desplazamiento = i;
    			}
    			abajo = true;
    			break; //NOS PASAMOS POR ABAJO
    		}
    		else {
    			if(tableroJuego[f+i][c].getEstado() == 1) {
    				if(tableroJuego[f+i][c].getRevelada()){
    					i++;
    				}
    				else {
    					abajo = false;
    					break;
    				}
    			}
    			else{
    				if (i > 1) {
        				direccion = 2;
        				desplazamiento = i;
        			}
    				abajo = true;
    				break;
    			}
    		}
    	}
    	if(i > 5) {
    		return false;
    	}
		//MIRAMOS SI VA ARRIBA
    	i = 1;
    	while ( i <= 5) {
    		if(f-i < 0) {
    			if (i > 1) {
    				direccion = 3;
    				desplazamiento = i;
    			}
    			arriba = true;
    			break; //NOS PASAMOS POR ABAJO
    		}
    		else {
    			if(tableroJuego[f-i][c].getEstado() == 1) {
    				if(tableroJuego[f-i][c].getRevelada()){
    					i++;
    				}
    				else {
    					arriba = false;
    					break;
    				}
    			}
    			else{
    				
    				if (i > 1) {
        				direccion = 3;
        				desplazamiento = i;
        			}
    				arriba = true;
    				break;
    			}
    		}
    	}
    	if(i > 5) {
    		return false;
    	}
    	if(izquierda && derecha && abajo && arriba) {
    		tableroJuego[f][c].setEstado(2);
    		revelaZona(f, c);
    		for(int j = 1; j < desplazamiento; j++) {
    			if (direccion == 0) {
    				tableroJuego[f][c+j].setEstado(2);
    				revelaZona(f, c+j);
    			}
    			if (direccion == 1) {
    				tableroJuego[f][c-j].setEstado(2);
    				revelaZona(f, c-j);
    			}
    			if (direccion == 2) {
    				tableroJuego[f+j][c].setEstado(2);
    				revelaZona(f+j, c);
    			}
    			if (direccion == 3) {
    				tableroJuego[f-j][c].setEstado(2);
    				revelaZona(f-j,c);
    			}
    		}
    	}
    	return (izquierda && derecha && abajo && arriba);	
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
    
    
    public boolean setBarcos(int f, int c, int o, int b) {
    	if (o == 0) {
    		for (int i = 0; i != b; i ++) {
    			if(!compruebaAislada(f + i, c)) {
    				return false;
    			}
    		}
    		for (int i = 0; i != b; i ++) {
    			setEstadoCasilla(f + i, c, 1);
    		}
    		return true;
    	}
    	if (o == 1) {
    		for (int i = 0; i != b; i ++) {
    			if(!compruebaAislada(f, c + i)) {
    				return false;
    			}
    		}
    		for (int i = 0; i != b; i ++) {
    			setEstadoCasilla(f, c + i, 1);
    		}
    		return true;
    	}
    	return false;
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