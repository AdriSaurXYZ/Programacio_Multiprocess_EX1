package Ex2;
import java.io.*;

public class ExercicisMultiproces2 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java", "src/Ex2/ExercicisMultiproces2_ModificarString.java");
        Process childProcess = pb.start();

        BufferedReader parentInput = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter parentOutput = new BufferedWriter(new OutputStreamWriter(childProcess.getOutputStream()));
        BufferedReader childInput = new BufferedReader(new InputStreamReader(childProcess.getInputStream()));

        String line;

        while (true) {
            System.out.print("El pare diu: ");
            line = parentInput.readLine();
            if (line == null || line.equals("exit")) {
                break;
            }
            parentOutput.write(line + "\n");
            parentOutput.flush();
            String modifiedLine = childInput.readLine();
            System.out.println(modifiedLine);
        }

        childProcess.destroy();
    }
}