package assignment11;

import java.awt.Point;
import java.util.ArrayList;

public class Q2 {

	// Q: Create a JAVA method to clip a polygon using Cohen Sutherland Line Clipping algorithm.
	
	private int regionCode(Point p, int xmin, int xmax, int ymin, int ymax) {
		int code = 0;
		
		if(p.x < xmin) {
			code = code | 1;
		} else if(p.x > xmax) {
			code = code | 2;
		}
		
		if(p.y < ymin) {
			code = code | 8;
		} else if(p.y > ymax) {
			code = code | 4;
		}
		
		return code;
	}
	
	private boolean insideArea(int[] codes) {
		for (int i = 1; i < codes.length; i++) {
			if (codes[i] == 0 & codes[i - 1] != 0)
				return false;
		}
		return true;
	}

	private boolean outsideArea(int[] codes) {
		for (int i = 1; i < codes.length; i++) {
			if ((codes[i] & codes[i - 1]) == 0)
				return false;
		}
		return true;
	}
	
	public boolean lineClipper(Point[] points, int xmin, int xmax, int ymin, int ymax) {
		boolean isClipped = false;
		for (int i = 0; i < points.length - 1; i++) {
			boolean r = new algos.CohenLineClipper().lineClipper(points[i], points[i + 1], xmin, xmax, ymin, ymax);
			if (!isClipped && r) {
				isClipped = true;
			}
		}
		return isClipped;
		
		/*int[] codes = new int[points.length];
		while(true) {
			for (int i = 0; i < points.length; i++) {
				codes[i] = regionCode(points[i], xmin, xmax, ymin, ymax);
			}
			
			if(outsideArea(codes)) return false;
			if(insideArea(codes)) return true;
		
			for (int i = 0; i < points.length - 1; i++) {
				if (codes[i] == 0) {
					int tmp = points[i].x; points[i].x = points[i+1].x; points[i+1].x = tmp;
					tmp = points[i].y; points[i].y = points[i+1].y; points[i+1].y = tmp;
					tmp = codes[i]; codes[i] = codes[i+1]; codes[i+1] = tmp;
				}
			}
		
			for (int i = 0; i < points.length - 1; i++) {
				if ((codes[i] & 1) != 0) {
					points[i].y += (points[i+1].y - points[i].y)*(xmin - points[i].x)/(points[i+1].x - points[i].x);
					points[i].x = xmin;
				} else if((codes[i] & 2) != 0) {
					points[i].y += (points[i+1].y - points[i].y)*(xmax - points[i].x)/(points[i+1].x - points[i].x);
					points[i].x = xmax;
				} else if((codes[i] & 8) != 0) {
					points[i].x += (points[i+1].x - points[i].x)*(ymin - points[i].y)/(points[i+1].y - points[i].y);
					points[i].y = ymin;
				} else if((codes[i] & 4) != 0) {
					points[i].x += (points[i+1].x - points[i].x)*(ymax - points[i].y)/(points[i+1].y - points[i].y);
					points[i].y = ymax;
				}
			}
		}*/
	}
}
