package com.isilaev.test;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.sun.istack.internal.NotNull;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class CsvUtils {

    private final String[] columns;
    private final ListIterator<CSVRecord> records;

    public CsvUtils(@NotNull File file) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            Splitter splitter = Splitter.on(",").trimResults();

            columns = Iterables.toArray(splitter.split(br.readLine()), String.class);
            records = CSVFormat.RFC4180.withHeader(columns).parse(br).getRecords().listIterator();
        }
    }


    public Map<Integer, Map<String, String>> toMap() {
        Map<Integer, Map<String, String>> map = new HashMap<>();


        Integer totalRecords = 0;

        while(records.hasNext()) {
            CSVRecord next = records.next();
            totalRecords++;

            map.put(totalRecords, next.toMap());
        }

        return map;
    }

    public String[] getColumns() {
        return columns;
    }

    public ListIterator<CSVRecord> getRecords() {
        return records;
    }
}
