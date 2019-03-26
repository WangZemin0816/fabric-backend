package com.wumu.fabric.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * @author WangZemin
 * @since 2018-08-30
 */
@Data
@ToString
@Entity
public class Role extends BaseEntity {

    /*角色对应的名字*/
    private String name;

    /*角色标识 程序中判断使用,如"manager"*/
    @Column(unique = true)
    private String roleKey;

    /*角色是否可用*/
    private Boolean available = Boolean.TRUE; // 是否可用,如果不可用将不会添加给用户

    /*角色对应的权限列表*/
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "RoleResource",
            joinColumns = {@JoinColumn(name = "roleId", referencedColumnName = "id")} ,
            inverseJoinColumns = {@JoinColumn(name = "resourceId", referencedColumnName = "id")})
    private Set<Resource> resources;

//    /*角色对应的用户列表*/
//    @ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
//    @JoinTable(name = "UserRole",
//            joinColumns = { @JoinColumn(name = "roleId", referencedColumnName = "id") },
//            inverseJoinColumns = {@JoinColumn(name = "userId", referencedColumnName = "id")})
//    private Set<User> users;
}
