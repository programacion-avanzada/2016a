package rpg;

public class ConEscudoDeFelpudo extends PersonajeEquipado {

	public ConEscudoDeFelpudo(Personaje personaje) {
		super(personaje);
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() + 10;
	}
}
