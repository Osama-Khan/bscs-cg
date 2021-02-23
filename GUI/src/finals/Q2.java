package finals;

import java.awt.*;

public class Q2 {
	Graphics g;
	public Q2(Graphics g) {this.g = g;}

	void drawPolygon (int[] x, int[] y, int n) { g.drawPolygon(x, y, n); }
	void drawRectangle (int x, int y, int w, int h) { g.drawRect(x, y, w, h); }
	void drawCircle (int xc, int yc, int r) { algos.Circle.midPoint(xc, yc, r, g); }

	public void draw() {
		// Face
		drawCircle(400, 150, 100); // C1
		drawCircle(400, 195, 50); // C2
		drawCircle(400, 175, 30); // C3
		drawCircle(350, 150, 10); // C4
		drawCircle(450, 150, 10); // C5
		drawCircle(300, 75, 50); // C6
		drawCircle(500, 75, 50); // C7
		drawCircle(400, 225, 15); // C8
		// Torso
		drawRectangle(300, 250, 200, 250);
		// Chest
		drawPolygon(new int[]{325, 475, 400}, new int[]{275, 275, 400}, 3);
		// Right Arm
		drawPolygon(new int[]{285, 225, 200}, new int[]{250, 275, 450}, 3);
		// Left Arm
		drawPolygon(new int[]{515, 575, 600}, new int[]{250, 275, 450}, 3);
	}
}