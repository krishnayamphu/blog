package com.ky.utils;

public class PostContent {
    public static String excerpt(String text,int length){
        StringBuilder sb=new StringBuilder(text);
        String s=sb.substring(0,length);
        String data=s+" [...]";
        return data;
    }
}
