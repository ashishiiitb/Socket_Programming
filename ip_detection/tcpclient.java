package demo;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;
public class tcpclient {
	public static void main(String args[]) throws UnknownHostException,IOException
	{
		Scanner sc= new Scanner(System.in);
		Socket s = new Socket("127.0.0.1",1342);
		if(s.isConnected())
		{
			System.out.println("CONNECTION ESTABLISH");
		}
		System.out.println("NOTE-:IP ADDRESS SHOULD BE---.---.---.---FORMAT");
		String ip1,ip2,mask;
		System.out.println("ENTER IP1");
		ip1 = sc.nextLine();
		System.out.println("ENTER IP2");
		ip2 = sc.nextLine();
		System.out.println("ENTER SUBNET");
		mask = sc.nextLine();
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(ip1);
		p.println(ip2);
		p.println(mask);
		Scanner sc1= new Scanner(s.getInputStream());
		boolean temp =sc1.nextBoolean();
		if(temp==false)
			System.out.println("BOTH IP FROM DIFFERENT SUBNET");
		else
			System.out.println("BOTH IP FROM SAME SUBNET");
			}
	//s.close();
		
	}


