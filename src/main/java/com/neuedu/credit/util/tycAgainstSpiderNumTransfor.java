package com.neuedu.credit.util;

import com.neuedu.credit.util.PayUtil;

import java.util.regex.Pattern;

/**
 * @Created by elvin on 2018/10/10 11:05.
 * @Describe: 天眼查网站反爬数字转换（处理）
 */
public class tycAgainstSpiderNumTransfor {

    /**
     * @Created elvin yuan on 7:57 2018/10/24
     * @Describe //TODO 天眼查网站反爬虫数字转化回来
     * @Param 错误字符串
     * @return 正确的字符串
    */
    public static String turnString(String codeString) {
        String code = "6014587329";
        String that = "1234567890";
        String[] codeSplit = code.split("");
        String[] thatSplit = that.split("");

        StringBuilder turnString = new StringBuilder();
        for (int i = 0; i < codeString.length(); i++) {
            String codeChar = codeString.substring(i, i + 1);
            if (isInteger(codeChar)) {
                int index = that.lastIndexOf(codeChar);
                turnString.append(code.substring(index, index + 1));
            } else {
                turnString.append(codeChar);
            }

        }

        return turnString.toString();
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
