package nl.tardis.testdata.generator;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.Random;

public class TestdataGenerator {

	private static final DecimalFormat FORMATTER = new DecimalFormat("#.##");

	public void generate(String host, int port) throws IOException, InterruptedException {
		System.out.println("Starting testdata generator");

		// First connect to the host.
		Socket clientSocket = new Socket(host, port);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

		Random random = new Random();
		// The actual value
		double currentValue = 100;
		// Delta to change the value with
		double currentDelta = 0;
		// Going up (true) or down (false)
		boolean goingUp = true;
		// How likely the direction will change
		double tendencyTreshhold = 1;

		while (true) {
			// Write the value to the socket (2 decimal places)
			outToServer.writeBytes("" + FORMATTER.format(currentValue) + '\n');

			// Change the delta-delta
			double deltaDelta = random.nextDouble() / 2;
			// Up or down
			if (!goingUp) {
				deltaDelta = -1 * deltaDelta;
			}
			// Step delta
			currentDelta += deltaDelta;
			tendencyTreshhold -= 0.002;
			// Check if we need to switch direction
			if (random.nextDouble() > tendencyTreshhold) {
				goingUp = !goingUp;
				tendencyTreshhold = 1;
				currentDelta = 0;
			}

			// Increment
			currentValue += currentDelta;
			// Some randomness in the sleep
			Thread.sleep(60 + (int)((random.nextDouble() - 0.5) * 40));
		}

		// TODO: escape loop?
//		outToServer.close();
//		clientSocket.close();
	}

}
