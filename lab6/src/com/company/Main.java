package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        //MainFrame frame = new MainFrame();
        // Create the window (frame)
        /*Frame f = new MainFrame();


        // Set the layout of the frame
        f.setLayout (new FlowLayout());

        // Create the components

        Button b1 = new Button("OK");
        Button b2 = new Button("Cancel");

        // Add the components to the frame
        f.add(b1);
        f.add(b2);
        f.pack();

        // Show the frame
        f.setVisible(true);*/

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Create the window (frame)
        Frame f = new Frame("Lab 6(Not responding)");
        int height = screenSize.height / 4;
        int width = screenSize.width / 4;
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
