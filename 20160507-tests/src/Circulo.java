
public class Circulo {

	Punto centro;
	double radio;

	public Circulo(Punto centro, double radio) {
		super();
		this.centro = centro;
		this.radio = radio;
	}
	
	public boolean contiene(Punto p) {
		return centro.distanciaCon(p) <= radio;
	}
	
	public Punto getCentro() {
		return centro;
	}
	public void setCentro(Punto centro) {
		this.centro = centro;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	
	
}
