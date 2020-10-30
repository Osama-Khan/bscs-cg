package lab5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Task {

	private JFrame frame;
	private JTextField txt_x1;
	private JTextField txt_y1;
	private JTextField txt_x2;
	private JTextField txt_y2;
	private JLabel lbl_x1;
	private JLabel lbl_y1;
	private JButton btn_draw;
	private JLabel lbl_x2;
	private JLabel lbl_y2;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Task window = new Task();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Task() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_in = new JPanel();
		frame.getContentPane().add(panel_in, BorderLayout.NORTH);
		
		txt_x1 = new JTextField();
		txt_x1.setColumns(10);
		panel_in.setLayout(new GridLayout(2, 5, 5, 5));
		
		lbl_x1 = new JLabel("x1");
		lbl_x1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_in.add(lbl_x1);
		panel_in.add(txt_x1);
		
		lbl_y1 = new JLabel("y1");
		lbl_y1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_in.add(lbl_y1);
		
		txt_y1 = new JTextField();
		txt_y1.setColumns(10);
		panel_in.add(txt_y1);
		
		lblNewLabel = new JLabel("");
		panel_in.add(lblNewLabel);
		
		lbl_x2 = new JLabel("x2");
		lbl_x2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_in.add(lbl_x2);
		
		txt_x2 = new JTextField();
		txt_x2.setColumns(10);
		panel_in.add(txt_x2);
		
		lbl_y2 = new JLabel("y2");
		lbl_y2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_in.add(lbl_y2);
		
		txt_y2 = new JTextField();
		txt_y2.setColumns(10);
		panel_in.add(txt_y2);
		
		btn_draw = new JButton("Draw");
		panel_in.add(btn_draw);
		
		JPanel panel_out = new JPanel();
		
		btn_draw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int x1 = Integer.parseInt(txt_x1.getText());
				int x2 = Integer.parseInt(txt_x2.getText());
				int y1 = Integer.parseInt(txt_y1.getText());
				int y2 = Integer.parseInt(txt_y2.getText());
				algos.DDALine.draw(x1, y1, x2, y2, panel_out.getGraphics());
			}


		});
		frame.getContentPane().add(panel_out, BorderLayout.CENTER);
	}
}
