package algos.transform;

import java.awt.Graphics;
import java.awt.Point;

import algos.Circle;

public class Scale {
	public static Point scalePoint(Point p, double sx, double sy) {
		Point pr = new Point();
		pr.x = (int) (p.x * sx);
		pr.y = (int) (p.y * sy);
		return pr;
	}
	
	public static void scaleLine(Point p1, Point p2, double sx, double sy, Graphics g) {
		Point pr1 = new Point();
		Point pr2 = new Point();
		pr1.x = (int) (p1.x * sx);
		pr1.y = (int) (p1.y * sy);
		pr2.x = (int) (p2.x * sx);
		pr2.y = (int) (p2.y * sy);
		g.drawLine(pr1.y, pr1.y, pr2.x, pr2.y);
	}
	
	public static void scaleRect(Point p, int w, int h, double sx, double sy, Graphics g) {
		Point rp = scalePoint(p, sx, sy);
		int rw = (int) (w * sx);
		int rh = (int) (h * sx);
		g.drawRect(p.x, p.y, rw, rh);
	}
	
	public static void scaleTri(Point p1, Point p2, Point p3, double sx, double sy, Graphics g)
	{
		Point rp1 = scalePoint(p1, sx, sy);
		Point rp2 = scalePoint(p2, sx, sy);
		Point rp3 = scalePoint(p3, sx, sy);
		g.drawLine(rp1.x,rp1.y,rp2.x,rp2.y);
		g.drawLine(rp2.x,rp2.y,rp3.x,rp3.y);
		g.drawLine(rp3.x,rp3.y,rp1.x,rp1.y);
	}

	public static void scaleCirc(Point c, int r, double sx, double sy, Graphics g)
	{
		Point rc = scalePoint(c, sx, sy);
		int rr = (int) (r * sy);
		Circle.midPoint(rc.x, rc.y, rr, g);
	}


	public static void scalePoly(Point points[], double sx, double sy, Graphics g)
	{
		for (int i = 0; i < points.length; i++) {
			points[i] = scalePoint(points[i], sx, sy);
		}
		for (int i = 0; i < points.length - 1; i++) {
			g.drawLine(points[i].x, points[i].y,points[i+1].x, points[i+1].y);
		}
		g.drawLine(points[0].x, points[0].y,points[points.length - 1].x, points[points.length - 1].y);
	}
}
