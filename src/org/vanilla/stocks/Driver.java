/**
 * Gets stock information from Yahoo (c) finance.
 */
package org.vanilla.stocks;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.vanilla.graphics.MainPanel;

public class Driver extends Canvas {

	/** The default serial version id */
	private static final long serialVersionUID = 1L;
	/** Application's title */
	public static final String TITLE = "Stock Information by Vanilla";
	/** Default width */
	public static final int WIDTH = 400;
	/** Default height */
	public static final int HEIGHT = 300;
	/** The preferred size of the application. */
	public static final Dimension PREFERRED_SIZE = new Dimension(WIDTH, HEIGHT);
	/** The JFrame to draw */
	private JFrame frame;
	/** The JPanel to display the stock information onto. */
	private JPanel panel;

	/**
	 * Constructor: sets the default instance variables.
	 * 	sets up the JFrame.
	 */
	public Driver() {
		frame = new JFrame(TITLE);
		panel = new MainPanel();
		
		panel.setBackground(Color.BLACK);	// Sets the background to black.
		
		setPreferredSize(PREFERRED_SIZE);
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(PREFERRED_SIZE);
		panel.setSize(frame.getSize());
		
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);	// NOT resizable
		frame.setVisible(true);
		frame.pack();
	}
	
	/**
	 * Driver method to run the code.
	 * @param args
	 */
	public static void main(String[] args) {
		new Driver();
	}
	
}
