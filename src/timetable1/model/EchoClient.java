/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable1.model;

/**
 *
 * @author Abhishek
 */
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;


public class EchoClient {
	public static void main(String[] args) throws IOException {
                execAdb();
		//System.out.println("EchoClient.main()");
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			echoSocket = new Socket("localhost", 1004);
			out = new PrintWriter(echoSocket.getOutputStream());
			//in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		}
                catch (UnknownHostException e) {
                    e.printStackTrace();
			System.err.println("Don't know about host: localhost.");
			System.exit(1);
		}
                catch (IOException e) {
                    e.printStackTrace();
			System.err.println("Couldn't get I/O for the connection to: localhost.");
			System.exit(1);
		}

		//BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		// String userInput;
                
		System.out.println("connected!!");
		int counter = 0;

		// TODO monitor
		while (true) {
			counter++;
                        //System.out.println("1");
			 out.println(counter);
			if (counter % 1000 == 0) {
                            //System.out.println("1");
				out.println("update" + new Date().getSeconds());
				counter = 1;
				//System.out.println("echo: " + in.readLine());
			}
		}
	}
        
        public static void execAdb() {
// run the adb bridge
try {
Process p=Runtime.getRuntime().exec("C:\\android-sdk-windows\\platform-tools\\adb.exe forward tcp:1004 tcp:1005");
Scanner sc = new Scanner(p.getErrorStream());
if (sc.hasNext()) {
while (sc.hasNext()) System.out.println(sc.next());
System.out.println("Cannot start the Android debug bridge");
}
} catch (Exception e) {
System.out.println(e.toString());
}
}
}
