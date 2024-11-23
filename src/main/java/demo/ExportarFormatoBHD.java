package demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportarFormatoBHD {

    // Función que exporta todos los empleados en formato BHD
    public static void exportarEmpleados(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            String filePath = "/p3/Empleado_" + empleado.getNombre() + "_BHD.txt";

            try (FileWriter writer = new FileWriter(filePath)) {
                // Escribir los datos en el formato solicitado
                writer.write(empleado.getNombre() + ";" +
                        empleado.getCuenta() + ";" +
                        empleado.getReferencia() + ";" +
                        String.format("%.2f", empleado.getMontoPago()) + ";" +
                        empleado.getConcepto() + "\n");

                System.out.println("Empleado " + empleado.getNombre() + " exportado exitosamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
