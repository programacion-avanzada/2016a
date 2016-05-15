package rpg;

public class ConGemaGemosa extends PersonajeEquipado {

	public ConGemaGemosa(Personaje personaje) {
		super(personaje);
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() * 2;
	}
}
