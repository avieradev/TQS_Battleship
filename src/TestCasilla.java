import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCasilla {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreacion() {
        Casilla casellaPrueba = new Casilla();
        assertEquals(casellaPrueba.getEstado(),0);
    }

    @Test
    public void testSetEstado() {
        Casilla casellaPrueba = new Casilla();
        casellaPrueba.setEstado(1);
        assertEquals(casellaPrueba.getEstado(),1);
    }

    @Test
    public void testGetRevelada() {
        Casilla casellaPrueba = new Casilla();
        assertTrue(casellaPrueba.getRevelada());
    }
    @Test
    public void testSetRevelada() {
        Casilla casellaPrueba = new Casilla();
        casellaPrueba.setRevelada();
        assertTrue(casellaPrueba.getRevelada());
    }

}