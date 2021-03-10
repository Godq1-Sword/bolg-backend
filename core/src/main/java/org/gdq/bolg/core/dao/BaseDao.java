package org.gdq.bolg.core.dao;

import java.util.List;
import java.util.Map;

/**
 * @author gdq
 * date 2021/1/7
 * description 基础Dao
 */
public interface BaseDao<T> {
    /**
     * 插入单条数据
     *
     * @param t 数据
     * @return Integer 主键
     * @author gdq 2021/1/7
     */
    Integer insert(T t);

    /**
     * 批量插入数据
     *
     * @param ts 数据
     * @return Integer 插入条数
     * @author gdq 2021/1/7
     */
    Integer insertBatch(List<T> ts);

    /**
     * 删除数据
     *
     * @param id 主键
     * @return Integer 主键
     * @author gdq 2021/1/7
     */
    Integer delete(Integer id);

    /**
     * 根据条件删除数据
     *
     * @param param 条件
     * @return Integer 删除条数
     * @author gdq 2021/1/7
     */
    Integer deleteByParam(Map<String, Object> param);

    /**
     * 删除所有数据
     *
     * @return Integer 删除条数
     * @author gdq 2021/1/7
     */
    Integer deleteAll();

    /**
     * 更新单条数据
     *
     * @param t 数据
     * @return Integer 更新条数
     * @author gdq 2021/1/7
     */
    Integer update(T t);

    /**
     * 根据条件查询数据
     *
     * @param param 查询条件
     * @return List 数据List
     * @author gdq 2021/1/7
     */
    List<T> selectByParam(Map<String, Object> param);

    /**
     * 查询所有数据
     *
     * @return List 数据List
     * @author gdq 2021/1/7
     */
    List<T> selectAll();

}

