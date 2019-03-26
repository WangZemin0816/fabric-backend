package com.wumu.fabric.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author WangZemin
 * @since 2018-08-30
 */
@Data
@ToString
@Entity
public class Resource extends BaseEntity {

    /* 资源名称 */
    private String name;

    /*  资源类型 */
    @Column(unique = true)
    private String sourceKey;

    /* 资源类型,font-awesome:目录;1:菜单;2:按钮*/
    private Integer type;

    /* 资源url */
    private String sourceUrl;

    /* 资源层级 */
    private Integer level;

    /*排序*/
    private Integer sort;

    /*资源对应的图标*/
    private String icon;

    /*是否隐藏，0显示 1隐藏*/
    private Integer isHide=0;

    /*资源的父资源*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Resource parent;

//    /*权限对应的角色列表*/
//    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
//    @JoinTable(name = "RoleResource",
//            joinColumns = {@JoinColumn(name = "resourceId", referencedColumnName = "id")} ,
//            inverseJoinColumns = {@JoinColumn(name = "roleId", referencedColumnName = "id")})
//    private Set<Role> roles;

}