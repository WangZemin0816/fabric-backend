package com.wumu.fabric.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.MappedSuperclass;

/**
 * @author WangZemin
 * @since 2019.03.21
 * 图片数据库实体类
 */
@Data
@ToString
@MappedSuperclass
public abstract class EFile extends BaseEntity{

    /* 图片地址 */
    private String url;

    /* 图片地址的类型,false表示相对地址,true表示绝对地址*/
    private boolean urlType;

    /* 图片名称 */
    private String name;

}
