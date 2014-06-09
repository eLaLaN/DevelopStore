package mx.com.develop.store.model;

public enum Color {

    ROJO("Rojo"), AZUL("Azul"), VERDE("Verde"), MORADO("Morado"), NARANJA("Naranja"), CAFE("Café"), NEGRO("Negro"), AMARILLO("Amarillo"), VIOLETA("Violeta"), BLANCO("Blanco");

    private String titulo;

    private Color(String color) {
        this.titulo = color;
    }

    public String getTitulo() {
        return titulo;
    }
}
