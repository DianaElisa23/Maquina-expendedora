import java.util.ArrayList;

public class Maquina {
    private ArrayList<Billete> billetes;
    private Impresora impresora;
    private Monedero monedero;
    private int montoInsertado;

    public Maquina() {
        billetes = new ArrayList<>();
        impresora = new Impresora(50, 30);
        monedero = new Monedero(100); 
        montoInsertado = 0;
    }

    public void agregarBillete(Billete billete) {
        billetes.add(billete);
    }

    public void seleccionarBillete(int tipo) {
        Billete billete = buscarBillete(tipo);
        if (billete != null) {
            System.out.println("Billete " + billete.getNombre() + " cuesta: $" + billete.getPrecio());
        } else {
            System.out.println("Tipo de billete no disponible.");
        }
    }

    public void insertarDinero(int cantidad) {
        montoInsertado += cantidad;
        monedero.introducirDinero(cantidad);
        System.out.println("Dinero insertado: $" + cantidad);
    }

    public void expenderBillete(int tipo) {
        Billete billete = buscarBillete(tipo);
        if (billete == null) {
            System.out.println("Tipo de billete no encontrado.");
            return;
        }

        if (montoInsertado >= billete.getPrecio()) {
            if (impresora.tieneTinta() && impresora.tieneBilletes(tipo)) {
                impresora.imprimirYExpulsarBillete(tipo);
                int cambio = montoInsertado - billete.getPrecio();
                if (cambio > 0) {
                    monedero.suministrar(cambio);
                }
                montoInsertado = 0;
                System.out.println("Billete expedido con éxito.");
            } else {
                System.out.println("No se puede imprimir el billete");
            }
        } else {
            System.out.println("Pago insuficiente");
        }
    }

    public void devolverDinero() {
        monedero.devolverCantidadIntroducida();
        montoInsertado = 0;
    }

    public void mantenimiento() {
        System.out.println("Modo de mantenimiento");
        impresora.recargarTinta(20);
        impresora.recargarBilletes(10);
    }

    private Billete buscarBillete(int tipo) {
        for (Billete b : billetes) {
            if (b.getTipo() == tipo) {
                return b;
            }
        }
        return null;
    }
    public ArrayList<Billete> getBilletes() {
        return billetes;
    }
}
