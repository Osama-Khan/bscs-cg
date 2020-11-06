package algos;

import java.awt.Graphics;

public class BresenhamLine {
    public void draw(int x1, int y1, int x2, int y2, Graphics g) {
        int dx = x2 - x1,
            dy = y2 - y1,
            p,
            x,
            y,
            end;
        float m = (float) dy/(float) dx;
        if (m < 1 && m >= 0) {
        	p = 2*dy + dx;
        	if (x1 > x2) {
        		x = x2;
        		y = y2;
        		end = x1;
        	} else {
        		x = x1;
        		y = y1;
        		end = x2;
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
        	if (x1 > x2) {
        		x = x2;
        		y = y2;
        		end = x1;
        	} else {
        		x = x1;
        		y = y1;
        		end = x2;
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
        	if (y1 > y2) {
        		x = x2;
        		y = y2;
        		end = y1;
        	} else {
        		x = x1;
        		y = y1;
        		end = y2;
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
        	if (y1 > y2) {
        		x = x2;
        		y = y2;
        		end = y1;
        	} else {
        		x = x1;
        		y = y1;
        		end = y2;
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