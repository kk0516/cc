package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Kuai;
import com.xiaoshu.entity.KuaiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KuaiMapper extends BaseMapper<Kuai> {
    long countByExample(KuaiExample example);

    int deleteByExample(KuaiExample example);

    List<Kuai> selectByExample(KuaiExample example);

    int updateByExampleSelective(@Param("record") Kuai record, @Param("example") KuaiExample example);

    int updateByExample(@Param("record") Kuai record, @Param("example") KuaiExample example);
}