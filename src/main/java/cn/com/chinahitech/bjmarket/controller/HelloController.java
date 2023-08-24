package cn.com.chinahitech.bjmarket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController  //alt+enter
public class HelloController {

    @RequestMapping("/sayHi")
    public String sayHi(){
        return "Hello World";
    }
}
