import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class drawline extends JPanel {
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.black);
        g2d.clearRect(0, 0, maxWidth, maxHeight);
        g2d.setColor(Color.yellow);
        g2d.drawLine(0, 50, maxWidth, maxHeight);
        g2d.drawString("Привіт, Java 2D!", 50, 50);
    }
    private static int maxWidth;
    private static int maxHeight;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Привіт, Java 2D!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new drawline());
        frame.setVisible(true);
        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth =  size.width - insets.left - insets.right - 1;
        maxHeight =  size.height - insets.top - insets.bottom - 1;
    }
}
