package org.vanilla.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.vanilla.stocks.Driver;

public class MainPanel extends JPanel {
	
	/** Default serial version id */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("verdana", Font.PLAIN, 9));
		g.setColor(new Color(164, 224, 178));
		g.drawString(Driver.TITLE, 5, 18);
	}
}
