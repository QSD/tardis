package nl.tardis.testdata.generator;

import nl.tardis.testdata.generator.test.TestListener;


public class Main {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("Usage: Main <host> <port>");
			System.exit(0);
		}
		String host = args[0];
		try {
			int port = Integer.parseInt(args[1]);

			if (host.equals("localhost")) {
				new TestListener().start(port);
			}

			new TestdataGenerator().generate(host, port);
		} catch (NumberFormatException e) {
			System.out.println("Please provide a number as port");
		}
	}

}
