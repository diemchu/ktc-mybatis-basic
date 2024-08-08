package com.example.crud_mybatis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController
{
    @RequestMapping()
    public String test(){
        return "test.html";
    }
}
