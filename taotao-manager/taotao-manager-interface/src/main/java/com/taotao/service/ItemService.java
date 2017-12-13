package com.taotao.service;
import com.common.pojo.EasyUIGridResults;
import com.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description
 * @Date Created in 2017/12/2
 * @Time 9:22
 */
public interface ItemService {
    TbItem getItemById(Long id);
    EasyUIGridResults<TbItem> getItems(int page,int rows);
    TaotaoResult saveItem(TbItem item, String desc);
    TaotaoResult updateItem(TbItem item,String desc);
}
