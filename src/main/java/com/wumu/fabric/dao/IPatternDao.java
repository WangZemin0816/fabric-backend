package com.wumu.fabric.dao;

import com.wumu.fabric.model.Pattern;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatternDao
        extends IBaseDao<Pattern>  {
}
