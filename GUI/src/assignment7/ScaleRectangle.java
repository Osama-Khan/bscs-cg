package assignment7;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.FlowLayout;
import java.awt.Graphics;

public class ScaleRectangle extends JFrame {

	private JPanel contentPane;
	private JTextField txt_x;
	private JTextField txt_y;
	private JTextField txt_width;
	private JTextField txt_height;
	private JTextField txt_sx;
	private JTextField txt_sy;
	private JTextField txt_xpivot;
	private JTextField txt_ypivot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScaleRectangle frame = new ScaleRectangle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ScaleRectangle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_canvas = new JPanel();
		panel_canvas.setBackground(Color.WHITE);
		contentPane.add(panel_canvas, BorderLayout.CENTER);
		
		JPanel panel_inputs_container = new JPanel();
		contentPane.add(panel_inputs_container, BorderLayout.NORTH);
		panel_inputs_container.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_inputs_draw = new JPanel();
		panel_inputs_container.add(panel_inputs_draw);
		panel_inputs_draw.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("x");
		panel_inputs_draw.add(lblNewLabel);
		
		txt_x = new JTextField();
		txt_x.setColumns(10);
		panel_inputs_draw.add(txt_x);
		
		JLabel lblNewLabel_1 = new JLabel("y");
		panel_inputs_draw.add(lblNewLabel_1);
		
		txt_y = new JTextField();
		txt_y.setColumns(10);
		panel_inputs_draw.add(txt_y);
		
		JLabel lblNewLabel_2 = new JLabel("width");
		panel_inputs_draw.add(lblNewLabel_2);
		
		txt_width = new JTextField();
		txt_width.setColumns(10);
		panel_inputs_draw.add(txt_width);
		
		JLabel lblNewLabel_3 = new JLabel("height");
		panel_inputs_draw.add(lblNewLabel_3);
		
		txt_height = new JTextField();
		txt_height.setColumns(10);
		panel_inputs_draw.add(txt_height);
		
		JButton btn_draw = new JButton("Draw");
		panel_inputs_draw.add(btn_draw);
		
		JPanel panel_inputs_scale = new JPanel();
		panel_inputs_container.add(panel_inputs_scale, BorderLayout.SOUTH);
		
		JLabel lblSx = new JLabel("sx");
		panel_inputs_scale.add(lblSx);
		
		txt_sx = new JTextField();
		txt_sx.setColumns(10);
		panel_inputs_scale.add(txt_sx);
		
		JLabel lblNewLabel_1_1 = new JLabel("sy");
		panel_inputs_scale.add(lblNewLabel_1_1);
		
		txt_sy = new JTextField();
		txt_sy.setColumns(10);
		panel_inputs_scale.add(txt_sy);
		
		JLabel lblNewLabel_2_1 = new JLabel("xPivot");
		panel_inputs_scale.add(lblNewLabel_2_1);
		
		txt_xpivot = new JTextField();
		txt_xpivot.setColumns(10);
		panel_inputs_scale.add(txt_xpivot);
		
		JLabel lblNewLabel_3_1 = new JLabel("yPivot");
		panel_inputs_scale.add(lblNewLabel_3_1);
		
		txt_ypivot = new JTextField();
		txt_ypivot.setColumns(10);
		panel_inputs_scale.add(txt_ypivot);
		
		JButton btn_scale = new JButton("Scale");
		panel_inputs_scale.add(btn_scale);
	
		btn_draw.addActionListener(l -> {
			try {
				int x = Integer.parseInt(txt_x.getText());
				int y = Integer.parseInt(txt_y.getText());
				int w = Integer.parseInt(txt_width.getText());
				int h = Integer.parseInt(txt_height.getText());
				panel_canvas.getGraphics().drawRect(x, y, w, h);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Invalid inputs, please enter numbers");
			}
		});
		btn_scale.addActionListener(l -> {
			try {
				int x = Integer.parseInt(txt_x.getText());
				int y = Integer.parseInt(txt_y.getText());
				int w = Integer.parseInt(txt_width.getText());
				int h = Integer.parseInt(txt_height.getText());
				float sx = Float.parseFloat(txt_sx.getText());
				float sy = Float.parseFloat(txt_sy.getText());
				int xp = Integer.parseInt(txt_xpivot.getText());
				int yp = Integer.parseInt(txt_ypivot.getText());
				Point p = new Point(x - xp, y - yp);
				algos.transform.Scale.scaleRect(p, w, h, sx, sy, new Point(xp, yp), panel_canvas.getGraphics());
				
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Invalid inputs, please enter numbers");
			}
		});
	}
}
