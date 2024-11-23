package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Empleado> empleados = new ArrayList<>();
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú principal:");
            System.out.println("1. Asignar nuevo empleado");
            System.out.println("2. Exportar empleados en formato BHD");
            System.out.println("3. Exportar empleados en formato Banco Popular");
            System.out.println("4. Exportar empleados en formato BanReservas");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el nombre del empleado:");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();

                    System.out.println("Introduce la cuenta remitente:");
                    String cuentaRemitente = scanner.nextLine();

                    System.out.println("Introduce la moneda (DOP, USD, etc.):");
                    String moneda = scanner.nextLine();

                    System.out.println("Introduce la cuenta destino:");
                    String cuenta = scanner.nextLine();

                    System.out.println("Introduce la referencia:");
                    String referencia = scanner.nextLine();

                    System.out.println("Introduce el monto del pago:");
                    double montoPago = scanner.nextDouble();

                    System.out.println("Introduce el concepto:");
                    scanner.nextLine();
                    String concepto = scanner.nextLine();

                    Empleado nuevoEmpleado = new Empleado(nombre, cuentaRemitente, cuenta, referencia, montoPago, concepto, moneda);
                    empleados.add(nuevoEmpleado);
                    System.out.println("Empleado agregado exitosamente.");
                    break;

                case 2:
                    System.out.println("Empleados a exportar:");
                    for (int i = 0; i < empleados.size(); i++) {
                        System.out.println((i + 1) + ". " + empleados.get(i).getNombre());
                    }

                    System.out.println("¿Deseas continuar exportando? (1 = Continuar, 2 = Salir)");
                    int decisionBHD = scanner.nextInt();

                    if (decisionBHD == 1) {
                        ExportarFormatoBHD.exportarEmpleados(empleados);
                    } else {
                        System.out.println("Saliendo...");
                        salir=true;
                    }
                    break;

                case 3:
                    System.out.println("Empleados a exportar:");
                    for (int i = 0; i < empleados.size(); i++) {
                        System.out.println((i + 1) + ". " + empleados.get(i).getNombre());
                    }

                    System.out.println("¿Deseas continuar exportando? (1 = Continuar, 2 = Salir)");
                    int decisionPopular = scanner.nextInt();

                    if (decisionPopular == 1) {
                        ExportarBancoPopular.exportarBancoPopular(empleados);
                    } else {
                        System.out.println("Saliendo...");
                        salir=true;
                    }
                    break;

                case 4:
                    System.out.println("Empleados a exportar:");
                    for (int i = 0; i < empleados.size(); i++) {
                        System.out.println((i + 1) + ". " + empleados.get(i).getNombre());
                    }

                    System.out.println("¿Deseas continuar exportando? (1 = Continuar, 2 = Salir)");
                    int decisionBanReservas = scanner.nextInt();

                    if (decisionBanReservas == 1) {
                        ExportarBanReservas.exportarBanReservas(empleados);
                    } else {
                        System.out.println("Saliendo...");
                        salir=true;
                    }
                    break;

                case 5:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }

        scanner.close();
    }
}
