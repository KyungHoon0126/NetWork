package kr.hs.dgsw.networkinterfacecontroller;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class NetworkedinfoMain 
{
	public static void main(String[] args) 
	{
		try 
		{
			InetAddress inet =InetAddress.getLocalHost();
			System.out.println(inet);
			NetworkInterface network =NetworkInterface.getByInetAddress(inet); 
			System.out.println("mac address : " + getMacAddress(network));
			
			// 내가 사용가능한 장비를 다 가져오자.
			getUsingNetworkDevice();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
	
	public static String getMacAddress(NetworkInterface network) 
	{
		String mac = "";
		try {
			byte[] address = network.getHardwareAddress();
			if(address != null)
			{
				for(int i = 0; i < address.length; i++)
				{
					mac += String.format("%02X", address[i]);
					mac += '-';
				}
			}
		} 
		catch (SocketException e) 
		{
			e.printStackTrace();
		}
		
		return mac;
	}
	
	public static String getIpAddress(NetworkInterface network)
	{
		String ip = "";
		Enumeration<InetAddress> ips =  network.getInetAddresses();
		ArrayList<InetAddress> list = Collections.list(ips);
		for(int i = 0; i < list.size(); i++)
		{
			ip += list.get(i).getHostAddress();
		}
		
		return ip;
	}
	
	public static void getUsingNetworkDevice()
	{
		try 
		{
			Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
			System.out.println("Network Information");
			
			ArrayList<NetworkInterface> list =Collections.list(networks);
			for(NetworkInterface network : list)
			{
				if(network.getDisplayName().contains("Wireless-AC"))
					continue;
				
				System.out.println("Network Name : " + network.getDisplayName());
				
				System.out.println("Mac Address : " + getMacAddress(network));
				
				System.out.println("Ip Address : " + getIpAddress(network));
			}
		} 
		catch (SocketException e) 
		{
			e.printStackTrace();
		}
	}
}
