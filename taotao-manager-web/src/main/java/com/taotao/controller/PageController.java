package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description
 * @Date Created in 2017/12/5
 * @Time 13:17
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/{page}")
    public String toPage(@PathVariable String page){
        return page;
    }
    @RequestMapping("/rest/page/{page}")
    public String toEidtPage(@PathVariable String page){
        return page;
    }
}
