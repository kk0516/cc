package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.MajortbMapper;
import com.xiaoshu.dao.StutbMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Majortb;
import com.xiaoshu.entity.Stutb;
import com.xiaoshu.entity.StutbExample;
import com.xiaoshu.entity.StutbExample.Criteria;
import com.xiaoshu.entity.StutbVo;

@Service
public class StutbService {

	@Autowired
	private StutbMapper stutbMapper;
	@Autowired
	private MajortbMapper majortbMapper;
	// 新增
	public void addUser(Stutb t) throws Exception {
		stutbMapper.insert(t);
	};

	// 修改
	public void updateUser(Stutb t) throws Exception {
		stutbMapper.updateByPrimaryKeySelective(t);
	};

	// 删除
	public void deleteUser(Integer id) throws Exception {
		stutbMapper.deleteByPrimaryKey(id);
	};

	
	// 通过用户名判断是否存在，（新增时不能重名）
	public Stutb existUserWithUserName(String userName) throws Exception {
		StutbExample example = new StutbExample();
		Criteria criteria = example.createCriteria();
		criteria.andSNameEqualTo(userName);
		List<Stutb> userList = stutbMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};


	public PageInfo<StutbVo> findUserPage(StutbVo stutbVo, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<StutbVo> userList = stutbMapper.findPage(stutbVo);
		PageInfo<StutbVo> pageInfo = new PageInfo<StutbVo>(userList);
		return pageInfo;
	}

	public List<Majortb> findMajortb() {
		// TODO Auto-generated method stub
		return majortbMapper.selectAll();
	}

	public List<StutbVo> findPage(StutbVo stutbVo) {
		// TODO Auto-generated method stub
		return stutbMapper.findPage(stutbVo);
	}

	public List<StutbVo> findEchart() {
		// TODO Auto-generated method stub
		return stutbMapper.findEchart();
	}

	public int findCidByCname(String cname) {
		Majortb majortb = new Majortb();
		majortb.setmName(cname);
		Majortb one = majortbMapper.selectOne(majortb);
		return one.getmId();
	}
/*	public int findCidByCname(String cname) {
		ExpressCompany company = new ExpressCompany();
		company.setExpressName(cname);
		ExpressCompany one = expressCompanyMapper.selectOne(company);
		return one.getId();
	}*/

	


}
