package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Stutb;
import com.xiaoshu.entity.StutbExample;
import com.xiaoshu.entity.StutbVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StutbMapper extends BaseMapper<Stutb> {
    long countByExample(StutbExample example);

    int deleteByExample(StutbExample example);

    List<Stutb> selectByExample(StutbExample example);

    int updateByExampleSelective(@Param("record") Stutb record, @Param("example") StutbExample example);

    int updateByExample(@Param("record") Stutb record, @Param("example") StutbExample example);

	List<StutbVo> findPage(StutbVo stutbVo);

	List<StutbVo> findEchart();



}