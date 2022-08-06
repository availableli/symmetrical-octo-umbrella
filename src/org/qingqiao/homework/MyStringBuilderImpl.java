package org.qingqiao.homework;

import java.util.Arrays;

public class MyStringBuilderImpl implements MyStringBuilder {
    private char[] content;
    private Integer length;
//    private Integer capacity;

    public MyStringBuilderImpl() {
//        this.capacity = 16;
        content = new char[16];
        this.length = content.length;
    }

    public MyStringBuilderImpl(String str) {
//        this.capacity = str.length() + 16;
        content = str.toCharArray();
        this.length = content.length;
    }

    public MyStringBuilderImpl(char[] arr) {
//        this.capacity = arr.length + 16;
        content = arr;
        this.length = content.length;
    }

    @Override
    public String toString() {
        String str = String.valueOf(content);
        return str;
    }

    @Override
    public void append(String str) {
        // 老数组长度
        int oldlength = this.length;
        this.content = Arrays.copyOf(content, str.length() + this.length);
        this.length = str.length() + this.length;
        char[] chars = str.toCharArray();
        System.arraycopy(chars, 0, content, oldlength, chars.length);
    }

    @Override
    public void append(char c) {
        this.content = Arrays.copyOf(content, 1 + this.length);
        this.length = 1 + this.length;
        content[length - 1] = c;
    }

    @Override
    public void insert(int pos, char b) {
        this.content = Arrays.copyOf(content, 1 + this.length);
        this.length = 1 + this.length;
        for (int i = content.length - 1; i > pos; i--) {
            content[i] = content[i - 1];
        }
        content[pos] = b;
    }

    @Override
    public void insert(int pos, String str) {
        char[] qian = Arrays.copyOfRange(content, 0, pos);
        char[] hou = Arrays.copyOfRange(content, pos, length);
        // 老数组长度
        int oldlength = this.length;
        this.content = Arrays.copyOf(content, str.length() + this.length);
        this.length = str.length() + this.length;
        char[] newString = str.toCharArray();
        System.arraycopy(newString, 0, content, pos, newString.length);
        System.arraycopy(hou, 0, content, qian.length + newString.length, hou.length);
    }

    @Override
    public void delete(int start) {
        char[] newcontent = new char[start];
        System.arraycopy(content, 0, newcontent, 0, start);
        content = newcontent;
        length = content.length;
    }

    @Override
    public void delete(int start, int end) {
        char[] newcontent = new char[length - (end - start)];
        char[] hou = Arrays.copyOfRange(content, end, length);
        System.arraycopy(content, 0, newcontent, 0, start);
        System.arraycopy(hou, 0, newcontent, start, hou.length);
        content = newcontent;
        length = content.length;
    }

    @Override
    public void reverse() {
        for (int i = 0; i < length / 2; i++) {
            char temp = content[i];
            content[i] = content[length - i - 1];
            content[length - i - 1] = temp;
        }
    }

    @Override
    public int length() {
        return length;
    }
}
