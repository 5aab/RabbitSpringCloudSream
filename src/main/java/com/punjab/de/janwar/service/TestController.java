package com.punjab.de.janwar.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@AllArgsConstructor
public class TestController {

    @RequestMapping("/test1")
    @ResponseBody
    String home() {
        return "Hello World How r u!";
    }

    @RequestMapping("/send")
    @ResponseBody
    String send() {
        for(int i=0;i<10;i++) {
           // gateway.generate(getNotificationMessage(i));
        }
        return "Hello Notification sent!";
    }
}
