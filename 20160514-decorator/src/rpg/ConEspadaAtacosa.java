package rpg;

public class ConEspadaAtacosa extends PersonajeEquipado {

	public ConEspadaAtacosa(Personaje personaje) {
		super(personaje);
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 5;
	}
}
