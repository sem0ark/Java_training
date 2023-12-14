package com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000); // Create server socket
                log("Server started at " + new Date() + '\n');

                while (true) {
                    Socket socket = serverSocket.accept(); // Listening for new connection requests

                    // Get name and IP address of the client computer
                    InetAddress inetAddress = socket.getInetAddress();
                    log("Client host name is " + inetAddress.getHostName() + "\n");
                    log("Client IP Address is " + inetAddress.getHostAddress() + "\n");

                    // Creating and starting a new thread to connect to the client  
                    new Thread(() -> {
                    	try {
                            // Create input and output data stream  
                            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                            // Continuous client service  
                            while (true) {
                               int seconds = inputFromClient.readInt(); // Get the radius from the client
                               String time = String.format("%02d:%02d:%02d", seconds / 3600, seconds % 3600 / 60, seconds % 60);
                               outputToClient.writeInt(time.length());
                               outputToClient.write(time.getBytes());
                               outputToClient.flush();
                               
                               log("Seconds received from client: %d\n", seconds);
                               log("Time found: %s\n", time);
                            }
                         } catch (IOException e) {
                            e.printStackTrace();
                         }
                    }).start();
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }).start();
	}

	public static void log(String s) {
		System.out.println(s);
	}

	public static void log(String s, Object... o) {
		System.out.printf(s, o);
	}
}
