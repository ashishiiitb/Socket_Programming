package demo;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class tcpserver {
	public static void main(String args[]) throws IOException{
		ServerSocket s1 = new ServerSocket(1342);
		Socket ss=s1.accept();
		Scanner sc= new Scanner(ss.getInputStream());
		String ip1,ip2,mask;
		ip1 = sc.nextLine();
		ip2 = sc.nextLine();
		mask = sc.nextLine();
		boolean temp=true;
		byte[] a1 = InetAddress.getByName(ip1).getAddress();
		byte[] a2 = InetAddress.getByName(ip2).getAddress();
		byte[] m = InetAddress.getByName(mask).getAddress();
		for (int i = 0; i < a1.length; i++)
				    {   if ((a1[i] & m[i]) != (a2[i] & m[i]))
				            temp= false;

				}
		PrintStream p = new PrintStream(ss.getOutputStream());
		p.println(temp);
	}
}
