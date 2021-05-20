package com.example.socialnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "hello";
    }

    @RequestMapping(value = "/login/signin/{access_token}", method = RequestMethod.GET)
    public String Sign_in_controller(@RequestParam String access_token){
        return "Sign_in_controller";
    }
    @RequestMapping(value = "/login/signin/Profile_Page", method = RequestMethod.GET)
    public String Profile_Page(){
        return "Profile_Page";
    }

    @GetMapping( "/qa/{token}")
    public ModelAndView getToken(@PathVariable String token){
        System.out.println("the token got from FB is "+ token);
        ModelAndView model = new ModelAndView("qa");
        model.addObject("token", token);
        return model;
        //TODO make call to facebook api for comments
        //TODO send the data to thte index jsp for displayng the output
    }


}
