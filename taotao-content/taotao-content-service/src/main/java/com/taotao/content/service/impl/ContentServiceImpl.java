package com.taotao.content.service.impl;

import com.common.pojo.EasyUIGridResults;
import com.common.pojo.TaotaoResult;
import com.common.utils.IDUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.content.service.ContentService;
import com.taotao.dao.TbContentDao;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description
 * @Date Created in 2018/1/4
 * @Time 14:37
 */
@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    private TbContentDao tbContentDao = null;
    @Override
    public EasyUIGridResults<TbContent> getContents(long categoryId, int page, int rows) {
        PageHelper.startPage(page,rows);
        TbContentQuery tbContentQuery = new TbContentQuery();
        TbContentQuery.Criteria criteria = tbContentQuery.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        List<TbContent> contents =tbContentDao.selectByExample(tbContentQuery);
        PageInfo<TbContent> pageInfo = new PageInfo<>(contents);
        EasyUIGridResults<TbContent> results = new EasyUIGridResults<>();
        results.setTotal(pageInfo.getTotal());
        results.setRows(contents);
        return results;
    }
    @Override
    public TaotaoResult addContent(TbContent content) {
        content.setId(IDUtils.genItemId());
        Date date = new Date();
        content.setCreated(date);
        content.setUpdated(date);
        tbContentDao.insert(content);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateContent(TbContent content) {
        Date date = new Date();
        content.setUpdated(date);
        tbContentDao.updateByPrimaryKeySelective(content);
        return TaotaoResult.ok();
    }
}
