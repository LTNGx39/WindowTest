import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class ContentPanel extends javax.swing.JPanel {
    
    private Frame frame;
    public static JTextArea text;

    public ContentPanel(Frame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(frame.getWidth() - 2, 200));
        setOpaque(false);
        setLayout(new GridLayout(1, 1));

        text = new JTextArea("Esto es solo una prueba!");
        text.setPreferredSize(new Dimension(400, 120));
        text.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        text.setFont(CustomFont.interBold.deriveFont(36F));
        text.setForeground(Palette.WHITE);
        text.setEditable(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setOpaque(false);
        text.setSelectedTextColor(Palette.WHITE);
        text.setSelectionColor(Palette.ONYX);
        add(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        Shape roundTopRectangle;
        Path2D path = new Path2D.Double();

        // Size: 480x200
        path.moveTo(0, 0);
        path.lineTo(0, 168);
        path.curveTo(0, 200, 0, 200, 32, 200);
        path.lineTo(448, 200);
        path.curveTo(480, 200, 480, 200, 480, 168);
        path.lineTo(480, 0);
        path.lineTo(0, 0);
        path.closePath();

        roundTopRectangle = path;

        g2.setColor(Palette.RAISING_BLACK);
        g2.fill(roundTopRectangle);
    }
}
