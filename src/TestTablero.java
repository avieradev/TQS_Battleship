import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTablero {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreacionTablero() {
        Tablero tableroPrueba = new Tablero();
        tableroPrueba.setEstadoCasilla(1, 1, 0);
        assertEquals(tableroPrueba.getEstadoCasilla(1,1), 0);
    }

}