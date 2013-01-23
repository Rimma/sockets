import java.net.*;
import java.io.*;

public class Server {
   public static void main(String[] args) {
       int port;    //порт, к которому привязывается сервер
	   port = Integer.parseInt(args[0]);
       try {
           ServerSocket ss = 
		      new ServerSocket(port);   //сокет привязанній к порту
           System.out.println("Waiting for a client...");
           Socket socket = ss.accept(); 
           System.out.println("Got a client");  //клиент связался из сервером
           System.out.println();
           InputStream sin = socket.getInputStream();
           OutputStream sout = socket.getOutputStream();

           // Конвертируем потоки в другой тип
           DataInputStream in = new DataInputStream(sin);
           DataOutputStream out = new DataOutputStream(sout);
           String line = "Hello Client!";
           out.writeUTF(line);
           out.flush();  //заставляем поток закончить передачу данных
        } catch(Exception e) { 
		   e.printStackTrace(); 
		}
    }
}