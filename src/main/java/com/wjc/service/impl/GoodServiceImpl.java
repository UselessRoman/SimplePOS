package com.wjc.service.impl;

import com.wjc.dao.GoodDao;
import com.wjc.domain.Good;
import com.wjc.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDao goodDao;

    @Override
    public List<Good> findGoodsBySupermarket(String supermarket) {
        return goodDao.findGoodsBySupermarket(supermarket);
    }
}
