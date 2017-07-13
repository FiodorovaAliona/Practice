package com.aliona.curscrawler.controller;

import com.aliona.curscrawler.repository.CursRepository;
import com.aliona.curscrawler.util.Spider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/curs")
public class CrawlerController {

    @Autowired
    private CursRepository cursRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getPageByURL(String requestURL){

        Spider a = new Spider ();
        String s = a.getPageWithDOM(cursRepository) ;
        return s;
    }
}

