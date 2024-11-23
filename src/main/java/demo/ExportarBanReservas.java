package demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportarBanReservas {

    public static void exportarBanReservas(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            exportarEmpleadoBanReservas(empleado);
        }
        System.out.println("Exportación de BanReservas completada.");
    }

    private static void exportarEmpleadoBanReservas(Empleado empleado) {
        try {
            String fileName = "/home/victor/Documents/" + empleado.getNombre().replace(" ", "_") + "_banreservas.txt";
            FileWriter writer = new FileWriter(fileName);

            String tipoCuentaDestino = determinarTipoCuenta(empleado.getCuenta());

            StringBuilder formatoBanReservas = new StringBuilder();
            formatoBanReservas.append(determinarTipoCuenta(empleado.getCuentaRemitente())).append(",")  // Tipo de cuenta remitente
                    .append(empleado.getMoneda()).append(",")  // Moneda remitente
                    .append(empleado.getCuentaRemitente()).append(",")  // Cuenta remitente
                    .append(tipoCuentaDestino).append(",")  // Tipo de cuenta destino
                    .append(empleado.getMoneda()).append(",")  // Moneda destino
                    .append(empleado.getCuenta()).append(",")  // Cuenta destino
                    .append(empleado.getMontoPago()).append(" ")  // Monto
                    .append(empleado.getConcepto().toUpperCase());  // Concepto

            writer.write(formatoBanReservas.toString());
            writer.close();
            System.out.println("Archivo exportado: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String determinarTipoCuenta(String cuenta) {
        if (cuenta.startsWith("4")) {
            return "CA";  // Cuenta de Ahorro
        } else {
            return "CC";  // Cuenta Corriente
        }
    }
}
