import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Ellipse2D;

public class TitleBar extends javax.swing.JPanel {
    
    private Frame frame;
    private JLabel icon;
    private JLabel title;
    private CicularButton minimize;
    private CicularButton maximize;
    private CicularButton close;

    public TitleBar(Frame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(frame.getWidth() - 2, 32));
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        EventListener.DragFrame drag = new EventListener().new DragFrame(frame);
        addMouseListener(drag);
        addMouseMotionListener(drag);
        
        icon = new JLabel(new ImageIcon("media/images/logo.png"));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(icon, gbc);

        title = new JLabel("Aplicacion");
        title.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
        title.setPreferredSize(new Dimension(376, 16));
        title.setFont(CustomFont.interMedium.deriveFont(12F));
        title.setForeground(Palette.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(title, gbc);

        minimize = new CicularButton(Palette.DARK_PASTEL_GREEN);
        minimize.addActionListener(new EventListener().new Minimize(frame));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(minimize, gbc);

        maximize = new CicularButton(Palette.JONQUIL);
        maximize.addActionListener(new EventListener().new Maximize(frame));
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 8, 0, 8);
        add(maximize, gbc);

        close = new CicularButton(Palette.FOLLY);
        close.addActionListener(new EventListener().new Close(frame));
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(close, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        Shape roundTopRectangle;
        Path2D path = new Path2D.Double();

        // Size: 480x32
        path.moveTo(0, 32);
        path.lineTo(480, 32);
        path.curveTo(480, 0, 480, 0, 446, 0);
        path.lineTo(34, 0);
        path.curveTo(0, 0, 0, 0, 0, 32);
        path.closePath();

        roundTopRectangle = path;

        g2.setColor(Palette.EERIE_BLACK);
        g2.fill(roundTopRectangle);
    }

    public class CicularButton extends javax.swing.JButton {

        private Shape circle = new Ellipse2D.Double(0, 0, 16, 16);
        private Color color;

        public CicularButton(Color color) {
            setPreferredSize(new Dimension(16, 16));
            setFocusPainted(false);
            setBackground(Palette.ALPHA);
            setContentAreaFilled(false);
            setBorderPainted(false);
            this.color = color;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(color);
            g2.fill(circle);
        }

        @Override
        public boolean contains(int x, int y) {
            if (circle == null || !circle.contains(x, y)) {
                return false;
            }
            return true;
    }
    }
}