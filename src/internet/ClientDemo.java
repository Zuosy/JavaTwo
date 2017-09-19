package internet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
//后开启客户端
public class ClientDemo {
	public static void main(String[] args) throws Exception {
		int port = 8000;
		String host = "localhost";
		Socket socket = new Socket(host, port);
		DataInputStream in = new DataInputStream(socket.getInputStream());
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
		out.writeInt(10086);
		System.out.println(in.readInt());
		
		in.close();
		out.close();
		socket.close();
	}
}
