package com.taotao.dao;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemQuery;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbItemDao {
    int countByExample(TbItemQuery example);

    int deleteByExample(TbItemQuery example);

    int deleteByPrimaryKey(Long id);

    /**
     * 批量或单个删除商品
     * @param ids
     * @return
     */
    int deleteByPrimaryKeys(String...ids);
    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemQuery example);

    TbItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemQuery example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemQuery example);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    /**
     * 更新商品状态 上架 or 下架
     * @param map
     * @return
     */
    int batchUpdateStatus(Map<String,Object> map);
}