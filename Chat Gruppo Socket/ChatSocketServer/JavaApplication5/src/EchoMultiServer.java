import java.io.*;
import java.net.*;

// ServerThread
public class EchoMultiServer {
    static final int PORT = 12345;
    static ListaThread Lista_c = new ListaThread();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("EchoMultiServer: started");
        try {
            while(true) {
                // bloccante finchè non avviene una connessione:
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection accepted: "+ clientSocket);
                try {
                    new ServerThread(clientSocket, Lista_c);
                    } catch(IOException e) {
                        clientSocket.close();
                }
            }
        }
        catch (IOException e) {
           System.err.println("Accept failed");
           System.exit(1);
        }
           System.out.println("EchoMultiServer: closing...");
           serverSocket.close();
    }
} // EchoMultiServer