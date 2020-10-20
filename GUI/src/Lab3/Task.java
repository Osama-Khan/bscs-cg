package Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Task extends JFrame {
	
	JPanel panel;
	
	void createText(Graphics g) {
		final Random r = new Random();
		final int x = r.nextInt(panel.getWidth());
		final int y = r.nextInt(panel.getHeight());
		final int red = r.nextInt(255);
		final int green = r.nextInt(255);
		final int blue = r.nextInt(255);
		final int size = r.nextInt(6) + 6;
		final Font font = new Font("Dialog", Font.BOLD, size);
		final Color color = new Color(red, blue, green);
		
		g.setFont(font);
		g.setColor(color);
		g.drawString("Randomized Text", x, y);
	}
	
	Task() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Graphics g = panel.getGraphics();
				createText(g);
			}
		});
		
		
		setSize(500, 500);
		getContentPane().add(panel);
	}
	
	public static void main(String[] args) {
		new Task().setVisible(true);;
	}
}
