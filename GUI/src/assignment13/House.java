package assignment13;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class House extends JFrame {

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
        new House().setVisible(true);
    }

    public House() {
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
                V3[] v = new V3[] {
                        new V3(2, -1, 2),
                        new V3(2, -1, -2),
                        new V3(2, 1, -2),
                        new V3(2, 1, 2),
                        new V3(1.5, 1.5, 0),
                        new V3(-1.5, 1.5, 0),
                        new V3(-2, -1, 2),
                        new V3(-2, 1, 2),
                        new V3(-2, 1, -2),
                        new V3(-2, -1, -2),
                };
                gl2.glEnable(GL2.GL_DEPTH_TEST);
                gl2.glLoadIdentity();
                gl2.glRotated(10, -1, 1, 0);
                gl2.glBegin(GL2.GL_POLYGON);
                v[0].draw(gl2);
                v[1].draw(gl2);
                v[2].draw(gl2);
                v[3].draw(gl2);
                gl2.glEnd();
                gl2.glBegin(GL2.GL_POLYGON);
                gl2.glColor3d(0.5, 0.7, 0.7);
                v[0].draw(gl2);
                v[1].draw(gl2);
                v[9].draw(gl2);
                v[6].draw(gl2);
                gl2.glEnd();
                gl2.glBegin(GL2.GL_POLYGON);
                gl2.glColor3d(0, 0, 1);
                v[0].draw(gl2);
                v[3].draw(gl2);
                v[7].draw(gl2);
                v[6].draw(gl2);
                gl2.glEnd();
                gl2.glBegin(GL2.GL_POLYGON);
                gl2.glColor3d(0, 1, 0);
                v[1].draw(gl2);
                v[2].draw(gl2);
                v[8].draw(gl2);
                v[9].draw(gl2);
                gl2.glEnd();
                gl2.glBegin(GL2.GL_POLYGON);
                gl2.glColor3d(0, 1, 1);
                v[2].draw(gl2);
                v[4].draw(gl2);
                v[5].draw(gl2);
                v[8].draw(gl2);
                gl2.glColor3d(1, 0, 0);
                v[3].draw(gl2);
                v[4].draw(gl2);
                v[5].draw(gl2);
                v[7].draw(gl2);
                gl2.glColor3d(1, 0, 1);
                v[6].draw(gl2);
                v[9].draw(gl2);
                v[8].draw(gl2);
                v[7].draw(gl2);
                gl2.glColor3d(0.5, 0.5, 0.5);
                v[2].draw(gl2);
                v[4].draw(gl2);
                v[3].draw(gl2);
                gl2.glEnd();
                gl2.glBegin(GL2.GL_POLYGON);
                gl2.glColor3d(1, 1, 0);
                v[7].draw(gl2);
                v[5].draw(gl2);
                v[8].draw(gl2);
                gl2.glEnd();
            }

            @Override
            public void reshape(GLAutoDrawable draw, int i, int i1, int i2, int i3) {

            }
        });
    }

}
