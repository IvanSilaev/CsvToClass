package com.isilaev.test;

import java.util.Arrays;

class StringUtils {
    static String stringToFieldName(String string) {
        String[] split = string.trim().split("");

        split[0] = split[0].toLowerCase();

        StringBuilder fieldNameBuilder = new StringBuilder();

        for (String s : split) {
            fieldNameBuilder.append(s);
        }

        return fieldNameBuilder.toString().trim();
    }
}
