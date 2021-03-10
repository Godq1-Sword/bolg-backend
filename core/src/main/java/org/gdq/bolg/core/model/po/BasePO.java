package org.gdq.bolg.core.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * 基础PO
 *
 * @author gdq
 * date 2021/1/7
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BasePO {
    // 主键
    private Integer id;
    // 创建时间
    private Date    createTime;
    // 修改时间
    private Date    updateTime;
}