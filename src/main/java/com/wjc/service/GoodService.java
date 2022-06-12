package com.wjc.service;

import com.wjc.domain.Good;

import java.util.List;

public interface GoodService
{

    List<Good> findGoodsBySupermarket(String supermarket);
}
