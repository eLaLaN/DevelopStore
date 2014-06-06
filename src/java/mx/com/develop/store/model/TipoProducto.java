package mx.com.develop.store.model;

public enum TipoProducto {

	PLAYERA("Playera"), PANTALON("Pantalon"), BLUSA("Blusa"), CAMISA("Pantalón");

	private String titulo;

	private TipoProducto(String tipo) {
		this.titulo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}
}
