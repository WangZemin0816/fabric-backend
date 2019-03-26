package com.wumu.fabric.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author WangZemin
 * @since 2018-08-30
 */
@Data
@ToString
@MappedSuperclass //会被子类继承
public abstract class BaseEntity implements Serializable {

    /*每个数据记录都有一个主键ID,自动生成*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    /*数据库乐观锁标志，用于提高并发访问效率*/
    @Version
    private Long version;

    /*记录是否被删除*/
    private Boolean deleted=Boolean.FALSE;

    /*记录创建的时间*/
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP", nullable = false)
    private Date createdTime = new Date();;

    /*记录的更新时间*/
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP", nullable = false)
    private Date updateTime = new Date();;

    /*记录的描述信息*/
    private String description="";

    /*记录的备注信息*/
    private String remark="";

}
