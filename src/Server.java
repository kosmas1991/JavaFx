import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket socket;
        for (int count = 1; count < 100; count++) {
            socket = server.accept();
            System.out.println("Client " + count + " connected!!");
        }
    }
}
