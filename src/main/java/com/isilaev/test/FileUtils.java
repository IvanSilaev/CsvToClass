package com.isilaev.test;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileUtils {
    public static File openFile(Component component) {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = fileChooser.showOpenDialog(component);

        if(result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }
}
