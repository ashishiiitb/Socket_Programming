package demoudp;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class udpserver {
	   public static void main(String args[]) throws Exception
	      {
	         DatagramSocket serverSocket = new DatagramSocket(9876);
	         byte[] buf1 = new byte[1000];
             DatagramPacket dgp1 = new DatagramPacket(buf1, buf1.length);
             byte[] buf2 = new byte[1000];
             DatagramPacket dgp2 = new DatagramPacket(buf2, buf2.length);
             byte[] buf3 = new byte[1000];
             DatagramPacket dgp3 = new DatagramPacket(buf3, buf3.length);
          
             byte[] out = new byte[1000];
             out[0]=1;
            		   
	            while(true)
	               {
	            	serverSocket.receive(dgp1);
	            	serverSocket.receive(dgp2);
	            	serverSocket.receive(dgp3);
	            	for (int i = 0; i < buf1.length; i++)
				    {   if ((buf1[i] & buf3[i]) != (buf2[i] & buf3[i]))
				            out[0]= 0;

				}
	            	String outMessage;
	            	if(out[0]==0)
	            		outMessage="BOTH IP FROM DIFFERENT SUBNET";
	            	else	
	            		outMessage="BOTH IP FROM SAME SUBNET";
	            	out=outMessage.getBytes();
	            	DatagramPacket out1 = new DatagramPacket(out, out.length, dgp1.getAddress(), dgp1.getPort());
	            	serverSocket.send(out1);

	            	
	      }
	}
}

