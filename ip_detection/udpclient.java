package demoudp;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class udpclient {
	   public static void main (String args[]) throws Exception   {
	        DatagramSocket clientSocket = new DatagramSocket();
	        Scanner sc= new Scanner(System.in);
	        InetAddress IPAddress = InetAddress.getByName("localhost");
	        String ip1,ip2,mask,oip1,oip2,omask;
	        System.out.println("NOTE-:IP ADDRESS SHOULD BE---.---.---.---FORMAT");
			System.out.println("ENTER IP1");
			ip1 = sc.nextLine();
			/*Pattern p1= Pattern.compile(".");
			String[] st1=p1.split(ip1);
			for(String str1:st1)
			{
				oip1=oip1+str1;
				int a=str1.length();
				while(a>=3)
				{
					oip1="0"+oip1;
					a++;
				}
				oip1=oip1+".";
			}
			
			*/
			System.out.println("ENTER IP2");
			ip2 = sc.nextLine();
			System.out.println("ENTER SUBNET");
			mask = sc.nextLine();
			byte[] buf1 = new byte[1000];
			DatagramPacket dp1 = new DatagramPacket(buf1, buf1.length);
			byte[] buf2 = new byte[1000];
			DatagramPacket dp2 = new DatagramPacket(buf2, buf2.length);
			byte[] buf3= new byte[1000];
			DatagramPacket dp3 = new DatagramPacket(buf3, buf3.length);
			buf1 = ip1.getBytes();
			buf2 = ip2.getBytes();
			buf3 = mask.getBytes();
	        DatagramPacket sendPacket1 = new DatagramPacket(buf1,buf1.length , IPAddress, 9876);
	        DatagramPacket sendPacket2 = new DatagramPacket(buf2, buf2.length, IPAddress, 9876);
	        DatagramPacket sendPacket3 = new DatagramPacket(buf3, buf3.length, IPAddress, 9876);
	        clientSocket.send(sendPacket1);
	        clientSocket.send(sendPacket2);
	        clientSocket.send(sendPacket3);
	        clientSocket.receive(dp1);
	        String temp = new String(dp1.getData());
	        System.out.println(temp);
	   }
}
			
	


