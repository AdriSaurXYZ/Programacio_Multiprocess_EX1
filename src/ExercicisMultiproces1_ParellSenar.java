import java.util.Scanner;

public class ExercicisMultiproces1_ParellSenar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introdueix un nombre enter positiu: ");
            int num = scanner.nextInt();

            if (num < 0) {
                System.out.println("Si us plau, introdueix un nombre enter positiu.");
            } else {
                if (num % 2 == 0) {
                    System.out.println("Parell");
                } else {
                    System.out.println("Senar");
                }
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Si us plau, introdueix un nombre enter positiu vàlid.");
        }
    }
}