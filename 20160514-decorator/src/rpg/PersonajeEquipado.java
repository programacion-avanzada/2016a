package rpg;

public abstract class PersonajeEquipado implements Personaje {

	private Personaje personaje;

	public PersonajeEquipado(Personaje personaje) {
		this.personaje = personaje;
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return this.personaje.obtenerPuntosDeAtaque();
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return this.personaje.obtenerPuntosDeDefensa();
	}
}
