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

	@Test
	public void testEstadoBarco() {
		Barco barcoPrueba = new Barco(3);
		assertEquals(barcoPrueba.getEstadoParte(0), 0);
	}

}
