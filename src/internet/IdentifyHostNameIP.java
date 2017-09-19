package internet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IdentifyHostNameIP {
	public static void main(String[] args) throws UnknownHostException {
		System.out.println("HelloWorld");
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			InetAddress[] addresss = InetAddress.getAllByName(input.next());
			for (InetAddress address : addresss) {
				System.out.println("Host name: " + address.getHostName());
				System.out.println("IP address: " + address.getHostAddress());
			}
		}
		input.close();
	}
}
