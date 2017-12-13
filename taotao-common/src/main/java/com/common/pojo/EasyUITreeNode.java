package com.common.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description EasyUI树形目录数据模型
 * @Date Created in 2017/12/5
 * @Time 14:11
 */
@Data
@NoArgsConstructor
public class EasyUITreeNode implements Serializable{
    private long id;
    private String text;
    private String state;
}
