package com.taotao.service.impl;

import com.common.pojo.EasyUITreeNode;
import com.taotao.dao.TbItemCatDao;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatQuery;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description
 * @Date Created in 2017/12/5
 * @Time 14:14
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    TbItemCatDao tbItemCatDao = null;
    @Override
    public List<EasyUITreeNode> getCatList(long parentId) {
        TbItemCatQuery tbItemCatQuery = new TbItemCatQuery();
        TbItemCatQuery.Criteria criteria = tbItemCatQuery.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> cats = tbItemCatDao.selectByExample(tbItemCatQuery);
        List<EasyUITreeNode> list = new ArrayList<>();
        for (TbItemCat cat : cats){
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(cat.getId());
            node.setText(cat.getName());
            if(cat.getIsParent()){
                node.setState("closed");
            }else {
                node.setState("open");
            }
            list.add(node);
        }
        return list;
    }
}
