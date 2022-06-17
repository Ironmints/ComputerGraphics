import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Skeleton extends JPanel implements ActionListener {
    Timer timer;
    private double angle = 0;
    private double opacity = 1;
    private double delta = 0.01;

    public Skeleton() {
        timer = new Timer(10, this);
        timer.start();
    }

    public void drawAnimation(Graphics2D g2d) {

        double points[][] = { { 875, 150 }, { 895, 80 }, { 775, 80 }, { 755, 110 }, { 770, 190 }, { 900, 200 },
                { 875, 150 } };
        GeneralPath sail = new GeneralPath();
        g2d.translate(0, 0);
        sail.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            sail.lineTo(points[k][0], points[k][1]);
        sail.closePath();

        double points2[][] = { { 920, 330 }, { 1000, 230 }, { 900, 270 }, { 770, 270 }, { 635, 215 }, { 755, 330 },
                { 920, 330 } };
        GeneralPath boat = new GeneralPath();
        g2d.translate(0, 0);
        boat.moveTo(points2[0][0], points2[0][1]);
        for (int k = 1; k < points2.length; k++)
            boat.lineTo(points2[k][0], points2[k][1]);
        boat.closePath();

        g2d.rotate(angle, (boat.getBounds2D().getCenterX() + sail.getBounds2D().getCenterX() + 830) / 3,
                (boat.getBounds2D().getCenterY() + sail.getBounds2D().getCenterY() + 195) / 3);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
        g2d.setPaint(Color.black);
        g2d.fillRect(830, 195, 10, 75);
        g2d.setPaint(new Color(128, 64, 0));
        g2d.fill(boat);
        g2d.setPaint(new Color(192, 192, 192));
        g2d.fill(sail);
    }

    public void drawFigure(Graphics2D g2d) {
        g2d.setPaint(new Color(241, 154, 154));
        g2d.fillOval(30, 30, 60, 60);
        GradientPaint gp = new GradientPaint(5, 25, new Color(84, 151, 230), 20, 2, new Color(154, 205, 241), true);
        g2d.setPaint(gp);
        double points3[][] = { { 20, 70 }, { 35, 60 }, { 60, 70 }, { 80, 60 }, { 120, 70 }, { 140, 90 }, { 120, 120 },
                { 60, 120 }, { 30, 115 }, { 10, 90 }, { 20, 70 } };
        GeneralPath cloud = new GeneralPath();
        g2d.translate(0, 0);
        cloud.moveTo(points3[0][0], points3[0][1]);
        for (int k = 1; k < points3.length; k++)
            cloud.lineTo(points3[k][0], points3[k][1]);
        cloud.closePath();
        g2d.fill(cloud);

        double points[][] = { { 275, 100 }, { 295, 30 }, { 175, 30 }, { 155, 90 }, { 170, 140 }, { 300, 150 },
                { 275, 100 } };
        GeneralPath sail = new GeneralPath();
        g2d.translate(0, 0);
        sail.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            sail.lineTo(points[k][0], points[k][1]);
        sail.closePath();
        double points2[][] = { { 320, 280 }, { 400, 180 }, { 300, 220 }, { 170, 220 }, { 35, 165 }, { 155, 280 },
                { 320, 280 } };
        GeneralPath boat = new GeneralPath();
        g2d.translate(0, 0);
        boat.moveTo(points2[0][0], points2[0][1]);
        for (int k = 1; k < points2.length; k++)
            boat.lineTo(points2[k][0], points2[k][1]);
        boat.closePath();

        g2d.setPaint(Color.black);
        g2d.fillRect(230, 145, 10, 85);
        g2d.setPaint(new Color(128, 64, 0));
        g2d.fill(boat);
        g2d.setPaint(new Color(192, 192, 192));
        g2d.fill(sail);
    }

    private void drawBorder(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);

        BasicStroke bs = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs);

        g2d.drawRect(500, 10, maxWidth - 510, maxHeight - 20);
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        Color background = new Color(255, 255, 128);
        g2d.setBackground(background);
        g2d.clearRect(0, 0, maxWidth, maxHeight);
        drawBorder(g2d);
        drawFigure(g2d);
        drawAnimation(g2d);
    }

    private static int maxWidth;
    private static int maxHeight;

    public void actionPerformed(ActionEvent e) {
        angle += 0.01;
        if (opacity < 0.01) {
            delta = -delta;
        } else if (opacity > 0.99) {
            delta = -delta;
        }
        opacity += delta;
        repaint();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Привіт, Java 2D!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1150, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Skeleton());
        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }
}

