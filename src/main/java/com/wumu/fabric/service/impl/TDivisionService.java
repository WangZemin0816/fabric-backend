package com.wumu.fabric.service.impl;

import com.wumu.fabric.dao.IBaseDao;
import com.wumu.fabric.dao.ITDesignDao;
import com.wumu.fabric.dao.ITDivisionDao;
import com.wumu.fabric.model.TDivision;
import com.wumu.fabric.service.ITDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TDivisionService extends EFileService<TDivision>
        implements ITDivisionService {

    @Autowired
    private ITDivisionDao tDivisionDao;

    @Override
    public IBaseDao<TDivision> getDao(){
        return tDivisionDao;
    }

}
