package finals;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class Q8 extends JFrame {

    /*
     * Problem:
     * Create a house using JOGL.
     */
    private class V3 {
        double x, y, z;

        V3(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        void draw(GL2 gl2) {
            gl2.glVertex3d(x / 3, y / 3, z / 3);
        }
    }

    GLProfile profile = GLProfile.get(GLProfile.GL2);
    GLCapabilities cap = new GLCapabilities(profile);
    GLJPanel canvas = new GLJPanel(cap);

    public static void main(String[] args) {
        new Q8().setVisible(true);
    }

    public Q8() {
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

            }

            @Override
            public void dispose(GLAutoDrawable draw) {

            }

            @Override
            public void display(GLAutoDrawable draw) {
                GL2 gl2 = draw.getGL().getGL2();
                Dictionary<String, V3> v = new Hashtable<>();
                v.put("A", new V3( 0.0,  0.5,  0.0));
                v.put("B", new V3(-0.5,  0.0,  0.0));
                v.put("C", new V3( 0.0, -0.5,  0.0));
                v.put("D", new V3( 0.5,  0.0,  0.0));
                v.put("E", new V3( 0.0,  0.0, -0.5));
                v.put("F", new V3( 0.0,  0.0,  0.5));
                gl2.glEnable(GL2.GL_DEPTH_TEST);
                gl2.glLoadIdentity();
                gl2.glRotated(10, -1, 1, 0);
                final int trf = GL2.GL_TRIANGLE_FAN;
                gl2.glBegin(trf);
                v.get("A").draw(gl2);
                v.get("E").draw(gl2);
                v.get("D").draw(gl2);
                v.get("F").draw(gl2);
                v.get("B").draw(gl2);
                v.get("E").draw(gl2);
                gl2.glEnd();
                gl2.glBegin(trf);
                v.get("C").draw(gl2);
                v.get("E").draw(gl2);
                v.get("D").draw(gl2);
                v.get("F").draw(gl2);
                v.get("B").draw(gl2);
                v.get("E").draw(gl2);
                gl2.glEnd();
            }

            @Override
            public void reshape(GLAutoDrawable draw, int i, int i1, int i2, int i3) {

            }
        });
    }

}
