package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banco {
    private String nombre;
    private List<Empleado> empleados;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public double calcularSalarioAjustado(double salarioBase) {
        Random random = new Random();
        // Generar un porcentaje aleatorio entre 5%  y 20%
        double porcentajeIncremento = 0.05 + (0.20 - 0.05) * random.nextDouble();
        double salarioAjustado = salarioBase * (1 + porcentajeIncremento);
        return salarioAjustado;
    }

    public void listarEmpleados() {
        System.out.println("Empleados en el banco " + nombre + ":");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
}