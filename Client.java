import java.net.*;
import java.io.*;

public class Client {

   public static void main(String[] args) {
    //   int serverPort = 6666; 		   
       String address = "127.0.0.1"; 

       try {
	       InetAddress ipAddress = InetAddress.getByName(address);   //объект, который отображает IP-адрес
           Socket socket = new Socket(ipAddress, args[0]);        //создаем сокет используя IP-адрес и порт сервера
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