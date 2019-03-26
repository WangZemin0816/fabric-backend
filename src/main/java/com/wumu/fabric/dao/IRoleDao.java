package com.wumu.fabric.dao;


import com.wumu.fabric.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author WangZemin
 * @since 2018-08-30
 */
@Repository
public interface IRoleDao extends IBaseDao<Role> {

    Page<Role> findAllByNameContaining(String searchText, Pageable pageable);

    boolean existsByRoleKey(String roleKey);

    Optional<Role> findByRoleKey(String roleKey);
}
