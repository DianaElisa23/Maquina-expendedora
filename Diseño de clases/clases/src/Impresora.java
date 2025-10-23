public class Impresora {
    private int nivelTinta;
    private int billetesDisponibles;

    public Impresora(int nivelTinta, int billetesDisponibles) {
        this.nivelTinta = nivelTinta;
        this.billetesDisponibles = billetesDisponibles;
    }

    public boolean tieneTinta() {
        return nivelTinta > 0;
    }

    public boolean tieneBilletes(int tipo) {
        return billetesDisponibles > 0;
    }

    public void imprimirYExpulsarBillete(int tipo) {
        if (tieneTinta() && tieneBilletes(tipo)) {
            billetesDisponibles--;
            nivelTinta--;
            System.out.println("Imprimiendo y expulsando billete tipo " + tipo + "...");
        } else {
            System.out.println("No hay tinta o billetes disponibles.");
        }
    }

    public void recargarTinta(int cantidad) {
        nivelTinta += cantidad;
        System.out.println("Tinta recargada.");
    }

    public void recargarBilletes(int cantidad) {
        billetesDisponibles += cantidad;
        System.out.println("Billetes recargados.");
    }
}


