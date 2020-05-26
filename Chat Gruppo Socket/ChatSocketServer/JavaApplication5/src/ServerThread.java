
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

class ServerThread extends Thread {
    private static int counter = 0;
    private int id = ++counter;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ListaThread lista;
    
    public ServerThread(Socket s, ListaThread l) throws IOException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        out = new PrintWriter(new BufferedWriter(osw), true);
        //aggiungo out al Vector dei thread
        lista = l;
        lista.lista.add(out);
        start();
        System.out.println("ServerThread "+id+": started");
    }
    public void run() {
        try {
            while (true) {
                String str = in.readLine();
                if (str.equals("/exit")) break;     //messaggio di uscita
                for(PrintWriter o: lista.lista)
                {
                    o.println(str);
                }
            }
            System.out.println("ServerThread "+id+": closing...");
        } catch (IOException e) {}
        try {
            socket.close();
        } catch(IOException e) {}
    }
} 