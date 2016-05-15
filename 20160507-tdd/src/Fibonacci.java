
public class Fibonacci {

	public static int de(int i) {
		if (i == 0) throw new RuntimeException("Eh, gato!");
		if (i >= 3) return de(i - 1) + de(i - 2);
		return 1;
	}

}
