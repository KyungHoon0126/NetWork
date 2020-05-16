package kr.hs.dgsw.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServerMain {

	public static int serverPort = 9000;
	
	public static void main(String[] args) {
		
		try 
		{
			DatagramSocket serverSocket = new DatagramSocket(serverPort);
			while(true)
			{
				byte[] receiveData = new byte[1024];
				System.out.println("Waiting Data Gram");
				
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				String msg = new String(receivePacket.getData());
				InetAddress address = receivePacket.getAddress();
				int clientPort = receivePacket.getPort();
				
				System.out.println("address : " + address);
				System.out.println("clientPort : " + clientPort);
				System.out.println("msg : " + msg);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
