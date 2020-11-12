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
        tableroPrueba.setEstadoCasilla(1, 1, 0);
        assertEquals(tableroPrueba.getEstadoCasilla(1,1), 0);
    }
    @Test
    public void testSetBarcosAleatorios() {
    	tableroPrueba.setBarcosAleatorios();
    	
    }
    
    

}