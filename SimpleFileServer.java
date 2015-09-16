import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFileServer {

  public final static int SOCKET_PORT = 1234;
  public static String message = "NULL";
  public final static String FILE_TO_SEND_A = "D:/Ngampus/Semester 5/pemrograman integratif/A.txt";
  public final static String FILE_TO_SEND_B = "D:/Ngampus/Semester 5/pemrograman integratif/B.txt";
  public final static String FILE_TO_SEND_C = "D:/Ngampus/Semester 5/pemrograman integratif/C.txt";
  public static void main (String [] args ) throws IOException {
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    OutputStream os = null;
    ServerSocket servsock = null;
    Socket sock = null;
    try {
      servsock = new ServerSocket(SOCKET_PORT);
      while (true) {
        System.out.println("Waiting...");
        try {
          sock = servsock.accept();
          System.out.println("Accepted connection : " + sock);
          ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
          BufferedReader ois = new BufferedReader(new InputStreamReader(sock.getInputStream()));
          //write object to Socket
          System.out.println(message);
          //if(message == "NULL") {
            oos.writeObject("   Hi Client! Please select text file to download : 1. A.txt 2. B.txt 3. C.txt");
            
            //convert ObjectInputStream object to String
          //  String message = ois.readLine();
          //}
          //send file
          String message = ois.readLine();
          System.out.println(message);
          if(message.equalsIgnoreCase("A")){
            File myFile = new File (FILE_TO_SEND_A);
            byte [] mybytearray  = new byte [(int)myFile.length()];
            fis = new FileInputStream(myFile);
            bis = new BufferedInputStream(fis);
            bis.read(mybytearray,0,mybytearray.length);
            os = sock.getOutputStream();
            System.out.println("Sending " + FILE_TO_SEND_A+ "(" + mybytearray.length + " bytes)");
            os.write(mybytearray,0,mybytearray.length);
            os.flush();
            System.out.println("Done.");
          } else if(message.equalsIgnoreCase("B")){
            File myFile = new File (FILE_TO_SEND_B);
            byte [] mybytearray  = new byte [(int)myFile.length()];
            fis = new FileInputStream(myFile);
            bis = new BufferedInputStream(fis);
            bis.read(mybytearray,0,mybytearray.length);
            os = sock.getOutputStream();
            System.out.println("Sending " + FILE_TO_SEND_B+ "(" + mybytearray.length + " bytes)");
            os.write(mybytearray,0,mybytearray.length);
            os.flush();
            System.out.println("Done.");
          } else if(message.equalsIgnoreCase("C")){
            File myFile = new File (FILE_TO_SEND_C);
            byte [] mybytearray  = new byte [(int)myFile.length()];
            fis = new FileInputStream(myFile);
            bis = new BufferedInputStream(fis);
            bis.read(mybytearray,0,mybytearray.length);
            os = sock.getOutputStream();
            System.out.println("Sending " + FILE_TO_SEND_C+ "(" + mybytearray.length + " bytes)");
            os.write(mybytearray,0,mybytearray.length);
            os.flush();
            System.out.println("Done.");
          } else{oos.writeObject("\n Invalid input, quitting");}
        }
        finally {
          if (bis != null) bis.close();
          if (os != null) os.close();
          if (sock!=null) sock.close();
        }
      }
    }
    finally {
      if (servsock != null) servsock.close();
    }
  }
}
