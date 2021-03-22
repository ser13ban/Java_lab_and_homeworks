package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");

    //create all buttons (Load, Reset, Exit)
    JButton loadBtn = new JButton("load");
    JButton resetBtn = new JButton("reset");
    JButton exitBtn = new JButton("exit");


    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        //add all buttons
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        resetBtn.addActionListener(this::reset);
        //loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);

        //...TODO
    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void exit(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    private void reset(ActionEvent e) {
        frame.getContentPane().invalidate();
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    /*
    private void load(ActionEvent e) {
        try {
            ImageIO.load(frame.canvas.image, "PNG", new File("d:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }*/



    //...TODO
}
