import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.File;


public class SimpleFileClient {

  public final static int SOCKET_PORT = 1234;      
  public final static String SERVER = "localhost"; 
  public static String
       FILE_TO_RECEIVED = "D:/Ngampus/Semester 5/DownlaodedText.txt";  //Direktori penyimpanan

  public static int FILE_SIZE = 2048; // Dengan asumsi file size tidak melebihi sekian bytes

  public static void main (String [] args ) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
      int bytesRead;
      int current = 0;
      FileOutputStream fos = null;
      BufferedOutputStream bos = null;
      Socket sock = null;
      ObjectOutputStream oos = null;
      ObjectInputStream ois = null;
      String option;
      Scanner sc = new Scanner(System.in);
      //establish socket connection to server
      sock = new Socket("localhost", 1234);
      //write to socket using ObjectOutputStream
      oos = new ObjectOutputStream(sock.getOutputStream());
      System.out.println("Sending request to Socket Server");
      ois = new ObjectInputStream(sock.getInputStream());

      String message = (String) ois.readObject();
      System.out.println("Message: " + message);
      option = sc.nextLine();
      System.out.println("Sending to Message : " + option);
      oos.writeObject(option);
      System.out.println("mark");
    try {
      
      // receive file
      byte [] mybytearray  = new byte [FILE_SIZE];
      InputStream is = sock.getInputStream();
      fos = new FileOutputStream(FILE_TO_RECEIVED);
      bos = new BufferedOutputStream(fos);
      bytesRead = is.read(mybytearray,0,mybytearray.length);
      current = bytesRead;

      do {
         bytesRead =
            is.read(mybytearray, current, (mybytearray.length-current));
         if(bytesRead >= 0) current += bytesRead;
      } while(bytesRead > -1);

      bos.write(mybytearray, 0 , current);
      bos.flush();
      System.out.println("File " + FILE_TO_RECEIVED + " downloaded (" + current + " bytes read)");
      
      ois.close();
      oos.close();
    }
    finally {
      if (fos != null) fos.close();
      if (bos != null) bos.close();
      if (sock != null) sock.close();
    }
  }

}