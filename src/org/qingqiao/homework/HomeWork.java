package org.qingqiao.homework;

import java.util.Arrays;
import java.util.Locale;

public class HomeWork {

    public static void main(String[] args) {
        homework7();
    }

    private static void homework7() {
        String str = "Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
        int two = str.lastIndexOf("two");
        char c = str.charAt(two);
        /*String s = c.toString().toUpperCase();*/
//        String substring = str.substring(two,two+1).toUpperCase();
        /*String qian = str.substring(0, two);
        String hou = str.substring(two + 1);
        System.out.println(qian + substring + hou);*/
        StringBuilder sb = new StringBuilder(str);
//        sb.replace(two,two+1,substring);
        sb.setCharAt(two, (char) (c - 32));
        System.out.println(sb);
    }

    private static void homework6() {
        String str = "lengendary";
        String substring = str.substring(0, str.length() - 1);
        String y = str.substring(str.length() - 1);
        String newchar = substring + y.toUpperCase(Locale.ROOT);
        System.out.println(newchar);
    }

    private static void homework5() {
        String str = "lengendary";
        String newStr = "";
        String[] split = str.split("");
        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 0) {
                newStr += split[i].toUpperCase();
            } else {
                newStr += split[i];
            }
        }
        System.out.println(newStr);
    }

    public static String homework1() {
        char[] cs = new char[5];
        for (int i = 0; i < cs.length; i++) {
            // 生成随机数
            // [48,123)
            int v = (int) (Math.random() * 75 + 48);
            // 把58-64以及91-96这些字符排除
            if (v >= 58 && v <= 64 || v >= 91 && v <= 96) {
                // 把当前的这一次循环重新做一次
                i--;
                continue;
            }
            cs[i] = (char) v;
        }
        String s = new String(cs);
        System.out.println(s);
        return s;
    }

    public static void homework2() {
        String password = homework1();
        String[] shengcheng = shengcheng();
        String s = checkPassword(password, shengcheng);
        System.out.println(s);
    }

    public static String[] shengcheng() {
        String[] str = new String[62];
        int count = 48;
        for (int i = 0; i < str.length; i++) {
            // 把58-64以及91-96这些字符排除
            if (count >= 58 && count <= 64 || count >= 91 && count <= 96) {
                // 把当前的这一次循环重新做一次
                i--;
                count++;
                continue;
            }
            str[i] = ((char) count) + "";
            count++;
        }
        return str;
    }

    public static String checkPassword(String password, String[] str) {
        StringBuilder sb = new StringBuilder();
        String[] destArr = password.split("");
        for (int i = 0; i < destArr.length; i++) {
            for (int j = 0; j < str.length; j++) {
                if (str[j].equals(destArr[i])) {
                    sb.append(str[j]);
                }
            }
        }
        return sb.toString();
    }

    public static void homework3() {
        String str = "let there be light";
        String newStr = "";
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            String substring = s[i].substring(0, 1);
            String s1 = substring.toUpperCase();
            String substring1 = s[i].substring(1);
            newStr += " " + s1 + substring1;
        }
        System.out.println(newStr.substring(1));
    }

    public static void homework4() {
        String str = "peter piper picked a peck of pickled peppers";
        String[] s = str.split(" ");
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].startsWith("p")) {
                count++;
            }
        }
        System.out.println(count);
    }


}
