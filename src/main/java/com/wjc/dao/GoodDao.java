package com.wjc.dao;

import com.wjc.domain.Good;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodDao
{


    @Select("select name,price from goods" +
            " where supermarket = #{supermarket}")
    List<Good> findGoodsBySupermarket(String supermarket);
}
