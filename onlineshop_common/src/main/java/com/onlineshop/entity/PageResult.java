package com.onlineshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * @Author CrystalLight
 * @Date 2019/12/18 9:02
 * @Version 1.0
 * @Description
 *
 * * 分页
 *  *      {
 *  *          “success”：“成功”，
 *  *          “code”：10000
 *  *          “message”：“ok”，
 *  *          ”data“：{
 *  *              total：//总条数
 *  *              rows ：//数据列表
 *  *          }
 *  *      }
 *  *
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}
