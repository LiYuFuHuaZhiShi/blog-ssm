package com.controller;

import com.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;

    //分类
    @RequestMapping(value = "/typePage.action")
    public String typePage() {
        //对类别进行查找
        //
        return "type";
    }

}
