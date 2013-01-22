import java.net.*;
import java.io.*;

public class Client {

   public static void main(String[] args) {
       int serverPort; 
	   serverPort = Integer.parseInt(args[1]);
       try {
	       InetAddress ipAddress = InetAddress.getByName(args[0]);   //объект, который отображает IP-адрес
           Socket socket = new Socket(ipAddress, serverPort);        //создаем сокет используя IP-адрес и порт сервера
           InputStream sin = socket.getInputStream();
           OutputStream sout = socket.getOutputStream();

           //Конвертируем потоки в другой тип
           DataInputStream in = new DataInputStream(sin);
           DataOutputStream out = new DataOutputStream(sout);
           String line = null;
           line = in.readUTF(); 
           System.out.println("The server sent me this : " + line);
           System.out.println();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}