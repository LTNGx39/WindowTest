import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Frame extends javax.swing.JFrame {

    public Frame() {
        setSize(482, 234); 
        setUndecorated(true);
        setLocationRelativeTo(null);
        setContentPane(new Panel(this));
        setBackground(Palette.ALPHA);
        ImageIcon icon = new ImageIcon("media/images/logox64.png");
        Image imageIcon = icon.getImage();
        setIconImage(imageIcon);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(new TitleBar(this), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(new ContentPanel(this), gbc);
    }

    public static void main(String args[]) {
        Frame window = new Frame();
        window.setVisible(true);
    }
}

class Panel extends javax.swing.JPanel {

    private int borderThickness = 1;
    private Shape roundRectangle = new RoundRectangle2D.Double(
        borderThickness / 2.0,
        borderThickness / 2.0,
        482 - borderThickness,
        234 - borderThickness,
        32,
        32);

    public Panel(Frame frame) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2.setColor(Palette.ONYX);
        g2.draw(roundRectangle);

        g2.setColor(Palette.RAISING_BLACK);
        g2.fill(roundRectangle);
    }
}