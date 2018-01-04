package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author fengjie
 * @Description
 * @Date Created in 2018/1/2
 * @Time 15:08
 */
@Controller
public class IndexController {
    @RequestMapping("/index.html")
    public String showIndex(){
        return "index";
    }
}
