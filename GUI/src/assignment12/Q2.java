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

public class Q2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private final GLProfile profile = GLProfile.get(GLProfile.GL2);
	private final GLCapabilities cap = new GLCapabilities(profile);
	private final GLJPanel drawingPanel = new GLJPanel(cap);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Q2 frame = new Q2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Q2() {
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
				gl2.glBegin(GL2.GL_POINTS); // Part 1
				// gl2.glBegin(GL2.GL_LINES); // Part: 2
				// gl2.glBegin(GL2.GL_LINE_STRIP); // Part: 3
				// gl2.glBegin(GL2.GL_LINE_LOOP); // Part: 4
				// gl2.glBegin(GL2.GL_TRIANGLES); // Part: 5
				// gl2.glBegin(GL2.GL_TRIANGLE_STRIP); // Part: 6
				// gl2.glBegin(GL2.GL_TRIANGLE_FAN); // Part: 7
				// gl2.glBegin(GL2.GL_QUADS); // Part: 8
				// gl2.glBegin(GL2.GL_QUAD_STRIP); // Part: 9
				gl2.glVertex2d(-0.8,0.8);
				gl2.glVertex2d(0.8,0.8);
				gl2.glVertex2d(0.0, 0.2);
				gl2.glVertex2d(-0.8,-0.8);
				gl2.glVertex2d(0.8,-0.8);
				gl2.glVertex2d(0.0, -0.2);
				gl2.glEnd();				
			}
		});		
	}
}