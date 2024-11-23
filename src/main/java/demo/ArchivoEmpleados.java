package demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ArchivoEmpleados {
    private static final String FILE_PATH = "/p3/Empleados.json";

    public static void guardarEmpleados(List<Banco> bancos) {
        Gson gson = new Gson();
        File archivo = new File(FILE_PATH);

        if (!archivo.exists()) {
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado: " + FILE_PATH);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(bancos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Banco> leerEmpleados() {
        Gson gson = new Gson();
        File archivo = new File(FILE_PATH);

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(archivo)) {
            Type bancoListType = new TypeToken<List<Banco>>() {}.getType();
            List<Banco> bancos = gson.fromJson(reader, bancoListType);

            return bancos != null ? bancos : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}