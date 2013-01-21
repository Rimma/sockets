import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        int port = 6666;
        try {
            ServerSocket ss = new ServerSocket(port); 
            System.out.println("Waiting for a client...");
            Socket socket = ss.accept(); 
            System.out.println("Got a client");  //клиент связался из сервером
            System.out.println();

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту. 
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            String line = null;
            while(true) {
               line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
               System.out.println("The dumb client just sent me this line : " + line);
               System.out.println("I'm sending it back...");
               out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
               out.flush(); // заставляем поток закончить передачу данных.
               System.out.println("Waiting for the next line...");
               System.out.println();
            }
        } catch(Exception e) { 
		       e.printStackTrace(); 
		}
    }
}