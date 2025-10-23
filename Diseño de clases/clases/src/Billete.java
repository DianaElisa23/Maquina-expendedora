public class Billete {
    private int tipo;
    private String nombre;
    private int precio;

    public Billete(int tipo, String nombre, int precio) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }
}
