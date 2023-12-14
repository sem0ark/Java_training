package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Socket socket;
		Scanner scan = null;
		try {
			socket = new Socket("localhost", 8000);
			DataInputStream fromServer = new DataInputStream(socket.getInputStream());
			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
			scan = new Scanner(System.in);
			
			System.out.print("Enter number of seconds: ");
			while(true) {
				try {
					int seconds = scan.nextInt();
					
					toServer.writeInt(seconds);
					toServer.flush();
					
					System.out.println("Waiting for result...");
					System.out.println("Result: " + new String(
							fromServer.readNBytes(
									fromServer.readInt() // first get the length
							))); // then get the string
				} catch (InputMismatchException e) {
					System.out.println("Bad input!");
					scan.next();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(scan != null) scan.close();
		}
	}
}
