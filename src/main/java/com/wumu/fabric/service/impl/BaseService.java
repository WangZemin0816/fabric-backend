package com.wumu.fabric.service.impl;

import com.wumu.fabric.dao.IBaseDao;
import com.wumu.fabric.model.BaseEntity;
import com.wumu.fabric.service.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public abstract class BaseService<T extends BaseEntity>
        implements IBaseService<T> {

    public abstract IBaseDao<T> getDao();

    public Page<T> findAll(Pageable pageable){
        return getDao().findAll(pageable);
    }

    public T save(T t){
        return getDao().save(t);
    }

    public Optional<T> findById(Long id){
        return getDao().findById(id);
    }
}
