package Algos;

import java.awt.Graphics;

public class DDALine {
	public static void Draw(int x1, int x2, int y1, int y2, Graphics g) {
		int dx = x2 - x1, dy = y2 - y1;
		int steps;
		if(Math.abs(dx) > Math.abs(dy))
			steps = Math.abs(dx);
		else
			steps = Math.abs(dy);
		float xInc = (float)dx / (float)steps;
		float yInc = (float)dy / (float)steps;
		float x = x1, y = y1;
		g.drawString(".", (int)x, (int)y);
		for (int k = 1; k <= steps; k++) {
			x += xInc;
			y += yInc;
			g.drawString(".", (int)x, (int)y);
		}
	}
}
