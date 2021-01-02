package algos;

import java.awt.Point;

public class CohenLineClipper {
	
	// code format: ABRL
	
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
	
	private boolean insideArea(int code1, int code2) {
		return (code1 == 0 & code2 == 0);
	}

	private boolean outsideArea(int code1, int code2) {
		return ((code1 & code2) != 0);
	}

	public boolean lineClipper(Point p1, Point p2, int xmin, int xmax, int ymin, int ymax) {
		int code1,code2;
		while(true) {
			code1 = regionCode(p1, xmin, xmax, ymin, ymax);
			code2 = regionCode(p2, xmin, xmax, ymin, ymax);
			if(outsideArea(code1, code2)) return false;
			if(insideArea(code1, code2)) return true;
		
			if(code1 == 0) {
				int temp = p1.x; p1.x = p2.x; p2.x = temp;
				temp = p1.y; p1.y = p2.y; p2.y = temp;
				temp = code1; code1 = code2; code2 = temp;
			}
		
			if ((code1 & 1) != 0) {
				p1.y += (p2.y - p1.y)*(xmin - p1.x)/(p2.x - p1.x);
				p1.x = xmin;
			} else if((code1 & 2) != 0) {
				p1.y += (p2.y - p1.y)*(xmax - p1.x)/(p2.x - p1.x);
				p1.x = xmax;
			} else if((code1 & 8) != 0) {
				p1.x += (p2.x - p1.x)*(ymin - p1.y)/(p2.y - p1.y);
				p1.y = ymin;
			} else if((code1 & 4) != 0) {
				p1.x += (p2.x - p1.x)*(ymax - p1.y)/(p2.y - p1.y);
				p1.y = ymax;
			}
		}
	}
}
