package com.isilaev.test;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static com.isilaev.test.FileUtils.openFile;

class MainFrame extends JFrame {

    private JButton jButton;

    MainFrame() {
        initJFrame();
    }

    private void initJFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 300);


        jButton = addButton("Choose file");
        getContentPane().add(jButton, BorderLayout.CENTER);


        setVisible(true);
    }


    private JButton addButton(String buttonName) {
        JButton jButton = new JButton(buttonName);
        jButton.setSize(50, 50);

        return jButton;
    }

    public JButton getjButton() {
        return jButton;
    }
}
