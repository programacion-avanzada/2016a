import org.junit.Assert;
import org.junit.Test;

public class GeometriaTests {

	
	@Test
	public void queUnCirculoContieneUnPunto() {
		
		Punto centro = new Punto(1, 1);
		Circulo c = new Circulo(centro, 3);
		
		Punto p1 = new Punto(2, 2);
		
		Assert.assertTrue(c.contiene(p1));
	}
	
	@Test
	public void queUnCirculoNoContieneUnPunto() {
		
		Punto centro = new Punto(1, 1);
		Circulo c = new Circulo(centro, 3);
		
		Punto p1 = new Punto(20, 20);
		
		Assert.assertFalse(c.contiene(p1));
	}
	
	
	@Test
	public void queLaDistanciaEntreDosPuntosEnXEsCorrecta() {
		Punto p1 = new Punto(1, 1);
		Punto p2 = new Punto(5, 1);
		
		Assert.assertEquals(4.0, p1.distanciaCon(p2), 0);
	}
	
	@Test
	public void queLaDistanciaEntreDosPuntosEnYEsCorrecta() {
		Punto p1 = new Punto(1, 1);
		Punto p2 = new Punto(1, 5);
		
		Assert.assertEquals(4.0, p1.distanciaCon(p2), 0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
