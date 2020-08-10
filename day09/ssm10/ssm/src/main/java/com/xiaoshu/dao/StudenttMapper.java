package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Studentt;
import com.xiaoshu.entity.StudenttExample;
import com.xiaoshu.entity.StudenttVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudenttMapper extends BaseMapper<Studentt> {
    long countByExample(StudenttExample example);

    int deleteByExample(StudenttExample example);

    List<Studentt> selectByExample(StudenttExample example);

    int updateByExampleSelective(@Param("record") Studentt record, @Param("example") StudenttExample example);

    int updateByExample(@Param("record") Studentt record, @Param("example") StudenttExample example);

	List<StudenttVo> findPage(StudenttVo studenttVo);

	List<StudenttVo> findEcharts();
}