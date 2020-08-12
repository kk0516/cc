package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Cate;
import com.xiaoshu.entity.CateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CateMapper extends BaseMapper<Cate> {
    long countByExample(CateExample example);

    int deleteByExample(CateExample example);

    List<Cate> selectByExample(CateExample example);

    int updateByExampleSelective(@Param("record") Cate record, @Param("example") CateExample example);

    int updateByExample(@Param("record") Cate record, @Param("example") CateExample example);
}