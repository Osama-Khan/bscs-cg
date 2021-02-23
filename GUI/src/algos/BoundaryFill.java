package algos;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BoundaryFill {
	public static void boundaryFill(Point p, int newColor, int boundaryColor, BufferedImage bi) {
		int curColor = bi.getRGB(p.x, p.y);
		if (boundaryColor != curColor && curColor != newColor) {
			bi.setRGB(p.x, p.y, newColor);
			boundaryFill(new Point(p.x + 1, p.y), newColor, boundaryColor, bi);
			boundaryFill(new Point(p.x - 1, p.y), newColor, boundaryColor, bi);
			boundaryFill(new Point(p.x, p.y + 1), newColor, boundaryColor, bi);
			boundaryFill(new Point(p.x, p.y - 1), newColor, boundaryColor, bi);			
			boundaryFill(new Point(p.x + 1, p.y + 1), newColor, boundaryColor, bi);
			boundaryFill(new Point(p.x - 1, p.y + 1), newColor, boundaryColor, bi);
			boundaryFill(new Point(p.x + 1, p.y - 1), newColor, boundaryColor, bi);
			boundaryFill(new Point(p.x - 1, p.y - 1), newColor, boundaryColor, bi);
		}
	}

	public static void boundaryFill1(Point p, int newColor, int boundaryColor, BufferedImage bi) {
		ArrayList<Point> array = new ArrayList<Point>();
		array.add(p);
		while (!array.isEmpty()) {
			int curColor = bi.getRGB(array.get(0).x, array.get(0).y);
			if (boundaryColor != curColor 
					&& curColor != newColor
					&& array.get(0).x > 0 && array.get(0).y > 0
					&& array.get(0).x < bi.getWidth() - 1 && array.get(0).y < bi.getHeight() - 1
					) {
				bi.setRGB(array.get(0).x, array.get(0).y, newColor);

				array.add(new Point(array.get(0).x + 1, array.get(0).y));
				array.add(new Point(array.get(0).x - 1, array.get(0).y));
				array.add(new Point(array.get(0).x, array.get(0).y + 1));
				array.add(new Point(array.get(0).x, array.get(0).y - 1));
				array.add(new Point(array.get(0).x + 1, array.get(0).y + 1));
				array.add(new Point(array.get(0).x - 1, array.get(0).y + 1));
				array.add(new Point(array.get(0).x + 1, array.get(0).y - 1));
				array.add(new Point(array.get(0).x - 1, array.get(0).y - 1));
			}
			array.remove(0);
		}
	}
}
