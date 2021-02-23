package finals;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import javax.swing.*;
import java.io.File;

public class Q10 extends JFrame {
    final String basePath = new File("").getAbsolutePath() + "\\src\\finals";
    final File soccerTexture = new File(basePath + "\\soccerTex.png");

    Texture t;
    GLU glu = new GLU();
    double rot = 0;
    double pos = 0;
    boolean moveLeft = true;

    public void drawSphere(GLU g, double r, int stk, int slc, boolean tex) {
        GLUquadric q = g.gluNewQuadric();
        g.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        g.gluQuadricTexture(q, tex);
        g.gluSphere(q, r, stk, slc);
        g.gluDeleteQuadric(q);
    }

    public Q10() {
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities cap = new GLCapabilities(profile);
        GLJPanel drawingPanel = new GLJPanel(cap);
        FPSAnimator animator = new FPSAnimator(drawingPanel, 60);
        animator.start();
        this.setSize(800, 600);
        this.setLayout(null);
        this.add(drawingPanel);
        drawingPanel.setBounds(0, 0, 800, 600);
        drawingPanel.addGLEventListener(new GLEventListener() {

            @Override
            public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
                                int arg4) {
                // TODO Auto-generated method stub

            }

            @Override
            public void init(GLAutoDrawable draw) {
                GL2 gl2 = draw.getGL().getGL2();
                gl2.glEnable(GL2.GL_DEPTH_TEST);
                try {
                    t = TextureIO.newTexture(soccerTexture, true);
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }

            @Override
            public void dispose(GLAutoDrawable arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void display(GLAutoDrawable draw) {
                GL2 gl2 = draw.getGL().getGL2();
                gl2.glClearColor(1, 1, 1, 1);
                gl2.glClear(GL2.GL_DEPTH_BUFFER_BIT | GL2.GL_COLOR_BUFFER_BIT);
                gl2.glLoadIdentity();

                gl2.glScaled(0.5, 0.5, 0.5);

                gl2.glTranslated(pos, 0, 0);
                gl2.glPushMatrix();
                gl2.glRotated(rot, 0, 0, 1);
                t.enable(gl2);
                t.bind(gl2);
                drawSphere(glu, 1, 22, 22, true);
                gl2.glPopMatrix();
                gl2.glFlush();
                if (moveLeft) {
                    pos -= 0.01;
                    rot += 0.5;
                } else {
                    pos += 0.01;
                    rot -= 0.5;
                }
                if (pos < -1 || pos > 1) {
                    moveLeft = !moveLeft;
                }
            }
        });
    }

    public static void main(String[] args) {
        Q10 frame = new Q10();
        frame.setVisible(true);
    }

}
