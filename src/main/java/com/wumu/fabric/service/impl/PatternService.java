package com.wumu.fabric.service.impl;

import com.wumu.fabric.dao.IBaseDao;
import com.wumu.fabric.dao.IPatternDao;
import com.wumu.fabric.model.Pattern;
import com.wumu.fabric.service.IPatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatternService extends EFileService<Pattern>
        implements IPatternService {

    @Autowired
    private IPatternDao patternDao;

    @Override
    public IBaseDao<Pattern> getDao(){
        return patternDao;
    }
}
