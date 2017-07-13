package com.aliona.curscrawler.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Alionka on 29.06.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.aliona.curscrawler")
public class WebConfig extends WebMvcConfigurerAdapter {

}