package internet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//现开启服务器端
public class ServerDemo {
	public static void main(String[] args) throws Exception {
		int port = 8000;
		ServerSocket server = new ServerSocket(port);
		Socket socket = server.accept();
		DataInputStream in = new DataInputStream(socket.getInputStream());
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
		System.out.println(in.readInt());
		Thread.sleep(1000);
		out.writeInt(2333);
		
		in.close();
		out.close();
		socket.close();
		server.close();
	}
}
