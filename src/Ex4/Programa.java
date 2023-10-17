package Ex4;


import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre de archivo (por ejemplo, sortida.txt): ");
        String nomFitxer = scanner.nextLine();

        // Ejecutar ExecutarDir con el nombre de archivo introducido
        ExecutarDir.main(new String[]{nomFitxer});

        // Ejecutar ExecutarFind con el texto introducido por el usuario
        System.out.print("Introduce el texto a buscar en " + nomFitxer + ": ");
        String textCerca = scanner.nextLine();
        ExecutarFind.main(new String[]{nomFitxer, textCerca});
    }
}


