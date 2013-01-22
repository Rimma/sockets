import java.net.*;
import java.io.*;

public class Server {
   public static void main(String[] args) {
      // int port = args[0];
       try {
           ServerSocket ss = new ServerSocket(args[0]); 
           System.out.println("Waiting for a client...");
           Socket socket = ss.accept(); 
           System.out.println("Got a client");  //������ �������� �� ��������
           System.out.println();

           // ����� ������� � �������� ������ ������, ������ ����� �������� � �������� ������ �������. 
           InputStream sin = socket.getInputStream();
           OutputStream sout = socket.getOutputStream();

           // ������������ ������ � ������ ���
           DataInputStream in = new DataInputStream(sin);
           DataOutputStream out = new DataOutputStream(sout);
           String line = "Hello Client!";
           out.writeUTF(line); // �������� ������� ������� �� ����� ������ ������.
           out.flush(); // ���������� ����� ��������� �������� ������.
        } catch(Exception e) { 
		   e.printStackTrace(); 
		}
    }
}
