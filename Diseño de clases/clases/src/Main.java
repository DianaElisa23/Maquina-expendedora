import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maquina maquina = new Maquina();
        maquina.agregarBillete(new Billete(1, "Camión", 10));
        maquina.agregarBillete(new Billete(2, "Metro", 15));
        maquina.agregarBillete(new Billete(3, "Turístico", 50));

        int opcion;
        do {
            System.out.println("1. Mostrar billetes disponibles");
            System.out.println("2. Seleccionar billete");
            System.out.println("3. Insertar dinero");
            System.out.println("4. Expender billete");
            System.out.println("5. Devolver dinero");
            System.out.println("6. Mantenimiento");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Billetes disponibles:");
                    for (Billete b : maquina.getBilletes()) {
                        System.out.println("Tipo " + b.getTipo() + " " + b.getNombre() + " con un costo de $ " + b.getPrecio());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el tipo de billete que desea: ");
                    int tipoSeleccionado = scanner.nextInt();
                    maquina.seleccionarBillete(tipoSeleccionado);
                    break;

                case 3:
                    System.out.print("Ingrese la cantidad de dinero a insertar: ");
                    int cantidad = scanner.nextInt();
                    maquina.insertarDinero(cantidad);
                    break;

                case 4:
                    System.out.print("Ingrese el tipo de billete que desea: ");
                    int tipoExpender = scanner.nextInt();
                    maquina.expenderBillete(tipoExpender);
                    break;

                case 5:
                    maquina.devolverDinero();
                    break;

                case 6:
                    maquina.mantenimiento();
                    break;

                case 7:
                    System.out.println("Vuelva prontooo :)");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opcion != 7);
    }
}
