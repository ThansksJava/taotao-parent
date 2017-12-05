package com.taotao.service.impl;

import com.common.pojo.EasyUIGridResults;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.dao.TbItemDao;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemQuery;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description
 * @Date Created in 2017/12/2
 * @Time 9:23
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemDao tbItemDao;
    @Override
    public TbItem getItemById(Long id) {
        return tbItemDao.selectByPrimaryKey(id);
    }

    @Override
    public EasyUIGridResults<TbItem> getItems(int page,int rows) {
        PageHelper.startPage(page, rows);
        TbItemQuery tbItemQuery = new TbItemQuery();
        List<TbItem> items =  tbItemDao.selectByExample(tbItemQuery);
        PageInfo<TbItem> pageInfo = new PageInfo<>(items);
        EasyUIGridResults<TbItem> results = new EasyUIGridResults<>();
        results.setTotal(pageInfo.getTotal());
        results.setRows(items);
        return results;
    }
}
