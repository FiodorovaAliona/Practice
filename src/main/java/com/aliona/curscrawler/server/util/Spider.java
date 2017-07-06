package com.aliona.curscrawler.server.util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;


public class Spider {

        public static String getPageByURL(String requestURL) {
        URL url;
        String response = "";
        System.out.println("Get: " + requestURL);
        try {
            url = new URL(requestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(7000);
            conn.setConnectTimeout(7000);
            conn.setRequestMethod("GET");
            conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("User-agent", System.getProperty("http.agent"));
            conn.setDoInput(true);
            int responseCode = conn.getResponseCode();
            if (responseCode < 400) {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                response = br.toString();
                while ((line = br.readLine()) != null) {
                    response += line;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

   public String getPageWithDOM() {
       String s = this.getPageByURL("http://www.curs.md/ru");
      Document doc;
       try {
           doc = Jsoup.parse(s);
       Element x = doc.getElementById("tabelValute");
       Elements tds = x.getElementsByTag("td");
       String table;
       for (Element td : tds) {
           System.out.println("\n" + td.text());
       }
   } catch (Exception e) {
        e.printStackTrace();
    }
        return s;
        }

}
