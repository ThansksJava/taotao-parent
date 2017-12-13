package com.taotao.service;

import com.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description 商品目录Service
 * @Date Created in 2017/12/5
 * @Time 14:14
 */
public interface ItemCatService {
    /**
     * 得到商品目录列表数据
     */
    List<EasyUITreeNode> getCatList(long parentId);
}
