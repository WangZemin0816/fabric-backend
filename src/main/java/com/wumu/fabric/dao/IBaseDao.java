package com.wumu.fabric.dao;


import com.wumu.fabric.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author wangzemin
 * @since 2019-01-27
 */
@NoRepositoryBean
public interface IBaseDao<T extends BaseEntity>
        extends JpaRepository<T, Long> {
}
