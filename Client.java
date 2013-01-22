import java.net.*;
import java.io.*;

public class Client {

   public static void main(String[] args) {
       int serverPort; 
	   serverPort = Integer.parseInt(args[1]);
       try {
	       InetAddress ipAddress = InetAddress.getByName(args[0]);   //������, ������� ���������� IP-�����
           Socket socket = new Socket(ipAddress, serverPort);        //������� ����� ��������� IP-����� � ���� �������
           InputStream sin = socket.getInputStream();
           OutputStream sout = socket.getOutputStream();

           //������������ ������ � ������ ���
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