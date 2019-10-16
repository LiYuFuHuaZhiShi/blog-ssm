package com.dao;

import com.entity.Type;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    //通过类别进行查询
    Type selectByType(String type);

}