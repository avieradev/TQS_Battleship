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
        tableroPrueba.setEstadoCasilla(1, 1, 0);
        assertEquals(tableroPrueba.getEstadoCasilla(1,1), 0);
    }
    //@Test
    public void testSetBarcosAleatorios() {
    	tableroPrueba.setBarcosAleatorios();
    	
    }
    //@Test
    public void testGenerarRandom() {
    	assertEquals(tableroPrueba.generarRandom(1), 1);
    }
    
    @Test
    public void compruebaCasillaVacia() {
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 0), 0);
    }
    
    
    @Test
    public void compruebaAislada() {
    	tableroPrueba.setEstadoCasilla(0, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 0));
    	
    	tableroPrueba.setEstadoCasilla(8, 0, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 0));
    	
    	tableroPrueba.setEstadoCasilla(0, 8, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 9));
    	
    	tableroPrueba.setEstadoCasilla(8, 9, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 9));
    	
    	tableroPrueba.setEstadoCasilla(1, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(0, 1));
    	
    	tableroPrueba.setEstadoCasilla(8, 1, 1);
    	assertFalse(tableroPrueba.compruebaAislada(9, 1));
    	
    	tableroPrueba.setEstadoCasilla(3, 0, 1);
    	tableroPrueba.setEstadoCasilla(4, 1, 1);
    	tableroPrueba.setEstadoCasilla(5, 0, 1);
    	assertFalse(tableroPrueba.compruebaAislada(4, 0));
    	
    	tableroPrueba.setEstadoCasilla(3, 4, 1);
    	assertFalse(tableroPrueba.compruebaAislada(3, 5));
    
    }

}