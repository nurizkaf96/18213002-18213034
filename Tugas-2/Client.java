import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client
{

	private static Socket socket;

	public static void main(String args[])
	{
		try
		{
			String s = "wow";
			Scanner sc = new Scanner(System.in);
			//String host = "localhost";
			//int port = 3002;
			//InetAddress address = InetAddress.getByName(host);
			//socket = new Socket(host, port);
			socket = new Socket("192.168.1.122", 1234);

			//Send the message to the server
			while(s != "exit"){
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);

			s = sc.nextLine();			

			String sendMessage = s;
			bw.write(sendMessage);
			bw.flush();
			System.out.println("Message sent to the server : "+sendMessage);

			//Get the return message from the server
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String message = br.readLine();
			System.out.println("Message received from the server : " +message);
			}
			
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			//Closing the socket
			try
			{
				socket.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
