package assignment16;

import java.io.File;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class Planets extends JFrame {
    final String basePath = new File("").getAbsolutePath() + "\\src\\assignment16";
    final File fileSunTexture = new File(basePath + "\\tex_sun.jpg");
    final File fileEarthTexture = new File(basePath + "\\tex_earth.jpg");
    final File fileMoonTexture = new File(basePath + "\\tex_moon.jpg");

    Texture textureSun;
    Texture textureEarth;
    Texture textureMoon;
    GLU glu = new GLU();
    double rot = 0;

    public void drawSphere(GLU glu, double radius, int stacks, int slices, boolean doTexture) {
        GLUquadric q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricTexture(q, doTexture);
        glu.gluSphere(q, radius, stacks, slices);
        glu.gluDeleteQuadric(q);
    }

    public Planets() {
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
                    textureSun = TextureIO.newTexture(fileSunTexture, true);
                    textureEarth = TextureIO.newTexture(fileEarthTexture, true);
                    textureMoon = TextureIO.newTexture(fileMoonTexture, true);
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

                gl2.glScaled(0.4, 0.4, 0.4);

                gl2.glPushMatrix();
                gl2.glRotated(rot, 1, 1, 1);
                textureSun.enable(gl2);
                textureSun.bind(gl2);
                drawSphere(glu, 0.5, 22, 22, true);
                gl2.glPopMatrix();

                gl2.glPushMatrix();
                gl2.glRotated(rot * 2, 0, 1, 0);
                gl2.glScaled(0.6, 0.6, 0.6);
                gl2.glTranslated(-3.5, 0, 0);
                gl2.glRotated(-rot * 4, 1, 1, 1);
                textureEarth.enable(gl2);
                textureEarth.bind(gl2);
                drawSphere(glu, 0.5, 22, 22, true);
                gl2.glPopMatrix();

                gl2.glPushMatrix();

                gl2.glRotated(rot * 2, 0, 1, 0);
                gl2.glScaled(0.6, 0.6, 0.6);
                gl2.glTranslated(-3.5, 0, 0);

                gl2.glRotated(rot * 20, 0, 1, 0);
                gl2.glScaled(0.3, 0.3, 0.3);
                gl2.glTranslated(-2.5, 0, 0);
                gl2.glRotated(-rot * 4, 1, 1, 1);
                textureMoon.enable(gl2);
                textureMoon.bind(gl2);
                drawSphere(glu, 0.5, 22, 22, true);
                gl2.glPopMatrix();
                gl2.glFlush();
                rot += 0.5;
            }
        });
    }

    public static void main(String[] args) {
        Planets frame = new Planets();
        frame.setVisible(true);
    }

}
