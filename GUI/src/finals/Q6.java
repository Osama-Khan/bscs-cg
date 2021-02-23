package finals;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class Q6 extends JFrame {
	// Vertices Dictionary
	Dictionary<String, V3> v;

	private static class V3 {
		double x, y, z;

		V3(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		void draw(GL2 gl2) {
			gl2.glVertex3d(x / 9, y / 9, z / 9);
		}
	}

	GLProfile profile = GLProfile.get(GLProfile.GL2);
	GLCapabilities cap = new GLCapabilities(profile);
	GLJPanel canvas = new GLJPanel(cap);

	public static void main(String[] args) {
		new Q6().setVisible(true);
	}

	public Q6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		canvas.setBounds(0, 0, 600, 600);
		contentPane.add(canvas);
		canvas.addGLEventListener(new GLEventListener() {
			@Override
			public void init(GLAutoDrawable draw) {
				v = new Hashtable<>();
				v.put("O", new V3(0.00, 8.00, 0.00));
				v.put("A", new V3(-5.00, 0.00, 0.00));
				v.put("B", new V3(-2.50, 0.00, 4.33));
				v.put("C", new V3(2.50, 0.00, 4.33));
				v.put("D", new V3(5.00, 0.00, 0.00));
				v.put("E", new V3(2.50, 0.00, -4.33));
				v.put("F", new V3(-2.50, 0.00, -4.33));
			}

			@Override
			public void dispose(GLAutoDrawable draw) {

			}

			@Override
			public void display(GLAutoDrawable draw) {
				GL2 gl2 = draw.getGL().getGL2();
				gl2.glEnable(GL2.GL_DEPTH_TEST);
				gl2.glLoadIdentity();
				gl2.glRotated(10, -1, 1, 0);
				drawHexagonalPyramid(gl2);
			}

			@Override
			public void reshape(GLAutoDrawable draw, int i, int i1, int i2, int i3) {

			}
		});


	}

	void drawHexagonalPyramid(GL2 gl2) {
		gl2.glBegin(GL2.GL_TRIANGLE_FAN);
		v.get("O").draw(gl2);
		v.get("A").draw(gl2);
		v.get("B").draw(gl2);
		v.get("C").draw(gl2);
		v.get("D").draw(gl2);
		v.get("E").draw(gl2);
		v.get("F").draw(gl2);
		v.get("A").draw(gl2);
		gl2.glEnd();
	}
}