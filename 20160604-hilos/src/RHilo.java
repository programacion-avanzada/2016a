
public class RHilo implements Runnable {
	
	public void run() {
		for(int i = 0; i < 100; i++)
			System.out.println(i + " - " + Thread.currentThread().getName());
		System.out.println("Hilo finalizado");

	}

	public static void main(String[] args) {
		new Thread(new RHilo(), "Julio").start();
		new Thread(new RHilo(), "Lucas").start();
	}

}
