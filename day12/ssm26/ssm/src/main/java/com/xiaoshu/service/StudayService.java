package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xiaoshu.dao.MajordayMapper;
import com.xiaoshu.dao.StudayMapper;
import com.xiaoshu.entity.Majorday;
import com.xiaoshu.entity.Studay;
import com.xiaoshu.entity.StudayExample;
import com.xiaoshu.entity.StudayExample.Criteria;
import com.xiaoshu.entity.StudayVo;

@Service
public class StudayService {

	/*@Autowired
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
	}
*/
	@Autowired
	private StudayMapper studayMapper;
	@Autowired
	private MajordayMapper majordayMapper;
	
	public PageInfo<StudayVo> findUserPage(StudayVo studayVo, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<StudayVo> userList = studayMapper.findPage(studayVo);
		PageInfo<StudayVo> pageInfo = new PageInfo<StudayVo>(userList);
		return pageInfo;
	}
	// 新增
		public void addUser(Studay t) throws Exception {
			studayMapper.insert(t);
		};

		// 修改
		public void updateUser(Studay t) throws Exception {
			studayMapper.updateByPrimaryKeySelective(t);
		};

		// 删除
		public void deleteUser(Integer id) throws Exception {
			studayMapper.deleteByPrimaryKey(id);
		};


		// 通过用户名判断是否存在，（新增时不能重名）
		public Studay existUserWithUserName(String userName) throws Exception {
			StudayExample example = new StudayExample();
			Criteria criteria = example.createCriteria();
			criteria.andSdnameEqualTo(userName);
			List<Studay> userList = studayMapper.selectByExample(example);
			return userList.isEmpty()?null:userList.get(0);
		}
		public List<Majorday> findMajorday() {
			// TODO Auto-generated method stub
			return majordayMapper.selectAll();
		}
		public List<StudayVo> findPage(StudayVo studayVo) {
			// TODO Auto-generated method stub
			return studayMapper.findPage(studayVo);
		}
		/*public int findCidByCname(String cname) {
			ExpressCompany company = new ExpressCompany();
			company.setExpressName(cname);
			ExpressCompany one = expressCompanyMapper.selectOne(company);
			return one.getId();
		}*/
		public int findCidByCname(String dname) {
			Majorday majorday = new Majorday();
			majorday.setMdname(dname);
			Majorday one = majordayMapper.selectOne(majorday);
			return one.getMdId();
		}
		public List<StudayVo> findEchart() {
			// TODO Auto-generated method stub
			return studayMapper.findEchart();
		}
	

}
