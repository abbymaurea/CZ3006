import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class Rfc865UdpClient {
	
	//application client sends a request to the server, waits for a response, and when the response is received it is
	//displayed as a standard output.
	static String serverName = "172.21.150.53";
	public static void main(String[] argv) {
		
		//
		// 1. Open UDP socket
		//
		
		DatagramSocket socket = null;
		try {
			//client uses a constructor that does not require a port number - binds to any available local port.
			socket = new DatagramSocket();
			
		}catch(SocketException e) {
			
		}
		try {
			//
			// 2. Send UDP request to server
			//
			
			
			//try sending out your name;
			
			String toSend = "Roxas Abby Maurea Imus, TS4, " + InetAddress.getLocalHost().getHostAddress();
			byte[] buf = new byte[512];
			byte[] clientSideBuf = toSend.getBytes();
			
			

		//	InetAddress addressTry = InetAddress.getByAddress(172.21.150.53);
			InetAddress address = InetAddress.getByName(serverName); //HWLab1 ( 172.21.150.53))
			
			DatagramPacket request = new DatagramPacket(clientSideBuf, clientSideBuf.length, address, 17);
			socket.send(request);
			
			//System.out.print("test");
			
			
			//
			// 3. Receive UDP reply from server;
			//
			DatagramPacket reply = new DatagramPacket(buf, buf.length);
			//
			socket.receive(reply);
			//String received = new String(buf);
			String received = new String(reply.getData(),0,reply.getLength());
			
			
			//Check if you can receive
				//System.out.print("here is where you get it"+ received);
			
			System.out.println("Message send: " + toSend);
			System.out.println("Message receive: " + received);
			System.out.println("Your PC IP address: " + InetAddress.getLocalHost().getHostAddress());
			System.out.println("Quote of Day server IP address: " + address.getCanonicalHostName());
	
			socket.close();
			
		}catch(IOException e) {
			
		}
		

		
	}

}