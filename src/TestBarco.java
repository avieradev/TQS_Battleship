import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBarco {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//@Test
	public void testEstadoParte() {
		Barco barcoPrueba = new Barco(3);
		assertEquals(barcoPrueba.getEstadoParte(0), 0);
	}
	@Test
	public void testTocarParte() {
		Barco barcoPrueba = new Barco(3);
		barcoPrueba.setTocadoParte(0);
		assertEquals(barcoPrueba.getEstadoParte(0), 1);
	}
}
