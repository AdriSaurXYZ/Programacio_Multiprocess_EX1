package Ex3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class HijoProceso extends Thread {
    private InputStream entrada;
    private OutputStream salida;

    public HijoProceso(InputStream entrada, OutputStream salida) {
        this.entrada = entrada;
        this.salida = salida;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[100];

        try {
            int bytesLeidos = entrada.read(buffer);
            String mensajeDesdePadre = new String(buffer, 0, bytesLeidos);
            System.out.println("Fill: rep missatge del pare \"" + mensajeDesdePadre + "\"");

            PrintStream printStream = new PrintStream(salida);
            printStream.println("Salutacions de part del fill");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}