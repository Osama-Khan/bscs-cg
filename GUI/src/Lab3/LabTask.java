package Lab3;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class LabTask {

	private JFrame frame;
	private JTextField txt_text;
	private JTextField txt_num;
	private JTextField txt_size;
	private JTextField txt_r;
	private JTextField txt_g;
	private JTextField txt_b;
	private JPanel outputPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabTask window = new LabTask();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LabTask() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel inputPanel = new JPanel();
		frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
		
		txt_text = new JTextField("Hello World");
		inputPanel.add(txt_text);
		txt_text.setColumns(10);
		
		txt_num = new JTextField("5");
		inputPanel.add(txt_num);
		txt_num.setColumns(10);
		
		txt_size = new JTextField("24");
		inputPanel.add(txt_size);
		txt_size.setColumns(10);
		
		txt_r = new JTextField("200");
		inputPanel.add(txt_r);
		txt_r.setColumns(10);
		
		txt_g = new JTextField("200");
		inputPanel.add(txt_g);
		txt_g.setColumns(10);
		
		txt_b = new JTextField("200");
		inputPanel.add(txt_b);
		txt_b.setColumns(10);
		
		outputPanel = new JPanel();
		outputPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gen(outputPanel.getGraphics());
			}
		});
		frame.getContentPane().add(outputPanel, BorderLayout.CENTER);
	}
	
	private void gen(Graphics g) {
		String text = "Hello world";
		int number = 3;
		int size = 24;
		int red = 200;
		int grn = 200;
		int blu = 200;		
		
		if (txt_text.getText().trim() != "" ) {
			text = txt_text.getText();
		}
		try {
			number = Integer.parseInt(txt_num.getText());
			if (number <= 0) number = 3;
			size = Integer.parseInt(txt_size.getText());
			if (size <= 0) size = 24;
			red = Integer.parseInt(txt_r.getText());
			if (red < 0) red = 200;
			grn = Integer.parseInt(txt_g.getText());
			if (grn < 0) grn = 200;
			blu = Integer.parseInt(txt_b.getText());
			if (blu < 0) blu = 200;
		} catch (Exception ex) {
			
		}
		
		g.setFont(new Font("Dialog", Font.PLAIN, size));
		g.setColor(new Color(red,grn,blu));
		for (int i = 0; i < number; i++) {
			Random r = new Random();
			int x = r.nextInt(outputPanel.getWidth());
			int y = r.nextInt(outputPanel.getHeight());
			g.drawString(text, x, y);
		}
	}

}
