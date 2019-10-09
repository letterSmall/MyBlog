package com.enlie.blog.tool;

public class HtmlLabelFilter {
    public static String htmlLabelFilter(String htmlContent){
        if (htmlContent ==null){
            return null;
        }
        htmlContent=htmlContent.replaceAll("<(S*?)[^>]*>.*?|<.*? />","");
        htmlContent=htmlContent.replaceAll("&.{2,6}?;","");
        htmlContent=htmlContent.substring(0,180);
        return htmlContent;
    }
}
