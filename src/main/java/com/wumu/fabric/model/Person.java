package com.wumu.fabric.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author WangZemin
 * @since 2018-08-30
 */
@Data
@ToString
@MappedSuperclass
public abstract class Person extends BaseEntity {

	/*font-awesome:男，1：女*/
	private Integer sex = 0;

	/*用户姓名*/
	private String name = "default";

	/*用户生日*/
	@JSONField(format = "yyyy-MM-dd")
	private Date birthday;

	/*用户邮箱地址*/
	private String email;

	/*用户创建的ip地址*/
	private String ipCreated;

	/*最近一次的登录时间*/
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP", nullable = false)
	private Date timeLastActived;

}
