package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.ExpressMapper;
import com.xiaoshu.dao.KuaiMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Express;
import com.xiaoshu.entity.ExpressExample;
import com.xiaoshu.entity.ExpressExample.Criteria;
import com.xiaoshu.entity.Kuai;
import com.xiaoshu.entity.User;

@Service
public class ExpressService {

/*	@Autowired
	UserMapper userMapper;

	// 查询所有
	public List<User> findUser(User t) throws Exception {
		return userMapper.select(t);
	};

	// 数量
	public int countUser(User t) throws Exception {
		return userMapper.selectCount(t);
	};

	// 通过ID查询
	public User findOneUser(Integer id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	};

	// 新增
	public void addUser(User t) throws Exception {
		userMapper.insert(t);
	};

	// 修改
	public void updateUser(User t) throws Exception {
		userMapper.updateByPrimaryKeySelective(t);
	};

	// 删除
	public void deleteUser(Integer id) throws Exception {
		userMapper.deleteByPrimaryKey(id);
	};

	// 登录
	public User loginUser(User user) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPasswordEqualTo(user.getPassword()).andUsernameEqualTo(user.getUsername());
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};
;

	// 通过角色判断是否存在
	public User existUserWithRoleId(Integer roleId) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	}
*/
	@Autowired
	private ExpressMapper expressMapper;
	@Autowired
	private KuaiMapper kuaiMapper;
	
	public PageInfo<Express> findUserPage(Express express, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		ordername = StringUtil.isNotEmpty(ordername)?ordername:"userid";
		order = StringUtil.isNotEmpty(order)?order:"desc";
	
		ExpressExample example=new ExpressExample();
		Criteria createCriteria = example.createCriteria();
		List<Express> elist=expressMapper.findPage(express);
		PageInfo<Express> pageInfo = new PageInfo<Express>(elist);
		return pageInfo;
	}

	public List<Kuai> findAllDept() {
		// TODO Auto-generated method stub
		return kuaiMapper.selectAll();
	}
	// 新增
	public void addExpress(Express t) throws Exception {
		expressMapper.insert(t);
	};

	// 修改
	public void updateExpress(Express t) throws Exception {
		expressMapper.updateByPrimaryKeySelective(t);
	};

	// 删除
	public void deleteExpress(Integer id) throws Exception {
		expressMapper.deleteByPrimaryKey(id);
	};

	// 通过用户名判断是否存在，（新增时不能重名）
	public Express existUserWithUserName(String userName) throws Exception {
		ExpressExample example = new ExpressExample();
		Criteria criteria = example.createCriteria();
		criteria.andENameEqualTo(userName);
		List<Express> userList = expressMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	}

}
