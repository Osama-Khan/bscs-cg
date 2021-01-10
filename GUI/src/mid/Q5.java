package mid;

import javax.swing.*;
import algos.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Q5 extends JFrame {
	
	public JPanel panel;
	private Point selectedPoint;
	public Q5() {
		setSize(500, 500);
		setVisible(true);
		panel = new JPanel();
		panel.setSize(500, 500);
		add(panel);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					selectedPoint = e.getPoint();
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					if (selectedPoint != null) {
						Graphics g = panel.getGraphics();
						int xd = (int) Math.abs(selectedPoint.x - e.getX());
						int yd = (int) Math.abs(selectedPoint.y - e.getY());
						int r = xd > yd? xd : yd;
						midPoint(selectedPoint.x, selectedPoint.y, r, g);
					}
				}
			}
		});
	}
	
	public static void midPoint(int xc, int yc, int radius, Graphics g) {
		int x = 0, y = radius;
		int p = 1 - radius; 
		octantRule(x, y, xc, yc, g); 
		while(x<y) { 
			x++;
			if(p<0) {
				p = p + 2 * x + 1;
			}
			else {
				y--;
				p = p + 2 * (x - y) + 1;
			}
			octantRule(x, y, xc, yc, g);
		}
	}

	public static void octantRule(int x, int y, int xc, int yc, Graphics g) {
		g.drawString(".", xc + y, yc + x);
		g.drawString(".", xc + x, yc + y);
		g.drawString(".", xc - x, yc + y);
		g.drawString(".", xc - y, yc + x);
		g.drawString(".", xc - x, yc - y);
		g.drawString(".", xc - y, yc - x);
		g.drawString(".", xc + x, yc - y);
		g.drawString(".", xc + y, yc - x);
	}
	
	public static void main(String[] args) {
		new Q5();
	}
}
