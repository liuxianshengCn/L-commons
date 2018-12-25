package com.utils.string;

/**
 * @author liuxi
 * @since 2018-12-25
 */
public final class StringUtil {

    /**
     * 判断是否为空
     * @param s
     * @return
     */
    public static boolean isEmpty(String s){
        return null == s || "".equals(s);
    }

    /**
     * 判断不为空
     * @param s
     * @return
     */
    public static boolean isNotEmpty(String s){
        return !isEmpty(s);
    }

}
