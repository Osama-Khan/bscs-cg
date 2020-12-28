package assignment10;

import java.awt.Point;

public class Main {
	
	Point winToView(Point pw, Point vMin, Point vMax, Point wMin, Point wMax) {
		double sx = (double) (vMax.x - vMin.x) / (double) (wMax.x - wMin.x);
		double sy = (double) (vMax.y - vMin.y) / (double) (wMax.y - wMin.y);
		Point pv = new Point();
		pv.x = (int) (vMin.x + (pw.x - wMin.x)*sx);
		pv.y = (int) (vMin.y + (pw.y - wMin.y)*sy);
		return pv;
	}
	
	boolean clip(Point p, Point min, Point max) {
		return (min.x <= p.x && p.x <= max.x) && (min.y <= p.y && p.y <= max.y);
	}

	public static void main(String[] args) {
		
	}
}
