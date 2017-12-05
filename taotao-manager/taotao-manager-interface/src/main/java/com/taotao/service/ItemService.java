package com.taotao.service;
import com.common.pojo.EasyUIGridResults;
import com.taotao.pojo.TbItem;

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
}
