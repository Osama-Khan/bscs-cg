package assignment15;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class TextureCube extends JFrame {
    final String basePath = new File("").getAbsolutePath();

    GLProfile profile = GLProfile.get(GLProfile.GL2);
    GLCapabilities cap = new GLCapabilities(profile);
    GLJPanel drawingPanel = new GLJPanel(cap);
    FPSAnimator animator = new FPSAnimator(drawingPanel, 60);
    Texture t;
    GLU glu = new GLU();
    double rot = 0.0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TextureCube frame = new TextureCube();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TextureCube() {
        animator.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        drawingPanel.setBounds(10, 10, 776, 543);
        drawingPanel.addGLEventListener(new GLEventListener() {

            @Override
            public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
                final GL2 gl = drawable.getGL().getGL2();
                if (height <= 0)
                    height = 1;
                final float h = (float) width / (float) height;
                gl.glViewport(0, 0, width, height);
                gl.glMatrixMode(GL2.GL_PROJECTION);
                gl.glLoadIdentity();
                glu.gluPerspective(45.0f, h, 1.0, 20.0);
                gl.glMatrixMode(GL2.GL_MODELVIEW);
                gl.glLoadIdentity();
            }

            @Override
            public void init(GLAutoDrawable draw) {
                GL2 gl2 = draw.getGL().getGL2();
                gl2.glShadeModel(GL2.GL_SMOOTH);
                gl2.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                gl2.glClearDepth(1.0f);
                gl2.glEnable(GL2.GL_DEPTH_TEST);
                gl2.glDepthFunc(GL2.GL_LEQUAL);
                gl2.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

                t = addTexture( basePath + "\\src\\assignment15\\texture.png");
            }

            @Override
            public void dispose(GLAutoDrawable arg0) {
            }

            @Override
            public void display(GLAutoDrawable draw) {
                double[] vertices = {
                        -0.50, 0.50, -0.50,//A
                        -0.50, -0.50, -0.50,//B
                        0.50, -0.50, -0.50,//C
                        0.50, 0.50, -0.50,//D
                        0.50, 0.50, -0.50,//D
                        0.50, -0.50, -0.50,//C
                        0.50, -0.50, 0.50,//G
                        0.50, 0.50, 0.50,//H
                        0.50, 0.50, 0.50,//H
                        0.50, -0.50, 0.50,//G
                        -0.50, -0.50, 0.50,//F
                        -0.50, 0.50, 0.50,//E
                        -0.50, -0.50, 0.50,//F
                        -0.50, -0.50, -0.50,//B
                        -0.50, 0.50, -0.50,//A
                        -0.50, 0.50, -0.50,//A
                        0.50, 0.50, -0.50,//D
                        0.50, 0.50, 0.50,//H
                        -0.50, 0.50, 0.50,//E
                        0.50, -0.50, -0.50,//C
                        -0.50, -0.50, -0.50,//B
                        -0.50, -0.50, 0.50,//F
                        0.50, -0.50, 0.50//G
                };
                double[] texels = {
                        0, 0.66,
                        0, 0.33,
                        0.25, 0.33,
                        0.25, 0.66,
                        0.25, 0.66,
                        0.25, 0.33,
                        0.5, 0.33,
                        0.5, 0.66,
                        0.5, 0.66,
                        0.5, 0.33,
                        0.75, 0.33,
                        0.75, 0.66,
                        0.75, 0.66,
                        0.75, 0.33,
                        1, 0.33,
                        1, 0.66,
                        0.25, 1,
                        0.25, 0.66,
                        0.5, 0.66,
                        0.5, 1.0,
                        0.25, 0.33,
                        0.25, 0,
                        0.5, 0,
                        0.5, 0.33
                };

                GL2 gl2 = draw.getGL().getGL2();
                gl2.glClearColor(1, 1, 1, 1);
                gl2.glClear(GL2.GL_DEPTH_BUFFER_BIT | GL2.GL_COLOR_BUFFER_BIT);
                gl2.glLoadIdentity();

                gl2.glPushMatrix();
                t.enable(gl2);
                t.bind(gl2);
                gl2.glTranslated(0, 0, -3);
                gl2.glRotated(rot, 1, 1, 1);
                drawCube(gl2, vertices, texels);
                gl2.glPopMatrix();

                rot += 0.1;
            }
        });
        contentPane.add(drawingPanel);
    }

    public void drawCube(GL2 gl2, double[] vertices, double[] texels) {
        gl2.glBegin(GL2.GL_QUADS);
        for (int i = 0; i < vertices.length / 3; i++) {
            gl2.glTexCoord2dv(texels, i * 2);
            gl2.glVertex3dv(vertices, i * 3);
        }
        gl2.glEnd();
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

