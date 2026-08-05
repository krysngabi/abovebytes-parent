package com.abovebytes.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class CommonUtils {


    public static String removePlus(String value) {
        return value == null ? null : value.replaceAll("\\+", "");
    }
}
