package dev.toastcie.anims;

import dev.toastcie.anims.animations.TickEvent;
import dev.toastcie.anims.animations.TickListener;
import dev.toastcie.anims.animations.Timer;
import dev.toastcie.anims.operators.CircleInterpolator;
import dev.toastcie.anims.shapes.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.XMLDecoder;

public class MainFrame extends JFrame {

    CircleInterpolator ci;
    Circle current = new Circle();
    Circle prev = new Circle();

    public MainFrame() {
        this.setTitle("animations");
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setLayout(null);
        this.pack();

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'q') System.exit(0);
            }
        });

        Timer t = new Timer();

        t.setPeriod(100);

        XMLDecoder decoder = new XMLDecoder(MainFrame.class.getResourceAsStream("/output.xml"));
        ci = (CircleInterpolator) decoder.readObject();

        t.addTickListener(new TickListener() {
            @Override
            public void tick(TickEvent e) {
                if (ci.hasNext()) {
                    prev = current;
                    current = ci.next();
                    //System.out.println(current);
                    repaint();
                }

            }
        });

        t.start();
    }

    public static void main(String[] args) {
        new MainFrame();
    }


    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());
        if (prev != null) {
            g.setColor(Color.CYAN);
            g.fillOval(prev.getX() - prev.getRadius() / 2, prev.getY() - prev.getRadius() / 2, prev.getRadius(), prev.getRadius());
        }
        g.setColor(Color.BLACK);
        g.fillOval(current.getX() - current.getRadius() / 2, current.getY() - current.getRadius() / 2, current.getRadius(), current.getRadius());
    }
}