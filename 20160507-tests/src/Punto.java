
public class Punto {

	double x;
	double y;

	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double distanciaCon(Punto p) {
		return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
	}
	
	
	
}
