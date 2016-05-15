import org.junit.Assert;
import org.junit.Test;

public class FibonacciTests {

	@Test
	public void queCalculaFibonacci() {
		Assert.assertEquals(1, Fibonacci.de(1));
		Assert.assertEquals(1, Fibonacci.de(2));
		Assert.assertEquals(2, Fibonacci.de(3));
		Assert.assertEquals(3, Fibonacci.de(4));
		Assert.assertEquals(5, Fibonacci.de(5));
		Assert.assertEquals(8, Fibonacci.de(6));
		
		Assert.assertEquals(13, Fibonacci.de(7));
		Assert.assertEquals(21, Fibonacci.de(8));
	}
	
	@Test(expected=RuntimeException.class)
	public void queNoCalculaFibonacciDeCero() {
		Fibonacci.de(0);
	}
}
