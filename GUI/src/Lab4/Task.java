package Lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Task extends JFrame {
	JPanel panel;
	Timer animTimer;
	
	int currentX = 0;
	
	public void stopAnim() {
		animTimer.stop();
	}
	
	void anim() {
		Graphics g = panel.getGraphics();
		Task frame = this;
		animTimer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.paint(g);
				g.drawString("**********", currentX++, panel.getHeight()/2);
				if (currentX > panel.getWidth() - 100) {
					frame.stopAnim();
				}
			}
		});
		animTimer.start();
	}
	
	Task() {
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				anim();
			}
		});
		
		getContentPane().add(panel);
		setTitle("Animate 10 *");
		setSize(500, 500);		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Task();
	}
}
