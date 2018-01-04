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
    /**
     * 得到商品
     * @param id
     * @return
     */
    TbItem getItemById(Long id);
    /**
     * 商品列表
     * @param page
     * @param rows
     * @return
     */
    EasyUIGridResults<TbItem> getItems(int page,int rows);
    /**
     * 新增商品保存
     * @param item
     * @param desc
     * @return
     */
    TaotaoResult saveItem(TbItem item, String desc);
    /**
     * 更新商品
     * @param item
     * @param desc
     * @return
     */
    TaotaoResult updateItem(TbItem item,String desc);
    /**
     * 商品的上架下架
     * @param ids
     * @param status
     * @return
     */
    TaotaoResult updateItemStatus(String status,String ids);

    /**
     * 根据id删除商品
     * @param ids
     * @return
     */
    TaotaoResult deleteItem(String ids);

}
