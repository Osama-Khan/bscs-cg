package lab2;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Task extends JFrame {
	private JPanel panel;
	
	public void printasterisk(Graphics g) {
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int x = r.nextInt(panel.getWidth());
			int y = r.nextInt(panel.getHeight());
			g.drawString("*", x, y);
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task window = new Task();
					window.setVisible(true);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
	public Task() {
		setTitle("Basic Window");
		setSize(500, 500);
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Graphics g = panel.getGraphics();
				printasterisk(g);
			}
		});
	}
	
	
}
