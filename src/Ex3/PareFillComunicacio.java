package Ex3;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

public class PareFillComunicacio {
    public static void main(String[] args) throws IOException {
        PipedOutputStream padreToHijo = new PipedOutputStream();
        PipedOutputStream hijoToPadre = new PipedOutputStream();
        PipedInputStream hijoInput = new PipedInputStream(padreToHijo);
        PipedInputStream padreInput = new PipedInputStream(hijoToPadre);

        // Creamos el proceso hijo
        HijoProceso hijo = new HijoProceso(hijoInput, hijoToPadre);
        hijo.start();

        PrintStream salidaPadre = new PrintStream(padreToHijo);

        // Comunicación entre el padre y el hijo
        salidaPadre.println("Salutacions del pare");

        byte[] buffer = new byte[100];
        int bytesLeidos = padreInput.read(buffer);
        String mensajeDesdeHijo = new String(buffer, 0, bytesLeidos);
        System.out.println("Pare: rep missatge del fill \"" + mensajeDesdeHijo + "\"");
    }
}