package com.taotao.content.service;

import com.common.pojo.EasyUIGridResults;
import com.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description
 * @Date Created in 2018/1/4
 * @Time 14:32
 */
public interface ContentService {
    /**
     * 得到category下的内容信息
     * @param categoryId
     * @param page
     * @param rows
     * @return
     */
    EasyUIGridResults<TbContent> getContents(long categoryId,int page,int rows);

    /**
     * 添加内容
     * @param content
     * @return
     */
    TaotaoResult addContent(TbContent content);
    /**
     * 更新内容
     * @param content
     * @return
     */
    TaotaoResult updateContent(TbContent content);
}
