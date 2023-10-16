package Ex2;
import java.io.*;

public class ExercicisMultiproces2_ModificarString {
    public static void main(String[] args) throws IOException {
        BufferedReader childInput = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter childOutput = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while (true) {
            System.out.print("El fill diu: ");
            line = childInput.readLine();
            if (line == null || line.equals("exit")) {
                break;
            }

            // Transformar a majúscules i substituir vocals per "_"
            line = line.toUpperCase().replaceAll("[AEIOUaeiou]", "_");
            childOutput.write(line + "\n");
            childOutput.flush();
        }
    }
}