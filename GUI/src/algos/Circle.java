package algos;

import java.awt.Graphics;

public class Circle {
	public void midPoint(int xc, int yc, int radius, Graphics g)
	{
		int x = 0, y = radius;
		int p = 1 - radius; 
		octantRule(x, y, xc, yc, g); 
		while(x<y) { 
			x++;
			if(p<0) 
			{
				p = p + 2 * x + 1;
			}
			else 
			{
				y--;
				p = p + 2 * (x - y) + 1;
			}
			octantRule(x, y, xc, yc, g);
		}
	}

	public void octantRule(int x, int y, int xc, int yc, Graphics g) {
		g.drawString(".", xc + y, yc + x);
		g.drawString(".", xc + x, yc + y);
		g.drawString(".", xc - x, yc + y);
		g.drawString(".", xc - y, yc + x);
		g.drawString(".", xc - x, yc - y);
		g.drawString(".", xc - y, yc - x);
		g.drawString(".", xc + x, yc - y);
		g.drawString(".", xc + y, yc - x);
	}
}
