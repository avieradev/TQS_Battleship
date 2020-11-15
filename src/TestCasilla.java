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

    @Test //DE CAJA NEGRA, MIRA OUTPUT
    public void testCreacion() {
        Casilla casellaPrueba = new Casilla();
        assertEquals(casellaPrueba.getEstado(),0);
    }

    @Test //DE CAJA NEGRA, MIRA OUTPUT
    public void testSetEstado() {
        Casilla casellaPrueba = new Casilla();
        casellaPrueba.setEstado(1);
        assertEquals(casellaPrueba.getEstado(),1);
    }

    @Test //DE CAJA NEGRA, MIRA OUTPUT
    public void testGetRevelada() {
        Casilla casellaPrueba = new Casilla();
        assertFalse(casellaPrueba.getRevelada());
    }
    @Test //DE CAJA NEGRA, MIRA OUTPUT
    public void testSetRevelada() {
        Casilla casellaPrueba = new Casilla();
        casellaPrueba.setRevelada();
        assertTrue(casellaPrueba.getRevelada());
    }
    
    @Test //DE CAJA NEGRA, MIRA OUTPUT
    public void testSetVisitada() {
        Casilla casellaPrueba = new Casilla();
        assertFalse(casellaPrueba.getVisitada());
        casellaPrueba.setVisitada();
        assertTrue(casellaPrueba.getVisitada());
    }
    
    @Test //DE CAJA NEGRA, MIRA OUTPUT
    public void testResetCasilla() {
    	Casilla casellaPrueba = new Casilla();
    	casellaPrueba.setVisitada();
    	casellaPrueba.reset();
    	assertFalse(casellaPrueba.getVisitada());
    }

}