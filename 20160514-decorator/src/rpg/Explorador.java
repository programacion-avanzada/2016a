package rpg;

public class Explorador implements Personaje {

	@Override
	public int obtenerPuntosDeAtaque() {
		return 1;
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return 0;
	}
}
