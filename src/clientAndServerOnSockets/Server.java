package clientAndServerOnSockets;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static final int port = 8080;//address of service
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(port);//server uses this socket for listening input connections
		try { while (true) {
			Socket socket = s.accept();//client uses this socket for connection initialization
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//reading text from character-input stream
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);//text strings're being sent by received writer of print
				String str = in.readLine();//text that has to be received
				out.println(str);
			}
			finally { socket.close(); }
		}
		}
		finally { s.close(); }
	}
}