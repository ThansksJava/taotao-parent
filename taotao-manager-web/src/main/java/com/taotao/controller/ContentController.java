package com.taotao.controller;

import com.common.pojo.EasyUIGridResults;
import com.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description
 * @Date Created in 2018/1/4
 * @Time 14:44
 */
@Controller
public class ContentController {
    @Autowired
    private ContentService contentService = null;
    @RequestMapping("/content/query/list")
    @ResponseBody
    public EasyUIGridResults<TbContent> getContents(long categoryId,int page,int rows){
        return contentService.getContents(categoryId,page,rows);
    }
    @RequestMapping("/content/save")
    @ResponseBody
    public TaotaoResult addContent(TbContent content)
    {
        return contentService.addContent(content);
    }
    @RequestMapping("/content/edit")
    @ResponseBody
    public TaotaoResult updateContent(TbContent content)
    {
        return contentService.updateContent(content);
    }
}
