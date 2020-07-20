package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Express;
import com.xiaoshu.entity.ExpressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpressMapper extends BaseMapper<Express> {
    long countByExample(ExpressExample example);

    int deleteByExample(ExpressExample example);

    List<Express> selectByExample(ExpressExample example);

    int updateByExampleSelective(@Param("record") Express record, @Param("example") ExpressExample example);

    int updateByExample(@Param("record") Express record, @Param("example") ExpressExample example);

	List<Express> findPage(Express express);
}