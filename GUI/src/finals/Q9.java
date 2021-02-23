package finals;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import javax.swing.*;
import java.io.File;

public class Q9 extends JFrame {

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
    Texture t;

    public static void main(String[] args) {
        new Q9().setVisible(true);
    }

    public Q9() {
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
                t = addTexture("E:\\Uni\\6th Sem\\CG\\Workspace\\GUI\\src\\finals\\octaTex.png");
            }

            @Override
            public void dispose(GLAutoDrawable draw) {

            }

            @Override
            public void display(GLAutoDrawable draw) {
                GL2 gl2 = draw.getGL().getGL2();
                V3[] v = {
                        new V3( 0.0,  0.5,  0.0), // A
                        new V3(-0.5,  0.0,  0.0), // B
                        new V3( 0.0, -0.5,  0.0), // C
                        new V3( 0.5,  0.0,  0.0), // D
                        new V3( 0.0,  0.0, -0.5), // E
                        new V3( 0.0,  0.0,  0.5), // F
                };
                double[] ver = {
                        v[0].x, v[0].y, v[0].z, // A
                        v[4].x, v[4].y, v[4].z, // E
                        v[3].x, v[3].y, v[3].z, // D

                        v[0].x, v[0].y, v[0].z, // A
                        v[3].x, v[3].y, v[3].z, // D
                        v[5].x, v[5].y, v[5].z, // F

                        v[0].x, v[0].y, v[0].z, // A
                        v[5].x, v[5].y, v[5].z, // F
                        v[1].x, v[1].y, v[1].z, // B

                        v[0].x, v[0].y, v[0].z, // A
                        v[1].x, v[1].y, v[1].z, // B
                        v[4].x, v[4].y, v[4].z, // E

                        v[2].x, v[2].y, v[2].z, // C
                        v[4].x, v[4].y, v[4].z, // E
                        v[1].x, v[1].y, v[1].z, // B

                        v[2].x, v[2].y, v[2].z, // C
                        v[1].x, v[1].y, v[1].z, // B
                        v[5].x, v[5].y, v[5].z, // F

                        v[2].x, v[2].y, v[2].z, // C
                        v[5].x, v[5].y, v[5].z, // F
                        v[3].x, v[3].y, v[3].z, // D

                        v[2].x, v[2].y, v[2].z, // C
                        v[3].x, v[3].y, v[3].z, // D
                        v[4].x, v[4].y, v[4].z, // E
                };
                double[] tx = {
                        0.00, 0.25,
                        0.25, 0.50,
                        0.50, 0.25,
                        0.75, 0.00,
                        1.00, 0.25,
                        0.50, 0.25,
                        1.00, 0.25,
                        0.75, 0.50,
                        0.50, 0.25,
                        0.50, 0.25,
                        0.75, 0.50,
                        0.25, 0.50,
                        0.50, 0.75,
                        0.25, 0.50,
                        0.75, 0.50,
                        0.00, 0.75,
                        0.50, 0.75,
                        0.25, 0.50,
                        1.00, 0.75,
                        0.75, 0.50,
                        0.50, 0.75,
                        0.75, 1.00,
                        1.00, 0.75,
                        0.50, 0.75,
                };
                gl2.glEnable(GL2.GL_DEPTH_TEST);
                gl2.glLoadIdentity();
                t.enable(gl2);
                t.bind(gl2);
                gl2.glBegin(GL2.GL_TRIANGLES);
                for (int i = 0; i < ver.length / 3; i++) {
                    gl2.glTexCoord2dv(tx, i * 2);
                    gl2.glVertex3dv(ver, i * 3);
                }
                gl2.glEnd();
            }

            @Override
            public void reshape(GLAutoDrawable draw, int i, int i1, int i2, int i3) {

            }
        });
    }

    public Texture addTexture(String path) {
        try {
            return TextureIO.newTexture(new File(path), true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
