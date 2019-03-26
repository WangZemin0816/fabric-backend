package com.wumu.fabric.service.impl;

import com.wumu.fabric.dao.IBaseDao;
import com.wumu.fabric.dao.ITOriginDao;
import com.wumu.fabric.model.TOrigin;
import com.wumu.fabric.service.ITOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class TOriginService extends EFileService<TOrigin>
            implements ITOriginService {
    @Autowired
    private ITOriginDao toriginDao;

    @Override
    public IBaseDao<TOrigin> getDao(){
        return toriginDao;
    }


}
