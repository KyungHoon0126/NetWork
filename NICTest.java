package kr.hs.dgsw.networkinterface;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

// 2020.06.03 NetworkInterface

public class NICTest 
{
	public static void main(String[] args) 
	{	
		NetworkInterface nic;
		
		try 
		{
			// InetAddress inet;
			// inet = InetAddress.getLocalHost();
			// nic = NetworkInterface.getByInetAddress(inet);

			// // System.out.println(nic);
			// showNIC(nic);
			
			
			// PC�� ����ϴ� ��� ��� ���
			Enumeration<NetworkInterface> nics =  NetworkInterface.getNetworkInterfaces();
			ArrayList<NetworkInterface> list = Collections.list(nics);
			if(list != null)
			{
				for(int  i = 0; i < list.size(); i++)
				{
					showNIC(list.get(i));
				}	
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 *�ڡڡ� �߿� �ڡڡ�
	 */
	private static void showNIC(NetworkInterface nic) 
	{
		System.out.println("");
		System.out.println(nic.getDisplayName());
		Enumeration<InetAddress> inets =  nic.getInetAddresses();
		ArrayList<InetAddress> list = Collections.list(inets);
		
		if(list != null)
		{
			for(int  i = 0; i < list.size(); i++)
			{
				// Ipv6 ���ʹ� �������� 0�ϰ��, :(�ݷ�)���� ���� ����.
				System.out.println(i + " : " + list.get(i));
			}	
		}
		
		try 
		{
			// �� �ּ�
			byte[] macs = nic.getHardwareAddress();
			
			String MAC = "";
			
			if(macs != null)
			{
				for(byte item : macs)
				{
					MAC += String.format("%x ", item);
				}	
			}
			System.out.println(MAC);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
