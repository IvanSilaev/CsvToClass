package com.isilaev.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main extends JFrame{

    private static File file;

    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();

        JButton jButton = mainFrame.getjButton();

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file = FileUtils.openFile(jButton);

                CsvUtils csvUtils = null;
                try {
                    csvUtils = new CsvUtils(file);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Map<Integer, Map<String, String>> integerMapMap = csvUtils.toMap();


                StringBuilder sb = new StringBuilder();
                sb
                        .append("public class CampaignPerformanceReport {\n" );

                for (Map<String, String> map : integerMapMap.values()) {
                    sb
                            .append("\t")
                            .append("@CsvField(name = \"").append(map.get("Display Name"))
                            .append("\", field = \"").append(map.get("Name"))
                            .append("\")")
                            .append("\n")
                            .append("\t")
                            .append("private String ")
                            .append(StringUtils.stringToFieldName(map.get("Name"))).append(";")
                            .append("\n\n");
                }

                sb.append("}");

                File file = new File("CampaignPerformanceReport.txt");

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                    writer.write(sb.toString());

                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }


}
