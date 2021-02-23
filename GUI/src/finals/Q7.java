package finals;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class Q7 extends JFrame {

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
        new Q7().setVisible(true);
    }

    public Q7() {
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
                v.put("v0", new V3(2, -1, 2));
                v.put("v1", new V3(2, -1, -2));
                v.put("v2", new V3(2, 1, -2));
                v.put("v3", new V3(2, 1, 2));
                v.put("v4", new V3(1.5, 1.5, 0))
                v.put("v5", new V3(-1.5, 1.5, 0)
                v.put("v6", new V3(-2, -1, 2));
                v.put("v7", new V3(-2, 1, 2));
                v.put("v8", new V3(-2, 1, -2));
                v.put("v9", new V3(-2, -1, -2));
                gl2.glEnable(GL2.GL_DEPTH_TEST);
                gl2.glLoadIdentity();
                gl2.glRotated(10, -1, 1, 0);
                final int plg = GL2.GL_POLYGON;
                gl2.glBegin(plg);
                v.get("v0").draw(gl2);
                v.get("v1").draw(gl2);
                v.get("v2").draw(gl2);
                v.get("v3").draw(gl2);
                gl2.glEnd();
                gl2.glBegin(plg);
                gl2.glColor3d(0.5, 0.7, 0.7);
                v.get("v0").draw(gl2);
                v.get("v1").draw(gl2);
                v.get("v9").draw(gl2);
                v.get("v6").draw(gl2);
                gl2.glEnd();
                gl2.glBegin(plg);
                gl2.glColor3d(0, 0, 1);
                v.get("v0").draw(gl2);
                v.get("v3").draw(gl2);
                v.get("v7").draw(gl2);
                v.get("v6").draw(gl2);
                gl2.glEnd();
                gl2.glBegin(plg);
                gl2.glColor3d(0, 1, 0);
                v.get("v1").draw(gl2);
                v.get("v2").draw(gl2);
                v.get("v8").draw(gl2);
                v.get("v9").draw(gl2);
                gl2.glEnd();
                gl2.glBegin(plg);
                gl2.glColor3d(0, 1, 1);
                v.get("v2").draw(gl2);
                v.get("v4").draw(gl2);
                v.get("v5").draw(gl2);
                v.get("v8").draw(gl2);
                gl2.glEnd();
                gl2.glBegin(plg);
                gl2.glColor3d(1, 0, 0);
                v.get("v3").draw(gl2);
                v.get("v4").draw(gl2);
                v.get("v5").draw(gl2);
                v.get("v7").draw(gl2);
                gl2.glEnd();
                gl2.glBegin(plg);
                gl2.glColor3d(1, 0, 1);
                v.get("v6").draw(gl2);
                v.get("v9").draw(gl2);
                v.get("v8").draw(gl2);
                v.get("v7").draw(gl2);
                gl2.glEnd();
                gl2.glBegin(plg);
                gl2.glColor3d(0.5, 0.5, 0.5);
                v.get("v2").draw(gl2);
                v.get("v4").draw(gl2);
                v.get("v3").draw(gl2);
                gl2.glEnd();
                gl2.glBegin(plg);
                gl2.glColor3d(1, 1, 0);
                v.get("v7").draw(gl2);
                v.get("v5").draw(gl2);
                v.get("v8").draw(gl2);
                gl2.glEnd();
            }

            @Override
            public void reshape(GLAutoDrawable draw, int i, int i1, int i2, int i3) {

            }
        });
    }

}
