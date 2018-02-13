import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

public class udpserver{
    public static void main(String args[]) throws IOException {
        DatagramSocket ds=new DatagramSocket(6667);

        byte[] b1 = new byte[1024];
        DatagramPacket dp;
        dp = new DatagramPacket(b1, b1.length);
        ds.receive(dp);
        String str = new String(dp.getData(), 0, dp.getLength());
        int n = Integer.parseInt(str.trim());
        int[] arr=new int[n];
        for(int j=0;j<n;j++) {

            dp = new DatagramPacket(b1, b1.length);
            ds.receive(dp);
            str = new String(dp.getData(), 0, dp.getLength());
            arr[j] = Integer.parseInt(str.trim());

        }
        System.out.println("Receive the element");
        for(int j=0;j<n;j++) {
            System.out.println(arr[j]);

        }
        Arrays.sort(arr);
        String temp=Arrays.toString(arr);
        for(int j=0;j<1;j++) {
            byte[] b2 = temp.getBytes();
           // DatagramPacket dp = new DatagramPacket(b2, b2.length);
            InetAddress io = InetAddress.getLocalHost();
            DatagramPacket dp1 = new DatagramPacket(b2, b2.length, dp.getAddress(), dp.getPort());
            ds.send(dp1);
        }
    }
}