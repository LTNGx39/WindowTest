import javax.swing.*;
import java.awt.*;
import java.awt.Window.Type;
import java.awt.event.*;

public class EventListener {

    public class DragFrame extends MouseAdapter {

        private Frame frame;
        private int mouseX, mouseY;

        public DragFrame(Frame frame) {
            this.frame = frame;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mouseX = e.getX() + 1;
            mouseY = e.getY() + 1;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getXOnScreen() - mouseX;
            int y = e.getYOnScreen() - mouseY;
            frame.setLocation(x, y);
        }
    }

    public class Minimize implements ActionListener {

        private Frame frame;

        public Minimize(Frame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setState(JFrame.ICONIFIED);
        }
    }

    public class Maximize implements ActionListener {

        private Frame frame;
        private boolean key = true;

        public Maximize(Frame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (key) {
                ContentPanel.text.setText("No disponible por ahora...");
                key = false;
            } else {
                ContentPanel.text.setText("Esto es solo una prueba!");
                key = true;
            }
        }
    }

    public class Close implements ActionListener {

        private Frame frame;

        public Close(Frame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            System.exit(0);
        }
    }
}