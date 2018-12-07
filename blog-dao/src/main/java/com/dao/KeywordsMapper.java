package com.dao;

import com.entity.Keywords;

public interface KeywordsMapper {
    int deleteByPrimaryKey(Integer kid);

    int insert(Keywords record);

    int insertSelective(Keywords record);

    Keywords selectByPrimaryKey(Integer kid);

    int updateByPrimaryKeySelective(Keywords record);

    int updateByPrimaryKey(Keywords record);
}