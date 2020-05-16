package kr.hs.dgsw.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class MulticastServerMain {

		public static void main(String[] args) {
			System.out.println("Multi Server Start");
			try 
			{
				DatagramSocket serverSocket = new DatagramSocket(9000);
				while(true) {
					String msg = new Date().toString();
					byte[] buffer = msg.getBytes();
					InetAddress inet = InetAddress.getByName("224.0.0.0");
					DatagramPacket multiPacket = new DatagramPacket(buffer, buffer.length, inet, 8000);
					serverSocket.send(multiPacket);
					System.out.println("Send Data : " + msg);
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
		}
}
