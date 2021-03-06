package algos.transform;

import java.awt.Graphics;
import java.awt.Point;

import algos.Circle;

public class Rotate {
	
	public static Point rotatePoint(Point p , double degAngle)
	{
		double radAngle = Math.toRadians(degAngle); // Convert to Degree to Radian
		double sin = Math.sin(radAngle);//Sine method of Math class only use Radian value
		double cos = Math.cos(radAngle); //Cos method of Math class only use Radian value
		
		int xDash = (int)(p.x * cos - p.y * sin);
		int yDash = (int)(p.x * sin + p.y * cos);
		
		Point pDash = new Point(xDash, yDash);
		return pDash;
	}
	
	/* Rotate around pivot */
	public static Point rotatePoint(Point p, Point pivot, double degAngle)
	{
		double rad = Math.toRadians(degAngle);
		double sin = Math.sin(rad);
		double cos = Math.cos(rad);
		int xDash = (int)(pivot.x + (p.x - pivot.x )* cos - (p.y - pivot.y) * sin);
		int yDash = (int)(pivot.y + (p.x - pivot.x) * sin + (p.y - pivot.y) * cos);
		Point pDash = new Point(xDash, yDash);
		return pDash;
	}
	
	public static void rotateLine(Point p1, Point p2 , double degAngle, Graphics g)
	{
		Point rp1 = rotatePoint(p1,degAngle);
		Point rp2 = rotatePoint(p2,degAngle);
		g.drawLine(rp1.x,rp1.y,rp2.x,rp2.y);
	}

	public static void rotateRect(Point p, int w, int h, double degAngle, Graphics g)
	{
		Point p2 = new Point(p.x + w, p.y);
		Point p3 = new Point(p.x + w, p.y + h);
		Point p4 = new Point(p.x, p.y + h);
		Point rp1 = rotatePoint(p,degAngle);
		Point rp2 = rotatePoint(p2,degAngle);
		Point rp3 = rotatePoint(p3,degAngle);
		Point rp4 = rotatePoint(p4,degAngle);
		g.drawLine(rp1.x,rp1.y,rp2.x,rp2.y);
		g.drawLine(rp2.x,rp2.y,rp3.x,rp3.y);
		g.drawLine(rp3.x,rp3.y,rp4.x,rp4.y);
		g.drawLine(rp4.x,rp4.y,rp1.x,rp1.y);
	}

	public static void rotateTri(Point p1, Point p2, Point p3, double degAngle, Graphics g)
	{
		Point rp1 = rotatePoint(p1,degAngle);
		Point rp2 = rotatePoint(p2,degAngle);
		Point rp3 = rotatePoint(p3,degAngle);
		g.drawLine(rp1.x,rp1.y,rp2.x,rp2.y);
		g.drawLine(rp2.x,rp2.y,rp3.x,rp3.y);
		g.drawLine(rp3.x,rp3.y,rp1.x,rp1.y);
	}

	public static void rotateCirc(Point c, int r, double degAngle, Graphics g)
	{
		Point rc = rotatePoint(c, degAngle);
		Circle.midPoint(rc.x, rc.y, r, g);
	}


	public static void rotatePoly(Point points[], double degAngle, Graphics g)
	{
		for (int i = 0; i < points.length; i++) {
			points[i] = rotatePoint(points[i], degAngle);
		}
		for (int i = 0; i < points.length - 1; i++) {
			g.drawLine(points[i].x, points[i].y,points[i+1].x, points[i+1].y);
		}
		g.drawLine(points[0].x, points[0].y,points[points.length - 1].x, points[points.length - 1].y);
	}
}
