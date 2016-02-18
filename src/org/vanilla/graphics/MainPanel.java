package org.vanilla.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.vanilla.stocks.Driver;

public class MainPanel extends JPanel {
	
	/** Default serial version id */
	private static final long serialVersionUID = 1L;
	
	private Driver driver;
	
	public MainPanel(Driver d) {
		driver = d;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("verdana", Font.BOLD, 11));
		g.setColor(new Color(164, 224, 178));
		g.drawString(Driver.TITLE, 5, 18);
		g.setFont(new Font("verdana", Font.PLAIN, 11));
		g.drawString("Stock Name: \t" + driver.getCurrentStock().getShortName(), 5, 43);
		g.drawString("Company Name \t" + driver.getCurrentStock().getCompanyName(), 5, 58);
		g.drawString("Current Price: \t$" + driver.getCurrentStock().getCurrentPrice(), 5, 73);
	}
}
