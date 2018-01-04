package com.taotao.controller;

import com.alibaba.fastjson.JSON;
import com.common.pojo.TaotaoResult;
import com.common.utils.IDUtils;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemCatService;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description
 * @Date Created in 2017/12/2
 * @Time 10:29
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping("/item/{id}")
    @ResponseBody
    public TbItem getItem(@PathVariable long id)
    {
        return itemService.getItemById(id);
    }
    /**
     * 查询商品列表
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public String getItemList(int page,int rows){
        return JSON.toJSONString(itemService.getItems(page,rows));
    }
    @RequestMapping("/item/cat/list")
    @ResponseBody
    public String getCatList(@RequestParam(value = "id",defaultValue = "0") long parentId ){
        return JSON.toJSONString(itemCatService.getCatList(parentId));
    }
    /**
     * 保存
     * @param item
     * @param desc
     * @return
     */
    @RequestMapping("/item/save")
    @ResponseBody
    public TaotaoResult addItem(TbItem item, String desc){
        return itemService.saveItem(item,desc);
    }

    /**
     * 更新方法
     * @param item 被修改的商品
     * @param desc 描述
     * @return
     */
    @RequestMapping("/rest/item/update")
    @ResponseBody
    public TaotaoResult editItem(TbItem item, String desc){
        return itemService.updateItem(item,desc);
    }
    /**
     * 商品的上架下架
     * @param ids
     * @param status
     * @return
     */
    @RequestMapping("/rest/item/status")
    @ResponseBody
    public TaotaoResult stockItem(String status,String ids){
        return itemService.updateItemStatus(status,ids);
    }

    /**
     * 根据ID删除商品
     * @param ids
     * @return
     */
    @RequestMapping("/rest/item/delete")
    @ResponseBody
    public TaotaoResult deleteItem(String ids)
    {
        return itemService.deleteItem(ids);
    }
}
