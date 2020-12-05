package gui;

import draw.Draw;

import javax.swing.*;

public class Gui {
    JFrame jFrame;
    public static Draw draw;

    public static final int WIDTH = 512, HEIGHT = 512, XOFF = 10, YOFF = 10;

    public void create() {
        jFrame = new JFrame("Game of Life");
        jFrame.setSize(550, 570);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);

        draw = new Draw();
        draw.setBounds(0, 0, 550, 570);
        draw.setVisible(true);

        jFrame.add(draw);
        jFrame.setVisible(true);
    }
}
