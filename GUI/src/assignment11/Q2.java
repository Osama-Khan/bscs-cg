package assignment11;

import java.awt.Point;

public class Q2 {

	// Q: Create a JAVA method to clip a polygon using Cohen Sutherland Line Clipping algorithm.

	public boolean polyClipper(Point[] points, int xmin, int xmax, int ymin, int ymax) {
		boolean isClipped = false;
		for (int i = 0; i < points.length - 1; i++) {
			boolean r = new algos.CohenLineClipper().lineClipper(points[i], points[i + 1], xmin, xmax, ymin, ymax);
			if (!isClipped && r) {
				isClipped = true;
			}
		}
		return isClipped;
	}

}
