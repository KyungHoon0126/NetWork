package kr.hs.dgsw.URL;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


public class InetTest {

	public static void main(String[] args) {
		
		try 
		{	
			//InetNet
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("address : " + address.getHostName());
			System.out.println("address : " + address.getHostAddress());
			
			//NetWorkIO
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress(address, 80));
			
			while(!socketChannel.finishConnect()) {
				
			}
			
			System.out.println(socketChannel);
			System.out.println(socketChannel.isConnected());
			System.out.println(socketChannel.isBlocking());
			
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			System.out.println("buffer : " + buffer);
			int byteRead = socketChannel.read(buffer);
			System.out.println("byteRead : " + byteRead);
			
			if(byteRead > 0) {
				buffer.flip();
				while(buffer.hasRemaining()) {
					System.out.println(buffer.getChar());
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

	}

}