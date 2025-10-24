public class Monedero {
    private int saldoActual;
    private int cantidadIntroducida;

    public Monedero(int saldoInicial) {
        this.saldoActual = saldoInicial;
        this.cantidadIntroducida = 0;
    }

    public boolean esPosibleSuministrar(int cantidad) {
        return saldoActual >= cantidad;
    }

    public void suministrar(int cantidad) {
        if (esPosibleSuministrar(cantidad)) {
            saldoActual -= cantidad;
            System.out.println("Su cambio es de: " + cantidad);
        } else {
            System.out.println("No hay suficiente saldo");
        }
    }

    public int devolverCantidadIntroducida() {
        int devolver = cantidadIntroducida;
        cantidadIntroducida = 0;
        System.out.println("Devolviendo cantidad introducida: " + devolver);
        return devolver;
    }

    public int cantidadIntroducida() {
        return cantidadIntroducida;
    }

    public void introducirDinero(int cantidad) {
        cantidadIntroducida += cantidad;
        saldoActual += cantidad;
    }

    public int getSaldoActual() {
        return saldoActual;
    }
}
