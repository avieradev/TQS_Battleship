import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTablero {
	Tablero tableroPrueba = new Tablero();
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test //TEST CAJA NEGRA COMPRUEBA OUTPUT CORRECTO
    public void testCreacionTablero() {
        assertEquals(tableroPrueba.getEstadoCasilla(0,0), 0);
        assertEquals(tableroPrueba.getEstadoCasilla(0,9), 0);
        assertEquals(tableroPrueba.getEstadoCasilla(9,0), 0);
        assertEquals(tableroPrueba.getEstadoCasilla(9,9), 0);
    }
    
    @Test //TEST CAJA NEGRA COMPRUEBA COMPORTAMIENTO CORRECTO
    public void testSetEstadoCasilla() {
    	tableroPrueba.setEstadoCasilla(1,1, 1);
    	assertEquals(tableroPrueba.getEstadoCasilla(1,1), 1);
    }

    @Test  //TEST CAJA NEGRA COMPRUEBA COMPORTAMIENTO CORRECTO
    public void testGenerarRandom() {
    	assertEquals(tableroPrueba.generarRandom(1), 0);
    }
    
    @Test //TEST CAJA NEGRA COMPRUEBA COMPORTAMIENTO CORRECTO
    public void testCompruebaCasillaVacia() {
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 0), 0);
    }
    
    @Test //TEST CAJA NEGRA COMPRUEBA COMPORTAMIENTO CORRECTO
    public void testResetCasilla() {
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.resetCasilla(0, 0);
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 0), 0);
    }
    
    @Test  //TEST CAJA NEGRA COMPRUEBA COMPORTAMIENTO CORRECTO
    public void testGetCasillaRevelada() {
    	tableroPrueba.setCasillaRevelada(0, 0);
    	assertTrue(tableroPrueba.getCasillaRevelada(0,0));
    	tableroPrueba.resetCasilla(0, 0);
    } 

    @Test //TEST CAJA NEGRA COMPRUEBA COMPORTAMIENTO CORRECTO EN VALORES LIMITE
    public void testCompruebaHundidaNegra() {
    	//BARCO EN ESQUINA 0-0 y HORIZONTAL
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.setEstadoCasilla(0, 1, 1);
    	tableroPrueba.setEstadoCasilla(0, 2, 1);
    	assertFalse(tableroPrueba.compruebaHundida(0, 0));
    	tableroPrueba.setCasillaRevelada(0, 1);
    	assertFalse(tableroPrueba.compruebaHundida(0, 0));
    	tableroPrueba.setCasillaRevelada(0, 2);
    	assertTrue(tableroPrueba.compruebaHundida(0, 0));
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 0), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 1), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 2), 2);
    	tableroPrueba.resetCasilla(0, 0);
    	tableroPrueba.resetCasilla(0, 1);
    	tableroPrueba.resetCasilla(0, 2);
    	
    	//BARCO EN ESQUINA 0-0 y VERTICAL
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.setEstadoCasilla(1, 0, 1);
    	tableroPrueba.setEstadoCasilla(2, 0, 1);
    	assertFalse(tableroPrueba.compruebaHundida(0, 0));
    	tableroPrueba.setCasillaRevelada(1, 0);
    	assertFalse(tableroPrueba.compruebaHundida(0, 0));
    	tableroPrueba.setCasillaRevelada(2, 0);
    	assertTrue(tableroPrueba.compruebaHundida(0, 0));
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 0), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(1, 0), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(2, 0), 2);
    	tableroPrueba.resetCasilla(0, 0);
    	tableroPrueba.resetCasilla(1, 0);
    	tableroPrueba.resetCasilla(2, 0);
    	
    	//BARCO EN ESQUINA 0-9 y HORIZONTAL
    	tableroPrueba.setEstadoCasilla(0, 9, 1);
    	tableroPrueba.setEstadoCasilla(0, 8, 1);
    	tableroPrueba.setEstadoCasilla(0, 7, 1);
    	assertFalse(tableroPrueba.compruebaHundida(0, 9));
    	tableroPrueba.setCasillaRevelada(0, 8);
    	assertFalse(tableroPrueba.compruebaHundida(0, 9));
    	tableroPrueba.setCasillaRevelada(0, 7);
    	assertTrue(tableroPrueba.compruebaHundida(0, 9));
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 9), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 8), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 7), 2);
    	tableroPrueba.resetCasilla(0, 9);
    	tableroPrueba.resetCasilla(0, 8);
    	tableroPrueba.resetCasilla(0, 7);
    	
    	//BARCO EN ESQUINA 0-9 y VERTICAL
    	tableroPrueba.setEstadoCasilla(0, 9, 1);
    	tableroPrueba.setEstadoCasilla(1, 9, 1);
    	tableroPrueba.setEstadoCasilla(2, 9, 1);
    	assertFalse(tableroPrueba.compruebaHundida(0, 9));
    	tableroPrueba.setCasillaRevelada(1, 9);
    	assertFalse(tableroPrueba.compruebaHundida(0, 9));
    	tableroPrueba.setCasillaRevelada(2, 9);
    	assertTrue(tableroPrueba.compruebaHundida(0, 9));
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 9), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(1, 9), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(2, 9), 2);
    	tableroPrueba.resetCasilla(0, 9);
    	tableroPrueba.resetCasilla(1, 9);
    	tableroPrueba.resetCasilla(2, 9);
    	
    	//BARCO EN ESQUINA 9-0 Y HORIZONTAL
    	tableroPrueba.setEstadoCasilla(9, 0, 1);
    	tableroPrueba.setEstadoCasilla(9, 1, 1);
    	tableroPrueba.setEstadoCasilla(9, 2, 1);
    	assertFalse(tableroPrueba.compruebaHundida(9, 0));
    	tableroPrueba.setCasillaRevelada(9, 1);
    	assertFalse(tableroPrueba.compruebaHundida(9, 0));
    	tableroPrueba.setCasillaRevelada(9, 2);
    	assertTrue(tableroPrueba.compruebaHundida(9, 0));
    	assertEquals(tableroPrueba.getEstadoCasilla(9, 0), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(9, 1), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(9, 2), 2);
    	tableroPrueba.resetCasilla(9, 0);
    	tableroPrueba.resetCasilla(9, 1);
    	tableroPrueba.resetCasilla(9, 2);
    	
    	//BARCO EN ESQUINA 9-0 Y VERTICAL
    	tableroPrueba.setEstadoCasilla(9, 0, 1);
    	tableroPrueba.setEstadoCasilla(8, 0, 1);
    	tableroPrueba.setEstadoCasilla(7, 0, 1);
    	assertFalse(tableroPrueba.compruebaHundida(9, 0));
    	tableroPrueba.setCasillaRevelada(8, 0);
    	assertFalse(tableroPrueba.compruebaHundida(9, 0));
    	tableroPrueba.setCasillaRevelada(7, 0);
    	assertTrue(tableroPrueba.compruebaHundida(9, 0));
    	assertEquals(tableroPrueba.getEstadoCasilla(9, 0), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(8, 0), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(7, 0), 2);
    	tableroPrueba.resetCasilla(9, 0);
    	tableroPrueba.resetCasilla(8, 0);
    	tableroPrueba.resetCasilla(7, 0);
    	
    	//BARCO EN ESQUINA 9-9 Y HORIZONTAL
    	tableroPrueba.setEstadoCasilla(9, 7, 1);
    	tableroPrueba.setEstadoCasilla(9, 8, 1);
    	tableroPrueba.setEstadoCasilla(9, 9, 1);
    	assertFalse(tableroPrueba.compruebaHundida(9, 9));
    	tableroPrueba.setCasillaRevelada(9, 7);
    	assertFalse(tableroPrueba.compruebaHundida(9, 9));
    	tableroPrueba.setCasillaRevelada(9, 8);
    	assertTrue(tableroPrueba.compruebaHundida(9, 9));
    	assertEquals(tableroPrueba.getEstadoCasilla(9, 7), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(9, 8), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(9, 9), 2);
    	tableroPrueba.resetCasilla(9, 7);
    	tableroPrueba.resetCasilla(9, 8);
    	tableroPrueba.resetCasilla(9, 9);
    	
    	//BARCO EN ESQUINA 9-9 Y VERTICAL
    	tableroPrueba.setEstadoCasilla(9, 9, 1);
    	tableroPrueba.setEstadoCasilla(8, 9, 1);
    	tableroPrueba.setEstadoCasilla(7, 9, 1);
    	assertFalse(tableroPrueba.compruebaHundida(9, 9));
    	tableroPrueba.setCasillaRevelada(8, 9);
    	assertFalse(tableroPrueba.compruebaHundida(9, 9));
    	tableroPrueba.setCasillaRevelada(7, 9);
    	assertTrue(tableroPrueba.compruebaHundida(9, 9));
    	assertEquals(tableroPrueba.getEstadoCasilla(9, 9), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(8, 9), 2);
    	assertEquals(tableroPrueba.getEstadoCasilla(7, 9), 2);
    	tableroPrueba.resetCasilla(9, 9);
    	tableroPrueba.resetCasilla(8, 9);
    	tableroPrueba.resetCasilla(7, 9);
    	
    	//CREAR UN SOLO BARCO
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	assertTrue(tableroPrueba.compruebaHundida(0, 0));
    	tableroPrueba.resetCasilla(0, 0);
    	
    }
    
    @Test //PRUEBAS DE CAJA BLANCA PARA COMPLETAR COVERAGE
    public void testCompruebaHundida() {
    	
    	//CREAR UN BARCO MÁS GRANDE DE LO POSIBLE HACIA LA DERECHA
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.setEstadoCasilla(0, 1, 1);
    	tableroPrueba.setEstadoCasilla(0, 2, 1);
    	tableroPrueba.setEstadoCasilla(0, 3, 1);
    	tableroPrueba.setEstadoCasilla(0, 4, 1);
    	tableroPrueba.setEstadoCasilla(0, 5, 1);
    	tableroPrueba.setCasillaRevelada(0, 1);
    	tableroPrueba.setCasillaRevelada(0, 2);
    	tableroPrueba.setCasillaRevelada(0, 3);
    	tableroPrueba.setCasillaRevelada(0, 4);
    	tableroPrueba.setCasillaRevelada(0, 5);
    	assertFalse(tableroPrueba.compruebaHundida(0, 0));
    	tableroPrueba.resetCasilla(0, 0);
    	tableroPrueba.resetCasilla(0, 1);
    	tableroPrueba.resetCasilla(0, 2);
    	tableroPrueba.resetCasilla(0, 3);
    	tableroPrueba.resetCasilla(0, 4);
    	tableroPrueba.resetCasilla(0, 5);
    	
    	//CREAR UN BARCO MÁS GRANDE HACIA LA DERECHA
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.setEstadoCasilla(0, 1, 1);
    	tableroPrueba.setEstadoCasilla(0, 2, 1);
    	tableroPrueba.setEstadoCasilla(0, 3, 1);
    	tableroPrueba.setEstadoCasilla(0, 4, 1);
    	tableroPrueba.setEstadoCasilla(0, 5, 1);
    	tableroPrueba.setCasillaRevelada(0, 0);
    	tableroPrueba.setCasillaRevelada(0, 1);
    	tableroPrueba.setCasillaRevelada(0, 2);
    	tableroPrueba.setCasillaRevelada(0, 3);
    	tableroPrueba.setCasillaRevelada(0, 4);
    	assertFalse(tableroPrueba.compruebaHundida(0, 5));
    	tableroPrueba.resetCasilla(0, 0);
    	tableroPrueba.resetCasilla(0, 1);
    	tableroPrueba.resetCasilla(0, 2);
    	tableroPrueba.resetCasilla(0, 3);
    	tableroPrueba.resetCasilla(0, 4);
    	tableroPrueba.resetCasilla(0, 5);
    	
    	//CREAR UN BARCO MÁS GRANDE DE LO POSIBLE HACIA ABAJO
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.setEstadoCasilla(1, 0, 1);
    	tableroPrueba.setEstadoCasilla(2, 0, 1);
    	tableroPrueba.setEstadoCasilla(3, 0, 1);
    	tableroPrueba.setEstadoCasilla(4, 0, 1);
    	tableroPrueba.setEstadoCasilla(5, 0, 1);
    	tableroPrueba.setCasillaRevelada(1, 0);
    	tableroPrueba.setCasillaRevelada(2, 0);
    	tableroPrueba.setCasillaRevelada(3, 0);
    	tableroPrueba.setCasillaRevelada(4, 0);
    	tableroPrueba.setCasillaRevelada(5, 0);
    	assertFalse(tableroPrueba.compruebaHundida(0, 0));
    	tableroPrueba.resetCasilla(0, 0);
    	tableroPrueba.resetCasilla(1, 0);
    	tableroPrueba.resetCasilla(2, 0);
    	tableroPrueba.resetCasilla(3, 0);
    	tableroPrueba.resetCasilla(4, 0);
    	tableroPrueba.resetCasilla(5, 0);
    	
    	//CREAR UN BARCO MÁS GRANDE DE LO POSIBLE HACIA ARRIBA
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.setEstadoCasilla(1, 0, 1);
    	tableroPrueba.setEstadoCasilla(2, 0, 1);
    	tableroPrueba.setEstadoCasilla(3, 0, 1);
    	tableroPrueba.setEstadoCasilla(4, 0, 1);
    	tableroPrueba.setEstadoCasilla(5, 0, 1);
    	tableroPrueba.setCasillaRevelada(0, 0);
    	tableroPrueba.setCasillaRevelada(1, 0);
    	tableroPrueba.setCasillaRevelada(2, 0);
    	tableroPrueba.setCasillaRevelada(3, 0);
    	tableroPrueba.setCasillaRevelada(4, 0);
    	assertFalse(tableroPrueba.compruebaHundida(5, 0));
    	tableroPrueba.resetCasilla(0, 0);
    	tableroPrueba.resetCasilla(1, 0);
    	tableroPrueba.resetCasilla(2, 0);
    	tableroPrueba.resetCasilla(3, 0);
    	tableroPrueba.resetCasilla(4, 0);
    	tableroPrueba.resetCasilla(5, 0);
    	
    	//FORZAR SALIDA DERECHA
    	tableroPrueba.setEstadoCasilla(9, 8, 1);
    	tableroPrueba.setEstadoCasilla(9, 9, 1);
    	tableroPrueba.setCasillaRevelada(9, 9);
    	assertTrue(tableroPrueba.compruebaHundida(9, 8));
    	tableroPrueba.resetCasilla(9, 8);
    	tableroPrueba.resetCasilla(9, 9);
    	
    	//FORZAR SALIDA IZQUIERDA
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.setEstadoCasilla(0, 1, 1);
    	tableroPrueba.setCasillaRevelada(0, 0);
    	assertTrue(tableroPrueba.compruebaHundida(0, 1));
    	tableroPrueba.resetCasilla(0, 0);
    	tableroPrueba.resetCasilla(0, 1);

    	//FORZAR SALIDA ABAJO
    	tableroPrueba.setEstadoCasilla(8, 9, 1);
    	tableroPrueba.setEstadoCasilla(9, 9, 1);
    	tableroPrueba.setCasillaRevelada(9, 9);
    	assertTrue(tableroPrueba.compruebaHundida(8, 9));
    	tableroPrueba.resetCasilla(8, 9);
    	tableroPrueba.resetCasilla(9, 9);
    	
    	//FORZAR SALIDA ARRIBA
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.setEstadoCasilla(1, 0, 1);
    	tableroPrueba.setCasillaRevelada(0, 0);
    	assertTrue(tableroPrueba.compruebaHundida(1, 0));
    	tableroPrueba.resetCasilla(0, 0);
    	tableroPrueba.resetCasilla(1, 0);
    	
    	
 
    	
    }
    
    @Test //TEST CAJA NEGRA COMPRUEBA COMPORTAMIENTO CORRECTO
    public void testRevelaZonaNegra() {
    	
    	//COMPROBAMOS ESQUINAS
    	assertTrue(tableroPrueba.revelaZona(0,0));
    	
    	assertTrue(tableroPrueba.revelaZona(0,9));
    	
    	assertTrue(tableroPrueba.revelaZona(9,0));

    	assertTrue(tableroPrueba.revelaZona(9,9));
    	
    	//COMPROBAMOS BORDES
    	assertTrue(tableroPrueba.revelaZona(0,5));
    	
    	assertTrue(tableroPrueba.revelaZona(9,5));
    	
    	assertTrue(tableroPrueba.revelaZona(5,0));
    	
    	assertTrue(tableroPrueba.revelaZona(5,9));
    	
    	//COMPROBAMOS CASILLA IMPOSIBLE
    	assertFalse(tableroPrueba.revelaZona(11, 24));
    }
    
    @Test //TEST CAJA BLANCA PARA CUBRIR
    public void testRevelaZona() {

    	assertTrue(tableroPrueba.revelaZona(5,5));
 
    }
    
    @Test //TEST CAJA NEGRA COMPRUEBA OUTPUT CORRECTO
    public void testCompruebaPosicionValida()
    {
    	//SOBREPASA LIMITES
    	assertFalse(tableroPrueba.compruebaPosicionValida(-1, 0));
    	assertFalse(tableroPrueba.compruebaPosicionValida(0, -1));
    	assertFalse(tableroPrueba.compruebaPosicionValida(10, 0));
    	assertFalse(tableroPrueba.compruebaPosicionValida(0, 10));
    	
    	//YA ESTA REVELADA
    	tableroPrueba.setCasillaRevelada(0, 0);
    	assertFalse(tableroPrueba.compruebaPosicionValida(0, 0));
    	tableroPrueba.resetCasilla(0,0);
    	
    	//CORRECTA
    	assertTrue(tableroPrueba.compruebaPosicionValida(5, 5));
    	
    	//ESQUINAS
    	assertTrue(tableroPrueba.compruebaPosicionValida(0, 0));
    	assertTrue(tableroPrueba.compruebaPosicionValida(0, 9));
    	assertTrue(tableroPrueba.compruebaPosicionValida(9, 0));
    	assertTrue(tableroPrueba.compruebaPosicionValida(9, 9));
    	
    }
    
    @Test //TEST CAJA NEGRA COMPRUEBA OUTPUT CORRECTO
    public void testCompruebaAisladaNegra() {
	
    	//SOBREPASA LIMITES
    	assertFalse(tableroPrueba.compruebaAislada(-1, 0));
    	assertFalse(tableroPrueba.compruebaAislada(0, -1));
    	assertFalse(tableroPrueba.compruebaAislada(10, 0));
    	assertFalse(tableroPrueba.compruebaAislada(0, 10));
    	
    	//COMPROBACION ESQUINAS
    	assertTrue(tableroPrueba.compruebaAislada(0, 0));
    	tableroPrueba.setEstadoCasilla(0, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 0));
    	tableroPrueba.setEstadoCasilla(0, 1, 0);
    	tableroPrueba.setEstadoCasilla(1, 0, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 0));
    	tableroPrueba.setEstadoCasilla(1, 0, 0);
    	tableroPrueba.setEstadoCasilla(1, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 0));
    	tableroPrueba.setEstadoCasilla(1, 1, 0);
    	
    	assertTrue(tableroPrueba.compruebaAislada(9, 9));
    	tableroPrueba.setEstadoCasilla(9, 8, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 9));
    	tableroPrueba.setEstadoCasilla(9, 8, 0);
    	tableroPrueba.setEstadoCasilla(8, 9, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 9));
    	tableroPrueba.setEstadoCasilla(8, 9, 0);
    	tableroPrueba.setEstadoCasilla(8, 8, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 9));
    	tableroPrueba.setEstadoCasilla(8, 8, 0);
    	
    	assertTrue(tableroPrueba.compruebaAislada(0, 9));
    	tableroPrueba.setEstadoCasilla(0, 8, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 9));
    	tableroPrueba.setEstadoCasilla(0, 8, 0);
    	tableroPrueba.setEstadoCasilla(1, 9, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 9));
    	tableroPrueba.setEstadoCasilla(1, 9, 0);
    	tableroPrueba.setEstadoCasilla(1, 8, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 9));
    	tableroPrueba.setEstadoCasilla(1, 8, 0);
    	
    	assertTrue(tableroPrueba.compruebaAislada(9, 0));
    	tableroPrueba.setEstadoCasilla(9, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 0));
    	tableroPrueba.setEstadoCasilla(9, 1, 0);
    	tableroPrueba.setEstadoCasilla(8, 0, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 0));
    	tableroPrueba.setEstadoCasilla(8, 0, 0);
    	tableroPrueba.setEstadoCasilla(8, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 0));
    	tableroPrueba.setEstadoCasilla(8, 1, 0);
    	
    	//COMPROBACION FILA INFERIOR
    	assertTrue(tableroPrueba.compruebaAislada(9, 1));
    	tableroPrueba.setEstadoCasilla(9, 2, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 1));
    	tableroPrueba.setEstadoCasilla(9, 2, 0);
    	tableroPrueba.setEstadoCasilla(9, 0, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 1));
    	tableroPrueba.setEstadoCasilla(9, 0, 0);
    	tableroPrueba.setEstadoCasilla(8, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 1));
    	tableroPrueba.setEstadoCasilla(8, 1, 0);
    	tableroPrueba.setEstadoCasilla(8, 0, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 1));
    	tableroPrueba.setEstadoCasilla(8, 0, 0);
    	tableroPrueba.setEstadoCasilla(8, 2, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 1));
    	tableroPrueba.setEstadoCasilla(8, 2, 0);
    	
    	//COMPROBACION FILA SUPERIOR
    	assertTrue(tableroPrueba.compruebaAislada(0, 1));
    	tableroPrueba.setEstadoCasilla(0, 2, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 1));
    	tableroPrueba.setEstadoCasilla(0, 2, 0);
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 1));
    	tableroPrueba.setEstadoCasilla(0, 0, 0);
    	tableroPrueba.setEstadoCasilla(1, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 1));
    	tableroPrueba.setEstadoCasilla(1, 1, 0);
    	tableroPrueba.setEstadoCasilla(1, 0, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 1));
    	tableroPrueba.setEstadoCasilla(1, 0, 0);
    	tableroPrueba.setEstadoCasilla(1, 2, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 1));
    	tableroPrueba.setEstadoCasilla(1, 2, 0);
    	
    	//COMPROBACION COLUMNA IZQUIERDA
    	assertTrue(tableroPrueba.compruebaAislada(1, 0));
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	assertFalse(tableroPrueba.compruebaAislada(1, 0));
    	tableroPrueba.setEstadoCasilla(0, 0, 0);
    	tableroPrueba.setEstadoCasilla(2, 0, 1);
    	assertFalse(tableroPrueba.compruebaAislada(1, 0));
    	tableroPrueba.setEstadoCasilla(2, 0, 0);
    	tableroPrueba.setEstadoCasilla(1, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(1, 0));
    	tableroPrueba.setEstadoCasilla(1, 1, 0);
    	tableroPrueba.setEstadoCasilla(0, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(1, 0));
    	tableroPrueba.setEstadoCasilla(0, 1, 0);
    	tableroPrueba.setEstadoCasilla(2, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(1, 0));
    	tableroPrueba.setEstadoCasilla(2, 1, 0);
    	
    	//COMPROBACION COLUMNA DERECHA
    	assertTrue(tableroPrueba.compruebaAislada(1, 9));
    	tableroPrueba.setEstadoCasilla(0, 9, 1);
    	assertFalse(tableroPrueba.compruebaAislada(1, 9));
    	tableroPrueba.setEstadoCasilla(0, 9, 0);
    	tableroPrueba.setEstadoCasilla(2, 9, 1);
    	assertFalse(tableroPrueba.compruebaAislada(1, 9));
    	tableroPrueba.setEstadoCasilla(2, 9, 0);
    	tableroPrueba.setEstadoCasilla(1, 8, 1);
    	assertFalse(tableroPrueba.compruebaAislada(1, 9));
    	tableroPrueba.setEstadoCasilla(1, 8, 0);
    	tableroPrueba.setEstadoCasilla(0, 8, 1);
    	assertFalse(tableroPrueba.compruebaAislada(1, 9));
    	tableroPrueba.setEstadoCasilla(0, 8, 0);
    	tableroPrueba.setEstadoCasilla(2, 8, 1);
    	assertFalse(tableroPrueba.compruebaAislada(1, 9));
    	tableroPrueba.setEstadoCasilla(2, 8, 0);
    	
    	
    }
    
    @Test //TEST CAJA BLANCA PARA CUBRIR
    public void testCompruebaAislada() {
    	//COMPROBACION CASILLA CENTRAL
    	assertTrue(tableroPrueba.compruebaAislada(5, 5));
    	tableroPrueba.setEstadoCasilla(4, 4, 1);
    	assertFalse(tableroPrueba.compruebaAislada(5, 5));
    	tableroPrueba.setEstadoCasilla(4, 4, 0);
    	tableroPrueba.setEstadoCasilla(4, 5, 1);
    	assertFalse(tableroPrueba.compruebaAislada(5, 5));
    	tableroPrueba.setEstadoCasilla(4, 5, 0);
    	tableroPrueba.setEstadoCasilla(4, 6, 1);
    	assertFalse(tableroPrueba.compruebaAislada(5, 5));
    	tableroPrueba.setEstadoCasilla(4, 6, 0);
    	tableroPrueba.setEstadoCasilla(5, 4, 1);
    	assertFalse(tableroPrueba.compruebaAislada(5, 5));
    	tableroPrueba.setEstadoCasilla(5, 4, 0);
    	tableroPrueba.setEstadoCasilla(5, 6, 1);
    	assertFalse(tableroPrueba.compruebaAislada(5, 5));
    	tableroPrueba.setEstadoCasilla(5, 6, 0);	
    	tableroPrueba.setEstadoCasilla(6, 4, 1);
    	assertFalse(tableroPrueba.compruebaAislada(5, 5));
    	tableroPrueba.setEstadoCasilla(6, 4, 0);
    	tableroPrueba.setEstadoCasilla(6, 5, 1);
    	assertFalse(tableroPrueba.compruebaAislada(5, 5));
    	tableroPrueba.setEstadoCasilla(6, 5, 0);
    	tableroPrueba.setEstadoCasilla(6, 6, 1);
    	assertFalse(tableroPrueba.compruebaAislada(5, 5));
    	tableroPrueba.setEstadoCasilla(6, 6, 0);
    }
  
    @Test
    public void testSetBarcos() {
    	
    	assertTrue(tableroPrueba.setBarcos(1,1,1, 1));
    	
    }
}