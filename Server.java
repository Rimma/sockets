import java.net.*;
import java.io.*;

public class Server {
   public static void main(String[] args) {
       int port = 6666;
       try {
           ServerSocket ss = new ServerSocket(port); 
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