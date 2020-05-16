package kr.hs.dgsw.udp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClientMain {

	public static void main(String[] args) {
		System.out.println("Multicast Client Start");
		try 
		{
			// ³»pc, ³» pc port
			MulticastSocket cSocket = new MulticastSocket(8000);
			InetAddress inet = InetAddress.getByName("230.0.0.0");
			cSocket.joinGroup(inet);
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			for(int i = 0; i < 10; i++)
			{
				cSocket.receive(packet);
				String msg = new String(packet.getData());
				System.out.println("client msg : " + msg);
			}
			System.out.println("end client");
			cSocket.leaveGroup(inet);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
