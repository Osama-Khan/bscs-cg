package assignment12;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

public class Q1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GLProfile profile = GLProfile.get(GLProfile.GL2);
	private GLCapabilities cap = new GLCapabilities(profile);
	private GLJPanel drawingPanel = new GLJPanel(cap);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Q1 frame = new Q1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Q1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		drawingPanel.setBounds(0, 0, 800, 600);
		contentPane.add(drawingPanel);
		drawingPanel.addGLEventListener(new GLEventListener() {
			
			@Override
			public void reshape(GLAutoDrawable draw, int x, int y, int width, int height) {}
			
			@Override
			public void init(GLAutoDrawable draw) {}
			
			@Override
			public void dispose(GLAutoDrawable draw) {}
			
			@Override
			public void display(GLAutoDrawable draw) {
				GL2 gl2 = draw.getGL().getGL2();
				gl2.glBegin(GL2.GL_LINES);
				gl2.glVertex2d(0, 0);
				gl2.glVertex2d(1, 0);
				gl2.glEnd();				
			}
		});		
	}
}