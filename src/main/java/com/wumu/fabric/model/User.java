package com.wumu.fabric.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * @author
 */
@Data
@ToString
@Entity
public class User extends Person {

    /*用户登录所用的账户名*/
    @Column(unique = true)
    private String account;

    /*用户登录所用的密码*/
    @JsonIgnore
    private String password;

    /*用户是否被锁定的标记*/
    private Boolean locked = Boolean.FALSE;

    /*用户所对应的角色列表*/
    @ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole",
            joinColumns = { @JoinColumn(name = "userId", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "roleId", referencedColumnName = "id") })
    private Set<Role> roles;


    public interface Status {
        int DISABLED = 0;
        int VALID = 1;
        int LOCKED = 2;
    }

}
