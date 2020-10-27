package Lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * DRAW AN ANIMATED Hourglass-ish shape idk 
 */
public class LabTask extends JFrame{
	
	public int x = 100;
	public int y = 100;
	public int step = 0;
	
	public JPanel panel;
	
	public LabTask() {
		panel = new JPanel() {
			public void paint(java.awt.Graphics g) {
				g.drawString("___", x, y);
			};
		};
		
		Timer t = new Timer(10, new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.repaint();
				if (step == 0) {
					x++;
					y++;
					if (x == 300 || y == 300) {
						step++;
					}
				} else if (step == 1) {
					x--;
					if (x == 100) {
						step++;
					}
				} else if (step == 2) {
					x++;
					y--;
					if (x == 300 || y == 100) {
						step++;
					}
				} else if (step == 3) {
					x--;
					if (x == 100) {
						step++;
					}
				}
			}
		});
		this.getContentPane().add(panel);
		setVisible(true);
		setTitle("Animated Hourglass");
		setSize(500, 500);
		t.start();
	}
	
	public static void main(String[] args) {
		new LabTask();
	}
}
