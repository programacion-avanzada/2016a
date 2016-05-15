
public class App {

	public static void main(String[] args) {
		
		Punto centro = new Punto(1, 1);
		Circulo c = new Circulo(centro, 3);
		
		Punto p1 = new Punto(2, 2);
		
		System.out.println(c.contiene(p1));
		
		Punto p2 = new Punto(10, 10);
		System.out.println(c.contiene(p2));
		
	}
	
}
