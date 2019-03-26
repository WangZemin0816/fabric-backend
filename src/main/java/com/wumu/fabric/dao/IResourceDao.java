package com.wumu.fabric.dao;

import com.wumu.fabric.model.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author WangZemin
 * @since 2018-08-30
 */

@Repository
public interface IResourceDao extends IBaseDao<Resource> {

    Page<Resource> findAllByNameContaining(String searchText, Pageable pageable);

    boolean existsBySourceKey(String sourceKey);

    Optional<Resource> findBySourceKey(String sourceKey);
}
