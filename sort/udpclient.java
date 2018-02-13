import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class udpclient {
    public static void main(String args[]) throws IOException {
        DatagramSocket ds=new DatagramSocket();
        Scanner sc=new Scanner(System.in);
        InetAddress io=InetAddress.getLocalHost();
        System.out.println("Enter the size of array");
        int n = sc.nextInt();

        byte[] b = String.valueOf(n).getBytes();

        DatagramPacket dp = new DatagramPacket(b, b.length, io, 6667);
        ds.send(dp);
        System.out.println("Enter the number of element");
        for(int j=0;j<n;j++) {
            int i = sc.nextInt();

            byte[] b1 = String.valueOf(i).getBytes();

            dp = new DatagramPacket(b1, b1.length, io, 6667);
            ds.send(dp);
        }

            byte[] b1 = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
            ds.receive(dp1);
            String str = new String(dp1.getData(), 0, dp1.getLength());
            System.out.println("result is" + str);

    }
}
