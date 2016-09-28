package com.example.aportillo.rappitest.util;

/**
 * Created by aportillo on 28/09/2016.
 */
public class StringUtil {

    /**
     * @param string String
     * @return boolean
     */
    public static boolean isEmpty(String string) {
        return string.trim().equals("");
    }

    public static boolean isEmptyOrNull(String string) {
        return string == null || string.trim().equals("");
    }
}
