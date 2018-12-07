package com.dao;

import com.entity.Content;

public interface ContentMapper {
    int deleteByPrimaryKey(Integer conid);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Integer conid);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKeyWithBLOBs(Content record);
}