package com.company;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Create the window (frame)
        Frame f = new Frame("Lab 6(Not responding)");
        int height = screenSize.height / 3;
        int width = screenSize.width / 3;
        f.setPreferredSize(new Dimension(width,height));
        // Set the layout of the frame
        f.setLayout(new FlowLayout());
        // Create the components
        Button b1 = new Button("OK");
        Button b2 = new Button("Cancel");

        TextField size = new TextField("Size :");
        TextField numberOfSides = new TextField("Number of sides :");
        TextField stroke = new TextField("Stroke :");

        f.add(size);
        f.add(numberOfSides);
        f.add(stroke);

        f.add(b1);
        f.add(b2);
        f.pack();
        // Show the frame
        f.setVisible(true);
        new MainFrame().setVisible(true);
    }



}
