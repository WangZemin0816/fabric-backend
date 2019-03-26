package com.wumu.fabric.service.impl;

import com.wumu.fabric.dao.IBaseDao;
import com.wumu.fabric.dao.IPDesignDao;
import com.wumu.fabric.dao.ITDesignDao;
import com.wumu.fabric.model.PDesign;
import com.wumu.fabric.model.Pattern;
import com.wumu.fabric.model.TDesign;
import com.wumu.fabric.service.IPatternService;
import com.wumu.fabric.service.ITDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TDesignService  extends EFileService<TDesign>
        implements ITDesignService {
    @Autowired
    private ITDesignDao tdesignDao;

    @Override
    public IBaseDao<TDesign> getDao(){
        return tdesignDao;
    }
}
