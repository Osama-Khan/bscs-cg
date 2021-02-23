package finals;

import java.awt.*;

public class Q1 {
	public Point scalePoint(Point p, double sx, double sy) {
		Point pr = new Point();
		pr.x = (int) (p.x * sx);
		pr.y = (int) (p.y * sy);
		return pr;
	}

	public void draw(Point p1, Point p2, double sx, double sy, Graphics g) {
		p1 = scalePoint(p1, sx, sy);
		p2 = scalePoint(p2, sx, sy);
		int dx = p2.x - p1.x,
				dy = p2.y - p1.y,
				p,
				x,
				y,
				end;
		float m = (float) dy/(float) dx;
		if (m < 1 && m >= 0) {
			p = 2*dy + dx;
			if (p1.x > p2.x) {
				x = p2.x;
				y = p2.y;
				end = p1.x;
			} else {
				x = p1.x;
				y = p1.y;
				end = p2.x;
			}
			g.drawString(".", x, y);
			while (x < end) {
				if (p < 0) {
					p = p + 2 * dx - 2 * dy;
					y++;
				} else {
					p = p - 2 * dy;
				}
				x++;
				g.drawString(".", x, y);
			}
		} else if (m > -1 && m < 0) {
			p = 2*-dy + dx;
			if (p1.x > p2.x) {
				x = p2.x;
				y = p2.y;
				end = p1.x;
			} else {
				x = p1.x;
				y = p1.y;
				end = p2.x;
			}
			g.drawString(".", x, y);
			while (x < end) {
				if (p < 0) {
					p = p + 2 * dx - 2 * -dy;
					y--;
				} else {
					p = p - 2 * -dy;
				}
				x++;
				g.drawString(".", x, y);
			}
		} else if (m <= -1) {
			p = 2*-dy + dx;
			if (p1.y > p2.y) {
				x = p2.x;
				y = p2.y;
				end = p1.y;
			} else {
				x = p1.x;
				y = p1.y;
				end = p2.y;
			}
			g.drawString(".", x, y);
			while (y < end) {
				if (p < 0) {
					p = p - 2 * dy - 2 * dx;
					x--;
				} else {
					p = p - 2 * dx;
				}
				y++;
				g.drawString(".", x, y);
			}
		} else if (m >= 1) {
			p = 2*dy - dx;
			if (p1.y > p2.y) {
				x = p2.x;
				y = p2.y;
				end = p1.y;
			} else {
				x = p1.x;
				y = p1.y;
				end = p2.y;
			}
			g.drawString(".", x, y);
			while (y < end) {
				if (p < 0) {
					p = p + 2 * dy - 2 * dx;
					x++;
				} else {
					p = p - 2 * dx;
				}
				y++;
				g.drawString(".", x, y);
			}
		}
	}
}