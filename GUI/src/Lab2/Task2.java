package lab2;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Task2 extends JFrame {
	private JPanel outputPanel;
	private JPanel inputPanel;
	private JTextField txt_input_str;
	private JTextField txt_input_num;
	
	public void printText(Graphics g) {
		Random r = new Random();
		for (int i = 0; i < Integer.parseInt(txt_input_num.getText()); i++) {
			int x = r.nextInt(outputPanel.getWidth());
			int y = r.nextInt(outputPanel.getHeight());
			g.drawString(txt_input_str.getText(), x, y);
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task2 window = new Task2();
					window.setVisible(true);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
	public Task2() {
		txt_input_str = new JTextField(10);
		txt_input_num = new JTextField(10);
		JLabel label1 = new JLabel("Text");
		JLabel label2 = new JLabel("Number");
		
		inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());
		inputPanel.add(label1);
		inputPanel.add(txt_input_str);
		inputPanel.add(label2);
		inputPanel.add(txt_input_num);
		
		outputPanel = new JPanel();
		outputPanel.setLayout(null);
		
		setTitle("Basic Window");
		setSize(500, 500);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(inputPanel, BorderLayout.NORTH);
		getContentPane().add(outputPanel, BorderLayout.CENTER);
		outputPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Graphics g = outputPanel.getGraphics();
				printText(g);
			}
		});
	}
	
	
}
