package com.taotao.controller;

import com.common.pojo.EasyUITreeNode;
import com.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author fengjie
 * @Description
 * @Date Created in 2018/1/3
 * @Time 14:34
 */
@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;
    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategory(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        return contentService.getContentCategory(parentId);
    }
    @RequestMapping("/content/category/create")
    @ResponseBody
    public TaotaoResult addCategory(long parentId,String name){
        return contentService.addCategory(parentId,name);
    }
    @RequestMapping("/content/category/update")
    @ResponseBody
    public TaotaoResult updateCategory(long id,String name){
        return contentService.updateCategory(id,name);
    }
    @RequestMapping("/content/category/delete")
    @ResponseBody
    public TaotaoResult deleteCategory(long id){
        return contentService.deleteCategory(id);
    }
}
