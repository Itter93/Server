import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Запуск сервера");
        int port = 8080;

        while (true) {
            ServerSocket serverSocket = new ServerSocket(port); 
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Создано новое соединение");

            final String message = in.readLine();

            out.println(String.format("Получено сообщение от клиента: \"%s\"; Порт соединения: %d", message, clientSocket.getPort()));
            serverSocket.close();
        }
    }
}
