package com.example.socialnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "hello";
    }

    @GetMapping( "/firstAPIcall/{token}/{link}")
    public String getToken(@PathVariable String token,@PathVariable String link){
        System.out.println("the token got from FB is "+ token+ "\nand the link is "+link);
        //TODO make call to facebook api for comments
        //TODO send the data to thte index jsp for displayng the output
        return "index";
    }
}
