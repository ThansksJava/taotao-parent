package com.taotao.content.service.impl;

import com.common.pojo.EasyUITreeNode;
import com.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.dao.TbContentCategoryDao;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author fengjie
 * @Description
 * @Date Created in 2018/1/3
 * @Time 14:31
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentCategoryDao contentCategoryDao;
    @Override
    public List<EasyUITreeNode> getContentCategory(Long parentId) {
        TbContentCategoryQuery contentCategoryQuery = new TbContentCategoryQuery();
        TbContentCategoryQuery.Criteria criteria = contentCategoryQuery.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> categoryList = contentCategoryDao.selectByExample(contentCategoryQuery);
        List<EasyUITreeNode> easyUITreeNodes = new ArrayList<>();
        for (TbContentCategory category : categoryList){
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(category.getId());
            easyUITreeNode.setText(category.getName());
            easyUITreeNode.setState(category.getIsParent()?"closed":"open");
            easyUITreeNodes.add(easyUITreeNode);
        }
        return easyUITreeNodes;
    }

    @Override
    public TaotaoResult addCategory(long parentId, String name) {
        Date date = new Date();
        TbContentCategory contentCategory = contentCategoryDao.selectByPrimaryKey(parentId);
        boolean isparent = contentCategory.getIsParent();
        //如果父节点的isParent属性是false才会更新
        if(!isparent){
            contentCategory.setIsParent(true);
            contentCategory.setUpdated(date);
            contentCategoryDao.updateByPrimaryKey(contentCategory);
        }
        TbContentCategory newCate = new TbContentCategory();
        newCate.setIsParent(false);
        newCate.setName(name);
        newCate.setParentId(parentId);
        newCate.setCreated(date);
        newCate.setUpdated(date);
        newCate.setSortOrder(1);
        newCate.setStatus(1);
        contentCategoryDao.insertSelective(newCate);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateCategory(long id, String name) {
        TbContentCategory category = contentCategoryDao.selectByPrimaryKey(id);
        category.setName(name);
        category.setUpdated(new Date());
        contentCategoryDao.updateByPrimaryKey(category);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult deleteCategory(long id) {
        TbContentCategory category = contentCategoryDao.selectByPrimaryKey(id);
        TbContentCategoryQuery queryContentCategoryQuery = new TbContentCategoryQuery();
        TbContentCategoryQuery.Criteria queryCriteria = queryContentCategoryQuery.createCriteria();
        queryCriteria.andParentIdEqualTo(category.getParentId());
        contentCategoryDao.deleteByPrimaryKey(id);
        List<TbContentCategory> categoryList = contentCategoryDao.selectByExample(queryContentCategoryQuery);
        if (categoryList.size()==0){
            TbContentCategory parentCategory = contentCategoryDao.selectByPrimaryKey(category.getParentId());
            parentCategory.setIsParent(false);
            parentCategory.setUpdated(new Date());
            contentCategoryDao.updateByPrimaryKeySelective(parentCategory);
        }
        if(category.getIsParent()){
            TbContentCategoryQuery contentCategoryQuery = new TbContentCategoryQuery();
            TbContentCategoryQuery.Criteria criteria = contentCategoryQuery.createCriteria();
            criteria.andParentIdEqualTo(id);
            contentCategoryDao.deleteByExample(contentCategoryQuery);
        }
        return TaotaoResult.ok();
    }
}
