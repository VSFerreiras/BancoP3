package demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportarBancoPopular {

    public static void exportarBancoPopular(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            exportarEmpleadoPopular(empleado);
        }
        System.out.println("Exportación de Banco Popular completada.");
    }

    private static void exportarEmpleadoPopular(Empleado empleado) {
        try {
            // Nombre del archivo basado en el nombre del empleado
            String fileName = "/p3/Empleado_" + empleado.getNombre() + "_popular.txt";
            FileWriter writer = new FileWriter(fileName);

            // Generación del formato de archivo para Banco Popular
            StringBuilder formatoPopular = new StringBuilder();

            // Campos del formato
            formatoPopular.append("N;"); // TipoRegistro
            formatoPopular.append("IDCompañia123;"); // ID de Compañía
            formatoPopular.append("001;"); // Secuencia
            formatoPopular.append(empleado.getCuenta() + ";"); // Cuenta del Empleado
            formatoPopular.append("1;"); // TipoCuentaDestino (1 para Cuenta Corriente)
            formatoPopular.append("840;"); // Moneda (840 para Dólares)
            formatoPopular.append("10010100;"); // CodigoBancoDestino (Banco Popular)
            formatoPopular.append("1;"); // TipoServicio
            formatoPopular.append("123456;"); // Código Operación
            formatoPopular.append(empleado.getMontoPago() + ";"); // Monto de la Transacción
            formatoPopular.append("0;"); // Tipo de Identificación (0 = Ninguna)
            formatoPopular.append(empleado.getReferencia() + ";"); // Número de Referencia
            formatoPopular.append(empleado.getNombre() + ";"); // Nombre del Beneficiario
            formatoPopular.append("Pago de Nómina;"); // Concepto
            formatoPopular.append("20240101;"); // Fecha de vencimiento (YYYYMMDD)
            formatoPopular.append("1;"); // Forma de Contacto (1 para Email)

            writer.write(formatoPopular.toString());
            writer.close();
            System.out.println("Archivo exportado: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
