package com.common.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * @Author fengjie
 * @Description
 * @Date Created in 2017/12/5
 * @Time 12:52
 */
@Data
@NoArgsConstructor
public class EasyUIGridResults<T> implements Serializable {
    private long total;
    private List<T> rows;
}
