package com.czc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * ClassName:LotteryApp
 * Description:
 */
@ServletComponentScan
@SpringBootApplication
public class LotteryApp {
    public static void main(String[] args){
        SpringApplication.run(LotteryApp.class,args);
    }
}
