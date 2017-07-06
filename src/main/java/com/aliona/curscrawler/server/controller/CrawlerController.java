package com.aliona.curscrawler.server.controller;

import com.aliona.curscrawler.server.util.Spider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/curs")
public class CrawlerController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public static String getPageByURL(String requestURL){

        Spider a = new Spider ();
        String s = a.getPageByURL("http://www.curs.md/ru") ;
        return s;
    }
}
