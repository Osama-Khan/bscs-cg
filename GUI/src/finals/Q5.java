package finals;

import java.awt.*;

public class Q5 {

	// Code format: RLAB
	// A = 0010, B = 0001, R = 1000, L = 0100

	private int regionCode(Point p, int xmin, int xmax, int ymin, int ymax) {
		int code = 0;

		if(p.x < xmin) {
			code = code | 4;
		} else if(p.x > xmax) {
			code = code | 8;
		}

		if(p.y < ymin) {
			code = code | 2;
		} else if(p.y > ymax) {
			code = code | 1;
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
				code1 = code2;
			}

			if ((code1 & 4) != 0) {
				p1.y += (p2.y - p1.y)*(xmin - p1.x)/(p2.x - p1.x);
				p1.x = xmin;
			} else if((code1 & 8) != 0) {
				p1.y += (p2.y - p1.y)*(xmax - p1.x)/(p2.x - p1.x);
				p1.x = xmax;
			} else if((code1 & 2) != 0) {
				p1.x += (p2.x - p1.x)*(ymin - p1.y)/(p2.y - p1.y);
				p1.y = ymin;
			} else if((code1 & 1) != 0) {
				p1.x += (p2.x - p1.x)*(ymax - p1.y)/(p2.y - p1.y);
				p1.y = ymax;
			}
		}
	}

	public boolean polyClipper(Point p[], int xmin, int xmax, int ymin, int ymax) {
		boolean isClipped = false;
		for (int i = 0; i < p.length - 1; i++) {
			boolean r = lineClipper(p[i], p[i+1], xmin, xmax, ymin, ymax);
			if (!isClipped && r) {
				isClipped = true;
			}
		}
		return isClipped;
	}

	//public List<Boolean> polyClipper(Point p[], int xmin, int xmax, int ymin, int ymax) {
	//		List<Boolean> isClipped = new ArrayList<>();
	//		for (int i = 0; i < p.length - 1; i++) {
	//			boolean r;
	//			if (i == p.length - 1)
	//				r = lineClipper(p[i], p[i+1], xmin, xmax, ymin, ymax);
	//			else
	//				r = lineClipper(p[i], new Point(p[i+1].x, p[i+1].y), xmin, xmax, ymin, ymax);
	//			System.out.println(p[i] + "," + p[i+1]);
	//			isClipped.add(r);
	//		}
	//		return isClipped;
	//	}
}