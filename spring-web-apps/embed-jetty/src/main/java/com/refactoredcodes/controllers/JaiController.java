package com.refactoredcodes.controllers;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
public class JaiController{
    
    @ResponseBody
    @RequestMapping("/jai")
    public String jai(){ return "Jai Shree Ram!!!";  }
}
