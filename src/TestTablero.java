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
    @Test
    public void testGenerarRandom() {
    	assertEquals(tableroPrueba.generarRandom(1), 1);
    }
    
    @Test
    public void compruebaCasilla() {
    	assertEquals(tableroPrueba.getEstadoCasilla(0, 0), 0);
    }

}