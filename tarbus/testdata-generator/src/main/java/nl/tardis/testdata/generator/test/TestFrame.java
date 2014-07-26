package nl.tardis.testdata.generator.test;

import javax.swing.JFrame;

/**
 * @author Erik
 * Ols skool JFrame for testing
 *
 */
public class TestFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private TestPanel panel;

	public TestFrame() {
		super("Test Frame");
		setLayout(null);
		setSize(800, 600);
		panel = new TestPanel();
		this.getContentPane().add(panel);
	}

	public void addValue(double value) {
		panel.addValue(value);
	}

}
