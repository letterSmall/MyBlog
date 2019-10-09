package com.enlie.blog.tool;


import java.net.HttpURLConnection;
import java.net.URL;

public class CheckUrl {

    private static URL url;
    private static HttpURLConnection con;
    private static int state = -1;

    public synchronized URL exists(String urlSite) {
        if (urlSite == null || urlSite.equals("")) {
            return null;
        }
        try {
            url = new URL(urlSite);
            con = (HttpURLConnection) url.openConnection();
            state = con.getResponseCode();
            System.out.println("url" + state);
            if (state == 200) {
                return url;
            }
        } catch (Exception ex) {
        }
        return null;
    }

}
