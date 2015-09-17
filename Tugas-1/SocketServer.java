import java.io.*;
import java.lang.ClassNotFoundException;
import java.net.*;
 
public class SocketServer{
     
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 3002;
/*
    private void handleRequest(Socket socket){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.hgetInputStream()));
            String message = in.readLine();
            System.out.println("Message : " + message);
            in.close();
            socket.close();
        }
        catch{

        }
    }
    */
     
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        //create the socket server object
        server = new ServerSocket(port);
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for client request");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            //read from socket to ObjectInputStream object
            BufferedReader ois = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //convert ObjectInputStream object to String
            String message = ois.readLine();
            System.out.println("Message Received: " + message);
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            oos.writeObject("Hi Client "+message);
            //close resources
            ois.close();
            oos.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }
     
}
