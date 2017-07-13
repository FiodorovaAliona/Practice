package com.aliona.curscrawler.util;

import com.aliona.curscrawler.entity.Curs;
import com.aliona.curscrawler.repository.CursRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
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

    public String getPageWithDOM(CursRepository cursRepository) {
        String s = this.getPageByURL("http://www.curs.md/en");
        Document doc;
        String table = "";
        try {
            doc = Jsoup.parse(s);
            Element x = doc.getElementById("tabelValute");
            Elements trs = x.getElementsByTag("tr");
            int c = 0;
            for (Element tr : trs) {
                String[] toppings = new String[7];
                int count = 0;
                Elements tds = tr.getElementsByTag("td");
                for (Element td : tds) {
                    toppings[count] = td.text();
                    count++;
                    table += " " + td.text();
                }
                table += "\n";
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                if (c == 0){
                    c++;
                } else {
                    Curs curs = new Curs();
                    curs.setTitle(toppings[0]);
                    curs.setName(toppings[1]);
                    curs.setRate(Double.parseDouble(toppings[2]));
                    curs.setVariation(Double.parseDouble(toppings[3]));
                    curs.setPercent(Double.parseDouble(toppings[4]));
                    curs.setCourseDate(timestamp);
                    cursRepository.saveAndFlush(curs);
                }
            }
            System.out.println(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

}