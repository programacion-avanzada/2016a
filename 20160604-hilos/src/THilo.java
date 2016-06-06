
public class THilo extends Thread {
	
	THilo(String nombreHilo) {
		super(nombreHilo);
	}
	
	public void run() {
		for(int i = 0; i < 100; i++) 
			System.out.println(i + " - " + getName());
		System.out.println("Hilo finalizado");
	}

	public static void main(String[] args) {

		new THilo("Julio").start();
		new THilo("Lucas").start();

	}

}
