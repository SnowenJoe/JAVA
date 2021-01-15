package chatApplication;

import java.net.*;
import java.io.*;
public class Server {
	
	ServerSocket server;
	Socket socket;
	
	BufferedReader buffer;
	PrintWriter out;
	//constructor
	public Server() {
		try {
			server=new ServerSocket(7777);
			System.out.println("Server is ready to accept connection");
			System.out.println("waiting..");
			socket=server.accept();
			
			buffer=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			out= new PrintWriter(socket.getOutputStream());
			
			startReading();
			startWriting();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void startReading() {
		// thread-read data
		Runnable r1= ()->{
			System.out.println("reader start..");
			try {
				while(true) {
					
					String msg=buffer.readLine();
					if(msg.equals("exit")) {
						System.out.println("Client terminated chat");
						socket.close();
						break;
					}
					System.out.println("Client : "+msg);
					
				
			}
			}catch(Exception e) {
//				e.printStackTrace();
				System.out.println("connection close");
			}
			
		};
		new Thread(r1).start();
	}
	public void startWriting() {
		// thread- data user and send clinet
		Runnable r2=()->{
			System.out.println("writing start ..");
			try {
				while(!socket.isClosed()) {
					
					BufferedReader buffer1=new BufferedReader(new InputStreamReader(System.in));
					String content = buffer1.readLine();
					out.println(content);
					out.flush();
					if(content.equals("exit")) {
						socket.close();
						break;
					}
				
			}
			}catch(Exception e){
//				e.printStackTrace(); 
				System.out.println("connection close");
			}
			System.out.println("connection close");
			
		};
		new Thread(r2).start();
	}

	public static void main(String[] args) {
		new Server();

	}

}
