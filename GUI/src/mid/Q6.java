package mid;

import java.awt.Point;

public class Q6 {
	// (a)
	Point translatePoint(Point p, int tx, int ty) {
		return new Point((p.x + tx), (p.y + ty));
	}
	
	// (b)
	Point rotatePoint(Point p, Point pivot, double degAngle) {
		double rad = Math.toRadians(degAngle);
		double sin = Math.sin(rad);
		double cos = Math.cos(rad);
		int xDash = (int)(pivot.x + (p.x - pivot.x )* cos - (p.y - pivot.y) * sin);
		int yDash = (int)(pivot.y + (p.x - pivot.x) * sin + (p.y - pivot.y) * cos);
		Point pDash = new Point(xDash, yDash);
		return pDash;
	}
	
	// (c)
	Point transform(Point target, Point pivot, int tx, int ty, double degAngle) {
		target = translatePoint(target, tx, ty);
		target = rotatePoint(target, pivot, degAngle);
		return target;
	}
}
