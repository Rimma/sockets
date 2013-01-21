import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) {
        int serverPort = 6666; 			//порт к которому привязывается сервер
        String address = "127.0.0.1";   //IP-адрес компьютера

        try {
		    InetAddress ipAddress = InetAddress.getByName(address);   //объект, который отображает IP-адрес
            Socket socket = new Socket(ipAddress, serverPort);        // создаем сокет используя IP-адрес и порт сервера
            System.out.println("Yes! I just got hold of the program.");
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            while (true) {
                line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
                System.out.println("Sending this line to the server...");
                out.writeUTF(line); // отсылаем введенную строку текста серверу.
                out.flush(); // заставляем поток закончить передачу данных.
                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println("The server was very polite. It sent me this : " + line);
                System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
                System.out.println();
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}