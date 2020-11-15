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
    
    @Test
    public void testCreacionTablero() {
        assertEquals(tableroPrueba.getEstadoCasilla(1,1), 0);
    }
    
    @Test
    public void testSetEstadoCasilla() {
    	tableroPrueba.setEstadoCasilla(1,1, 1);
    	assertEquals(tableroPrueba.getEstadoCasilla(1,1), 1);
    }
    @Test
    public void testGetBarcosVivos() {
    	assertEquals(tableroPrueba.getBarcosVivos(), 4);
    }
    @Test
    public void testGenerarRandom() {
    	assertEquals(tableroPrueba.generarRandom(1), 0);
    }
    
    @Test
    public void testCompruebaCasillaVacia() {
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 0), 0);
    }
    
    @Test
    public void testResetCasilla() {
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.resetCasilla(0, 0);
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 0), 0);
    }
    
    
    
    @Test
    public void testCompruebaHundida() {
    	//BARCO HORIZONTAL IZQUIERDA
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.setEstadoCasilla(0, 1, 1);
    	tableroPrueba.setEstadoCasilla(0, 2, 1);
    	assertFalse(tableroPrueba.compruebaHundida(0, 2));
    	tableroPrueba.setCasillaRevelada(0, 1);
    	assertFalse(tableroPrueba.compruebaHundida(0, 2));
    	tableroPrueba.setCasillaRevelada(0, 0);
    	assertTrue(tableroPrueba.compruebaHundida(0, 2));
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 0),2);
    	tableroPrueba.resetCasilla(0, 0);
    	tableroPrueba.resetCasilla(0, 1);
    	tableroPrueba.resetCasilla(0, 2);
    	
    	//BARCO HORIZONTAL DERECHA
    	tableroPrueba.setEstadoCasilla(9, 7, 1);
    	tableroPrueba.setEstadoCasilla(9, 8, 1);
    	tableroPrueba.setEstadoCasilla(9, 9, 1);
    	assertFalse(tableroPrueba.compruebaHundida(9, 7));
    	tableroPrueba.setCasillaRevelada(9, 8);
    	assertFalse(tableroPrueba.compruebaHundida(9, 7));
    	tableroPrueba.setCasillaRevelada(9, 9);
    	assertTrue(tableroPrueba.compruebaHundida(9, 7));
    	tableroPrueba.resetCasilla(9, 7);
    	tableroPrueba.resetCasilla(9, 8);
    	tableroPrueba.resetCasilla(9, 9);
    	
    	//BARCO VERTICAL ARRIBA
    	tableroPrueba.setEstadoCasilla(7, 9, 1);
    	tableroPrueba.setEstadoCasilla(8, 9, 1);
    	tableroPrueba.setEstadoCasilla(9, 9, 1);
    	assertFalse(tableroPrueba.compruebaHundida(9, 9));
    	tableroPrueba.setCasillaRevelada(8, 9);
    	assertFalse(tableroPrueba.compruebaHundida(9, 9));
    	tableroPrueba.setCasillaRevelada(7, 9);
    	assertTrue(tableroPrueba.compruebaHundida(9, 9));
    	tableroPrueba.resetCasilla(7, 9);
    	tableroPrueba.resetCasilla(8, 9);
    	tableroPrueba.resetCasilla(9, 9);
    	
    	//BARCO VERTICAL ARRIBA
    	tableroPrueba.setEstadoCasilla(7, 9, 1);
    	tableroPrueba.setEstadoCasilla(8, 9, 1);
    	tableroPrueba.setEstadoCasilla(9, 9, 1);
    	assertFalse(tableroPrueba.compruebaHundida(7, 9));
    	tableroPrueba.setCasillaRevelada(8, 9);
    	assertFalse(tableroPrueba.compruebaHundida(7, 9));
    	tableroPrueba.setCasillaRevelada(9, 9);
    	assertTrue(tableroPrueba.compruebaHundida(7, 9));
    	tableroPrueba.resetCasilla(7, 9);
    	tableroPrueba.resetCasilla(8, 9);
    	tableroPrueba.resetCasilla(9, 9);
    	
    	//BARCO HORIZONTAL IZQUIERDA
    	tableroPrueba.setEstadoCasilla(0, 0, 1);
    	tableroPrueba.setEstadoCasilla(0, 1, 1);
    	tableroPrueba.setEstadoCasilla(0, 2, 1);
    	assertFalse(tableroPrueba.compruebaHundida(0, 0));
    	tableroPrueba.setCasillaRevelada(0, 1);
    	assertFalse(tableroPrueba.compruebaHundida(0, 0));
    	tableroPrueba.setCasillaRevelada(0, 2);
    	assertTrue(tableroPrueba.compruebaHundida(0, 0));
    	tableroPrueba.resetCasilla(0, 0);
    	tableroPrueba.resetCasilla(0, 1);
    	tableroPrueba.resetCasilla(0, 2);
    	
 
    	
    }
    
    @Test
    public void testGetCasillaRevelada() {
    	tableroPrueba.setCasillaRevelada(0, 0);
    	assertTrue(tableroPrueba.getCasillaRevelada(0,0));
    	tableroPrueba.resetCasilla(0, 0);
    }
    @Test
    public void testRevelaZona() {
    	tableroPrueba.revelaZona(0,0);
    	assertTrue(tableroPrueba.getCasillaRevelada(0,0));
    	assertTrue(tableroPrueba.getCasillaRevelada(0,1));
    	assertTrue(tableroPrueba.getCasillaRevelada(1,0));
    	assertTrue(tableroPrueba.getCasillaRevelada(1,1));
    	
    	tableroPrueba.revelaZona(0,9);
    	assertTrue(tableroPrueba.getCasillaRevelada(0,9));
    	assertTrue(tableroPrueba.getCasillaRevelada(0,8));
    	assertTrue(tableroPrueba.getCasillaRevelada(1,0));
    	assertTrue(tableroPrueba.getCasillaRevelada(1,8));
    	
    	tableroPrueba.revelaZona(9,0);
    	assertTrue(tableroPrueba.getCasillaRevelada(9,0));
    	assertTrue(tableroPrueba.getCasillaRevelada(8,0));
    	assertTrue(tableroPrueba.getCasillaRevelada(9,1));
    	assertTrue(tableroPrueba.getCasillaRevelada(8,1));
    	
    	tableroPrueba.revelaZona(9,9);
    	assertTrue(tableroPrueba.getCasillaRevelada(9,9));
    	assertTrue(tableroPrueba.getCasillaRevelada(8,9));
    	assertTrue(tableroPrueba.getCasillaRevelada(9,8));
    	assertTrue(tableroPrueba.getCasillaRevelada(8,8));
    	
    	tableroPrueba.revelaZona(0,5);
    	assertTrue(tableroPrueba.getCasillaRevelada(0,4));
    	assertTrue(tableroPrueba.getCasillaRevelada(0,5));
    	assertTrue(tableroPrueba.getCasillaRevelada(0,6));
    	assertTrue(tableroPrueba.getCasillaRevelada(1,4));
    	assertTrue(tableroPrueba.getCasillaRevelada(1,5));
    	assertTrue(tableroPrueba.getCasillaRevelada(1,6));
    	
    	tableroPrueba.revelaZona(9,5);
    	assertTrue(tableroPrueba.getCasillaRevelada(9,4));
    	assertTrue(tableroPrueba.getCasillaRevelada(9,5));
    	assertTrue(tableroPrueba.getCasillaRevelada(9,6));
    	assertTrue(tableroPrueba.getCasillaRevelada(8,4));
    	assertTrue(tableroPrueba.getCasillaRevelada(8,5));
    	assertTrue(tableroPrueba.getCasillaRevelada(8,6));
    	
    	tableroPrueba.revelaZona(5,0);
    	assertTrue(tableroPrueba.getCasillaRevelada(4,0));
    	assertTrue(tableroPrueba.getCasillaRevelada(5,0));
    	assertTrue(tableroPrueba.getCasillaRevelada(6,0));
    	assertTrue(tableroPrueba.getCasillaRevelada(4,1));
    	assertTrue(tableroPrueba.getCasillaRevelada(5,1));
    	assertTrue(tableroPrueba.getCasillaRevelada(6,1));
    	
    	tableroPrueba.revelaZona(5,9);
    	assertTrue(tableroPrueba.getCasillaRevelada(4,9));
    	assertTrue(tableroPrueba.getCasillaRevelada(5,9));
    	assertTrue(tableroPrueba.getCasillaRevelada(6,9));
    	assertTrue(tableroPrueba.getCasillaRevelada(4,8));
    	assertTrue(tableroPrueba.getCasillaRevelada(5,8));
    	assertTrue(tableroPrueba.getCasillaRevelada(6,8));
    	
    	tableroPrueba.revelaZona(5,5);
    	assertTrue(tableroPrueba.getCasillaRevelada(4,4));
    	assertTrue(tableroPrueba.getCasillaRevelada(4,5));
    	assertTrue(tableroPrueba.getCasillaRevelada(4,6));
    	assertTrue(tableroPrueba.getCasillaRevelada(5,4));
    	assertTrue(tableroPrueba.getCasillaRevelada(5,5));
    	assertTrue(tableroPrueba.getCasillaRevelada(5,6));
    	assertTrue(tableroPrueba.getCasillaRevelada(6,4));
    	assertTrue(tableroPrueba.getCasillaRevelada(6,5));
    	assertTrue(tableroPrueba.getCasillaRevelada(6,6));
    	
    }
    
    @Test
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
    	
    	//CORRECTA
    	assertTrue(tableroPrueba.compruebaPosicionValida(5, 5));
    }
    
    @Test
    public void testCompruebaAislada() {
	
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
    
    //@Test
    public void testSetBarcosAleatorios() {
    	
    }
    @Test
    public void testSetBarcos() {
    	
    	assertTrue(tableroPrueba.setBarcos(1,1,1, 1));
    	
    }
}