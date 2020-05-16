package kr.hs.dgsw.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// UDP : 상대방이 받든 말든 보내면 끝
public class UdpClientMain {

	public static int port = 9001;
	
	public static void main(String[] args) {
		
		try 
		{
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress inet = InetAddress.getLocalHost();
			String msg = "hello world";
			byte[] datas = msg.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(datas, datas.length, inet, port);
			clientSocket.send(sendPacket);
			System.out.println("send Complete");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
