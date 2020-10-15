import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Rfc865UdpServer {

	public static void main(String[] argv) {
		
		
				//
				// 1. Open UDP socket at well-known port
				//
				
				DatagramSocket socket = null;
				try {
					//Port 17 for QOTD.
					socket = new DatagramSocket(17);
				}catch(SocketException e) {
					
				}
				
				while(true) {
					try {
						
						//
						// 2. Listen for UDP request from client
						//
						
						//creates an array of bytes which is used to create a Datagram Packet.
						byte[] buf = new byte[512];
						
						//Test is client-side can receive
						
						
						
						
						
						DatagramPacket request = new DatagramPacket(buf, buf.length);
						socket.receive(request);
						
						//what the client has sent to the server
						String dataReceived = new String(buf,0,request.getLength());
						System.out.println("Data Received : " + dataReceived); 
				
						//
						// 3. Send UDP reply to client
						//
						
						//this will send response to the client over the DatagramSocket.
						
						
					
						
						InetAddress address = request.getAddress();
						int port = request.getPort();
						
						String sendThisBack = "Send String ";
						byte[] sendThis = sendThisBack.getBytes();
						
						DatagramPacket reply = new DatagramPacket(sendThis, sendThis.length,address,port);
						socket.send(reply);
						
						
					}catch(IOException e) {
						
					}
					
					socket.close();
				}
				
			
				
				
		}
	}