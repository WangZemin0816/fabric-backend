package com.wumu.fabric.service;

import com.wumu.fabric.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBaseService<T extends BaseEntity> {

    Page<T> findAll(Pageable pageable);

    T save(T t);

    Optional<T> findById(Long id);
}
