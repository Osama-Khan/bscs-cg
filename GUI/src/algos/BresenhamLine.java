package algos;

import java.awt.Color;
import java.awt.Graphics;

public class BresenhamLine {
    public void draw(int x1, int y1, int x2, int y2, Graphics g) {
        int dx = x2 - x1,
            dy = y2 - y1,
            p,
            x,
            y,
            xEnd;
        float m = (float) dy/(float) dx;
        g.setColor(new Color(255,255,0));
        g.fillRect(350, 380, 450, 420);
        g.setColor(new Color(0,0,0));
        g.drawString(m + " - " + dy + "/" + dx, 360, 400);
        if (m < 1 && m >= 0) {
        	p = 2*dy + dx;
        	if (x1 > x2) {
        		x = x2;
        		y = y2;
        		xEnd = x1;
        	} else {
        		x = x1;
        		y = y1;
        		xEnd = x2;
        	}
        	g.drawString(".", x, y);
        	while (x < xEnd) {
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
        	if (x2 > x1) {
        		x = x1;
        		y = y1;
        		xEnd = x2;
        	} else {
        		x = x2;
        		y = y2;
        		xEnd = x1;
        	}
        	g.drawString(".", x, y);
        	while (x < xEnd) {
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
        	
        } else if (m >= 1) {
        	
        }
    }
}