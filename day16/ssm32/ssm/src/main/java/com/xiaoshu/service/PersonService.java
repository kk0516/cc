package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xiaoshu.dao.BankMapper;
import com.xiaoshu.dao.PersonMapper;
import com.xiaoshu.entity.Bank;
import com.xiaoshu.entity.Person;
import com.xiaoshu.entity.PersonExample;
import com.xiaoshu.entity.PersonExample.Criteria;
import com.xiaoshu.entity.PersonVo;

@Service
public class PersonService {
/*
	@Autowired
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

	// 通过用户名判断是否存在，（新增时不能重名）
	public User existUserWithUserName(String userName) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	// 通过角色判断是否存在
	public User existUserWithRoleId(Integer roleId) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	}*/
@Autowired
private PersonMapper personMapper;
@Autowired
private BankMapper bankMapper;
	public PageInfo<PersonVo> findUserPage(PersonVo personVo, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<PersonVo> userList = personMapper.findPage(personVo);
		PageInfo<PersonVo> pageInfo = new PageInfo<PersonVo>(userList);
		return pageInfo;
	}

	// 新增
		public void addUser(Person t) throws Exception {
			personMapper.insert(t);
		};

		// 修改
		public void updateUser(Person t) throws Exception {
			personMapper.updateByPrimaryKeySelective(t);
		};

		// 删除
		public void deleteUser(Integer id) throws Exception {
			personMapper.deleteByPrimaryKey(id);
		};

	

		// 通过用户名判断是否存在，（新增时不能重名）
		public Person existUserWithUserName(String userName) throws Exception {
			PersonExample example = new PersonExample();
			Criteria criteria = example.createCriteria();
			criteria.andPNameEqualTo(userName);
			List<Person> userList = personMapper.selectByExample(example);
			return userList.isEmpty()?null:userList.get(0);
		}

		public List<Bank> findBank() {
			// TODO Auto-generated method stub
			return bankMapper.selectAll();
		}
		/*public int findCidByCname(String cname) {
			ExpressCompany company = new ExpressCompany();
			company.setExpressName(cname);
			ExpressCompany one = expressCompanyMapper.selectOne(company);
			return one.getId();
		}*/
		public int findCidByCname(String cname) {
		Bank bank=new Bank();
		bank.setbName(cname);
		Bank one = bankMapper.selectOne(bank);
			return one.getbId();
		}

	
		public List<PersonVo> getEcharts() {
			// TODO Auto-generated method stub
			return personMapper.getEcharts();
		};
}
