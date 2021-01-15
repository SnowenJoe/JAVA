package chatApplication;


import java.net.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class Client extends JFrame {

	Socket socket;
	
	BufferedReader buffer;
	PrintWriter out;
	
	//components
	private JLabel heading = new JLabel("client");
	private JTextArea message = new JTextArea();
	private JTextField msgInput = new JTextField();
	private Font font = new Font("Roboto",Font.PLAIN,20);
	//constructor
	public Client() {
		try {
			System.out.println("Sending request to server");
			socket= new Socket("127.0.0.1",7777);
			System.out.println("connected");
			
			
			buffer=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			out= new PrintWriter(socket.getOutputStream());
//			
			
			createGUI();
			handleEvents();
			startReading();
//			startWriting();
			
		}catch(Exception e) {
			
		}
	}
	private void createGUI() {
		this.setTitle("Client Messageer");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		heading.setFont(font);
		message.setFont(font);
		msgInput.setFont(font);
		
		//set heading area
//		heading.setIcon(new ImageIcon("chatLogo.png"));
//		heading.setHorizontalTextPosition(SwingConstants.CENTER);
//		heading.setVerticalTextPosition(SwingConstants.BOTTOM);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		
		
		//frame layout
		this.setLayout(new BorderLayout());
		//frame components
		this.add(heading,BorderLayout.NORTH);
		this.add(message,BorderLayout.CENTER);
		this.add(msgInput,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	private void handleEvents() {
		msgInput.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {
				
			}
			public void keyPressed(KeyEvent e) {
				
			}
			public void keyReleased(KeyEvent e) {
//				//to find enter key.
//				System.out.println("key release"+e.getKeyCode());
				if(e.getKeyCode()==10) {
//					System.out.println("enter button");
					String contentToSend=msgInput.getText();
					message.append("ME: "+contentToSend +"\n");
					
					out.println(contentToSend);
					out.flush();
					msgInput.setText("");
					msgInput.requestFocus();
				}
			}
		});
	}
	//start reading
	public void startReading() {
		// thread-read data
		Runnable r1= ()->{
			System.out.println("reader start..");
			try {
				while(true) {
					
					String msg=buffer.readLine();
					if(msg.equals("exit")) {
						System.out.println("Server terminated chat");
						JOptionPane.showMessageDialog(this, "Server Terminated ");
						msgInput.setEnabled(false);
						socket.close();
						break;
					}
//					System.out.println("Server : "+msg);
					message.append("Server : "+msg+"\n");
					
				
			}
			}catch(Exception e) {
				e.printStackTrace();
//				System.out.println("connection close");
			}
			
		};
		new Thread(r1).start();
	}
	//start writing
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
		new Client();

	}

}
