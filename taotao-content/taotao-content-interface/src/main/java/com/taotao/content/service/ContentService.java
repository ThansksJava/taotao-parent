package com.taotao.content.service;

import com.common.pojo.EasyUIGridResults;
import com.common.pojo.EasyUITreeNode;
import com.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author fengjie
 * @Description
 * @Date Created in 2018/1/3
 * @Time 14:16
 */
public interface ContentService {
    /**
     * 得到页面显示内容的管理列表
     * @param parentId
     * @return
     */
    List<EasyUITreeNode> getContentCategory(Long parentId);

    /**
     * 新建内容分类
     * @param parentId
     * @param name
     */
    TaotaoResult addCategory(long parentId, String name);

    /**
     * 更新目录
     * @param id
     * @param name
     * @return
     */
    TaotaoResult updateCategory(long id, String name);

    /**
     * 删除分类
     * @param id
     * @return
     */
    TaotaoResult deleteCategory(long id);
}
