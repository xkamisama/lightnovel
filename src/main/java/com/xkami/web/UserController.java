package com.xkami.web;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xkami.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    ObjectMapper objectMapper;
    @RequestMapping("/register")
    public String registerPage(){
        return "register";
    }
    @RequestMapping("/register/add")
    @ResponseBody
    public String register(User user)throws IOException{
        System.out.println("register");
        String json = objectMapper.writeValueAsString(user);
        return json;
    }
}
