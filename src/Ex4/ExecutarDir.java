package Ex4;

import java.io.*;

public class ExecutarDir {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Falta el nombre del archivo.");
            return;
        }

        String nomFitxer = args[0];

        try {
            // Crear el archivo con el nombre proporcionado
            File fitxer = new File(nomFitxer);
            if (fitxer.createNewFile()) {
                System.out.println("Archivo creado: " + nomFitxer);
            } else {
                System.out.println("El archivo ya existe. Sobrescribiendo...");
            }

            // Ejecutar la comanda dir y almacenar el resultado en el archivo
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "dir");
            processBuilder.directory(new File(System.getProperty("user.home") + "\\Desktop"));
            processBuilder.redirectOutput(fitxer);
            Process process = processBuilder.start();
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
