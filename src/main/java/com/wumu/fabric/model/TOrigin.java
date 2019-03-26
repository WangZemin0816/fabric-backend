package com.wumu.fabric.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author WangZemin
 * @since 2019.03.21
 * 单一组织纹理图数据库实体类
 */
@Data
@ToString
@Entity
public class TOrigin extends EFile {

    /* 纹理图是否为特殊纹理图 */
    private boolean special;

    /* 纹理图分离图url */
    @OneToOne
    @JoinColumn(name="division_id")
    private TDivision tDivision;

}
