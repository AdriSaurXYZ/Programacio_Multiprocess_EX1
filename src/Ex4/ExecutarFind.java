package Ex4;

import java.io.*;

public class ExecutarFind {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java ExecutarFind <nombre_archivo> <texto_a_buscar>");
            return;
        }

        String nombreArchivo = args[0];

        File outputFile = new File(nombreArchivo);

        if (!outputFile.exists()) {
            System.out.println("El archivo " + nombreArchivo + " no existe.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            String searchText = args[1];
            if (content.toString().toLowerCase().contains(searchText.toLowerCase())) {
                System.out.println("Texto encontrado en " + nombreArchivo);
            } else {
                System.out.println("Texto no encontrado en " + nombreArchivo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}