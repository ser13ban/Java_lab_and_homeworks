package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);

        Button b1 = new Button("OK");
        Button b2 = new Button("Cancel");

        TextField size = new TextField("Size :");
        TextField numberOfSides = new TextField("Number of sides :");
        TextField stroke = new TextField("Stroke :");

        // ...TODO
        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(controlPanel,BorderLayout.SOUTH);
        add(configPanel,BorderLayout.NORTH);
        //...TODO

        //invoke the layout manager
        pack();
    }
}
