package nl.tardis.testdata.generator.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Erik
 * Listener on port for testing purposes, prints the values and pops up a frame with graph.
 */
public class TestListener {

	private boolean started = false;

	public void start(int port) throws IOException, InterruptedException {
		System.out.println("Starting test server...");
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ServerSocket serverSocket = new ServerSocket(port);
					started = true;
				    Socket clientSocket = serverSocket.accept();
					System.out.println("Client connected");
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				    String line;
				    while ((line = in.readLine()) != null) {
				    	System.out.println(line);
				    	frame.addValue(Double.parseDouble(line.replace(",", ".")));
				    }
				} catch (Exception e) {
					System.out.println("Exception in server");
					e.printStackTrace();
				}
			}
		}).start();

		while (!started) {
			Thread.sleep(100);
		}
	}
}
