package com.taotao.service.impl;

import com.common.pojo.EasyUIGridResults;
import com.common.pojo.TaotaoResult;
import com.common.utils.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.dao.TbItemDao;
import com.taotao.dao.TbItemDescDao;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemQuery;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    private TbItemDescDao tbItemDescDao;
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

    @Override
    public TaotaoResult saveItem(TbItem item, String desc) {
        Long id = IDUtils.genItemId();
        item.setId(id);
        //商品状态，1-正常，2-下架，3-删除
        //神经病，搞个byte类型干嘛
        item.setStatus((byte)1);
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(id);
        itemDesc.setCreated(date);
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(date);
        tbItemDao.insert(item);
        tbItemDescDao.insert(itemDesc);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateItem(TbItem item, String desc) {
        Date date = new Date();
        item.setUpdated(date);
        item.setStatus((byte)1);
        tbItemDao.updateByPrimaryKey(item);
        return TaotaoResult.ok();
    }
}
