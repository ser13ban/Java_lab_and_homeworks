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
    }

    @GetMapping( "/qa/comments/{id}/{token}")
    public ModelAndView comments(@PathVariable String id,@PathVariable String token){
        ModelAndView model = new ModelAndView("comments");
        model.addObject("id", id);
        model.addObject("token", token);
        return model;
    }


}
