package com.abovebytes.utils;

public class CommonUtils {
    public static String removePlus(String value) {
        return value == null ? null : value.replaceAll("\\+", "");
    }
}
