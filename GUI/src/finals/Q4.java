package finals;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Q4 extends JFrame {

    private final JPanel contentPane;
    private final JTextField txtPath;
    private final JTextField txtXmin;
    private final JTextField txtXmax;
    private final JTextField txtYmin;
    private final JTextField txtYmax;
    BufferedImage inputImage;

    /**
     * Create the frame.
     */
    public Q4() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblPath = new JLabel("File Path");
        panel.add(lblPath);

        txtPath = new JTextField();
        panel.add(txtPath);
        txtPath.setColumns(60);

        JButton btnBrowse = new JButton("Browse");
        panel.add(btnBrowse);

        JPanel canvas = new JPanel();
        canvas.setBackground(Color.WHITE);
        contentPane.add(canvas, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_3 = new JPanel();
        bottomPanel.add(panel_3);
        panel_3.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel = new JLabel("X min");
        panel_3.add(lblNewLabel);

        txtXmin = new JTextField();
        panel_3.add(txtXmin);
        txtXmin.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("X max");
        panel_3.add(lblNewLabel_1);

        txtXmax = new JTextField();
        txtXmax.setColumns(10);
        panel_3.add(txtXmax);

        JLabel lblNewLabel_1_1 = new JLabel("Y min");
        panel_3.add(lblNewLabel_1_1);

        txtYmin = new JTextField();
        txtYmin.setColumns(10);
        panel_3.add(txtYmin);

        JLabel lblNewLabel_1_2 = new JLabel("Y max");
        panel_3.add(lblNewLabel_1_2);

        txtYmax = new JTextField();
        txtYmax.setColumns(10);
        panel_3.add(txtYmax);

        JButton btnPaste = new JButton("Paste");
        panel_3.add(btnPaste);

        JPanel clippedCanvas = new JPanel();
        clippedCanvas.setBackground(Color.WHITE);
        bottomPanel.add(clippedCanvas);
        clippedCanvas.setLayout(new BorderLayout(0, 0));
        btnBrowse.addActionListener((e) -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(panel);
            if (option == JFileChooser.APPROVE_OPTION) {
                txtPath.setText(fileChooser.getSelectedFile().toString());
                try {
                    inputImage = ImageIO.read(fileChooser.getSelectedFile());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                BufferedImage mainImage = new BufferedImage(canvas.getWidth(),
                        canvas.getHeight(), BufferedImage.TYPE_INT_ARGB);
                for (int xw = 0; xw < inputImage.getWidth(); xw++)
                    for (int yw = 0; yw < inputImage.getHeight(); yw++) {
                        Point p = w2v(new Point(xw, yw), 0,
                                inputImage.getWidth(), 0,
                                inputImage.getHeight(), 0,
                                canvas.getWidth(), 0, canvas.getHeight());
                        mainImage.setRGB(p.x, p.y, inputImage.getRGB(xw, yw));
                    }
                canvas.getGraphics().drawImage(mainImage, 0, 0, null);
            }
        });

        btnPaste.addActionListener((e) -> {

            final int xMin = Integer.parseInt(txtXmin.getText()),
             xMax = Integer.parseInt(txtXmax.getText()),
             yMin = Integer.parseInt(txtYmin.getText()),
             yMax = Integer.parseInt(txtYmax.getText()),
             width = Math.abs(xMax - xMin),
             height = Math.abs(yMax - yMin);
            BufferedImage pastedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = xMin; x < xMax; x++)
                for (int y = yMin; y < yMax; y++)
                    pastedImage.setRGB(x - xMin, y - yMin, inputImage.getRGB(x, y));
            clippedCanvas.getGraphics().drawImage(pastedImage, xMin, yMin, null);
        });
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Q4 frame = new Q4();
        frame.setVisible(true);
    }

    private Point w2v(Point pw, int xwmin, int xwmax, int ywmin, int ywmax, int xvmin, int xvmax, int yvmin, int yvmax) {
        int xv = (int) ((pw.x - xwmin) * (double) (xvmax - xvmin) / (double) (xwmax - xwmin) + xvmin);
        int yv = (int) ((pw.y - ywmin) * (double) (yvmax - yvmin) / (double) (ywmax - ywmin) + yvmin);
        return new Point(xv, yv);
    }

}
