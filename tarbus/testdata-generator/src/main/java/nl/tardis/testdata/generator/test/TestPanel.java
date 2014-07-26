package nl.tardis.testdata.generator.test;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

/**
 * @author Erik
 * Old skool JPanel for drawing a line on the canvas.
 */
public class TestPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private long start;
	// Key is millis since start, value is plain value.
	private Map<Long, Double> points;

	public TestPanel() {
		setSize(800, 600);
		start = new Date().getTime();
		points = new HashMap<>();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);

		for (Map.Entry<Long, Double> entry : points.entrySet()) {
			// 10 pixels = one second
			int x = (int)(entry.getKey() / 100);
			int y = entry.getValue().intValue();
			// Means: draw a point
			g.drawLine(x, y, x, y);
		}
	}

	public void addValue(double value) {
		points.put(System.currentTimeMillis() - start, value);
		this.repaint();
	}

}
