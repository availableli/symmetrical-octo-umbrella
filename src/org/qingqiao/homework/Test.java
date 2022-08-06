package org.qingqiao.homework;

public class Test {

    public static void main(String[] args) {
        MyStringBuilderImpl sb = new MyStringBuilderImpl("123");
        sb.append("abcd");
        sb.append('黄');
        sb.append("123456789123456789");
        sb.append('-');
        sb.append("123456789123456789");
        sb.insert(3, '飞');
        sb.insert(45, "!@#$%");
        sb.delete(45);
        sb.delete(3, 8);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}
