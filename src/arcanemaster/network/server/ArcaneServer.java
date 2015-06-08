package arcanemaster.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ArcaneServer {
	
	protected ServerSocket server = null;
	protected int port = 5250;
	
	public void start(){
		try {
			server = new ServerSocket(port);
		} catch (IOException ie) {
			System.out.println("Can't listen on port: " + port);
		}
		Socket client = null;
		try {
			client = server.accept();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	public void stop(){
		try {
			server.close();
		} catch (IOException e) {
			System.out.println("Unable to close socket");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
