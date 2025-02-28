import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

            String respuestaDelServidor;

            while ((respuestaDelServidor = br1.readLine()) != null) {
                System.out.println(respuestaDelServidor);
                if (respuestaDelServidor.contains("Tu turno")) {
                    String palabraDelUsuario = br2.readLine();
                    pw.println(palabraDelUsuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR: Cliente");
        }
    }
}