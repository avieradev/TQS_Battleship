import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTablero {
	Tablero tableroPrueba = new Tablero(4);
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
    	tableroPrueba.setEstadoCasilla(3, 1, 1);
    	tableroPrueba.setEstadoCasilla(3, 2, 1);
    	tableroPrueba.setEstadoCasilla(3, 3, 1);
    	assertFalse(tableroPrueba.compruebaHundida(3, 3));
    	tableroPrueba.setEstadoCasilla(3, 1, 1);
    	tableroPrueba.setEstadoCasilla(3, 2, 1);
    	tableroPrueba.setEstadoCasilla(3, 3, 1);
    	tableroPrueba.setCasillaRevelada(3, 2);
    	assertFalse(tableroPrueba.compruebaHundida(3, 3));
    	tableroPrueba.setEstadoCasilla(3, 1, 1);
    	tableroPrueba.setEstadoCasilla(3, 2, 1);
    	tableroPrueba.setEstadoCasilla(3, 3, 1);
    	tableroPrueba.setCasillaRevelada(3, 2);
    	tableroPrueba.setCasillaRevelada(3, 1);
    	assertTrue(tableroPrueba.compruebaHundida(3, 3));
    	tableroPrueba
    	
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

}