package com.wumu.fabric.dao;

import com.wumu.fabric.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author wangzemin
 * @since 2019-01-27
 */
@Repository
public interface IUserDao extends IBaseDao<User> {

    boolean existsByAccount(String account);

    Optional<User> findByAccount(String account);

}
