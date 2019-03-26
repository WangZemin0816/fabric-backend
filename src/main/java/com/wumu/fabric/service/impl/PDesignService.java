package com.wumu.fabric.service.impl;

import com.wumu.fabric.dao.IBaseDao;
import com.wumu.fabric.dao.IPDesignDao;
import com.wumu.fabric.model.PDesign;
import com.wumu.fabric.service.IPDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PDesignService extends EFileService<PDesign>
        implements IPDesignService {
    @Autowired
    private IPDesignDao pdesignDao;

    @Override
    public IBaseDao<PDesign> getDao(){
        return pdesignDao;
    }
}
