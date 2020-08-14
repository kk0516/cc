package com.xiaoshu.controller;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.config.util.ConfigUtil;
import com.xiaoshu.entity.Majortb;
import com.xiaoshu.entity.Operation;
import com.xiaoshu.entity.Role;
import com.xiaoshu.entity.Stutb;
import com.xiaoshu.entity.StutbVo;
import com.xiaoshu.entity.User;
import com.xiaoshu.service.OperationService;
import com.xiaoshu.service.RoleService;
import com.xiaoshu.service.StutbService;
import com.xiaoshu.service.UserService;
import com.xiaoshu.util.StringUtil;
import com.xiaoshu.util.TimeUtil;
import com.xiaoshu.util.WriterUtil;

@Controller
@RequestMapping("stutb")
public class StutbController extends LogController{
	static Logger logger = Logger.getLogger(StutbController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService ;
	
	@Autowired
	private OperationService operationService;
	@Autowired
	private StutbService stutbService;
	
	@RequestMapping("stutbIndex")
	public String index(HttpServletRequest request,Integer menuid) throws Exception{
		List<Role> roleList = roleService.findRole(new Role());
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		List<Majortb> clist=stutbService.findMajortb();
		request.setAttribute("clist",clist);
		request.setAttribute("operationList", operationList);
		request.setAttribute("roleList", roleList);
		return "stutb";
	}
	
	
	@RequestMapping(value="stutbList",method=RequestMethod.POST)
	public void userList(StutbVo stutbVo,HttpServletRequest request,HttpServletResponse response,String offset,String limit) throws Exception{
		try {
			
			String order = request.getParameter("order");
			String ordername = request.getParameter("ordername");
			
			
			Integer pageSize = StringUtil.isEmpty(limit)?ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			PageInfo<StutbVo> userList= stutbService.findUserPage(stutbVo,pageNum,pageSize,ordername,order);
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("total",userList.getTotal() );
			jsonObj.put("rows", userList.getList());
	        WriterUtil.write(response,jsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("用户展示错误",e);
			throw e;
		}
	}
	
	
	// 新增或修改
	@RequestMapping("reserveStutb")
	public void reserveStutb(HttpServletRequest request,Stutb stutb,HttpServletResponse response){
		Integer sId = stutb.getsId();
		JSONObject result=new JSONObject();
		try {
			if (sId != null) {   // userId不为空 说明是修改
				Stutb stutbName = stutbService.existUserWithUserName(stutb.getsName());
				if(stutbName ==null){
					stutb.setsId(sId);
					stutbService.updateUser(stutb);
					result.put("success", true);
				}else{
					result.put("success", true);
					result.put("errorMsg", "该用户名被使用");
				}
				
			}else {   // 添加
				if(stutbService.existUserWithUserName(stutb.getsName())==null){  // 没有重复可以添加
					stutbService.addUser(stutb);
					result.put("success", true);
				} else {
					result.put("success", true);
					result.put("errorMsg", "该用户名被使用");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("保存用户信息错误",e);
			result.put("success", true);
			result.put("errorMsg", "对不起，操作失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	
	@RequestMapping("deleteStutb")
	public void delUser(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (String id : ids) {
				stutbService.deleteUser(Integer.parseInt(id));
			}
			result.put("success", true);
			result.put("delNums", ids.length);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}
	//报表
		@RequestMapping("echartsStutb")
		public void echartsStutb(HttpServletRequest request,HttpServletResponse response){
			JSONObject result=new JSONObject();
			try {
				List<StutbVo> tlist=stutbService.findEchart();
				result.put("tlist", tlist);
				result.put("success", true);
				
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("删除用户信息错误",e);
				result.put("errorMsg", "对不起，删除失败");
			}
			WriterUtil.write(response, result.toString());
		}
		
		//导入
		@RequestMapping("importStutb")
		public void importStutb(MultipartFile stutbXls,HttpServletRequest request,HttpServletResponse response){
			JSONObject result=new JSONObject();
			try {
				//获取webbook
				HSSFWorkbook wb = new HSSFWorkbook(stutbXls.getInputStream());
				//获取sheet页
				HSSFSheet sheet = wb.getSheetAt(0);
				//获取最后一行行数
				int lastRowNum = sheet.getLastRowNum();
				for (int i = 1; i <= lastRowNum; i++) {
					//获取每一行的对象
					HSSFRow row = sheet.getRow(i);
					String sName = row.getCell(0).toString();
					String sSex = row.getCell(1).toString();
					String sHobby = row.getCell(2).toString();
					Date sBirth = row.getCell(3).getDateCellValue();
					String cname = row.getCell(4).toString();
					int mId = stutbService.findCidByCname(cname);
					//封装实体类
					Stutb person = new Stutb();
					person.setsName(sName);
					person.setsSex(sSex);
					person.setsHobby(sHobby);
					person.setsBirth(sBirth);
					person.setmId(mId);
		
					//保存
					stutbService.addUser(person);
				}
				result.put("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("删除用户信息错误",e);
				result.put("errorMsg", "对不起，删除失败");
			}
			WriterUtil.write(response, result.toString());
		}

/**
	 * 备份
	 */
	@RequestMapping("exportStutb")
	public void backup(HttpServletRequest request,HttpServletResponse response){
		JSONObject result = new JSONObject();
		try {
			String time = TimeUtil.formatTime(new Date(), "yyyyMMddHHmmss");
		    String excelName = "手动备份"+time;
		    StutbVo stutbVo=new StutbVo();
			List<StutbVo> list = stutbService.findPage(stutbVo);
			String[] handers = {"编号","学生姓名","性别","爱好","生日","专业"};
			// 1导入硬盘
			ExportExcelToDisk(request,response,handers,list, excelName);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("", "对不起，备份失败");
		}
	/*	WriterUtil.write(response, result.toString());*/
	}
	
	
	

// 导出到硬盘
	@SuppressWarnings("resource")
	private void ExportExcelToDisk(HttpServletRequest request,HttpServletResponse response,
			String[] handers, List<StutbVo> list, String excleName) throws Exception {
		
		try {
			HSSFWorkbook wb = new HSSFWorkbook();//创建工作簿
			HSSFSheet sheet = wb.createSheet("操作记录备份");//第一个sheet
			HSSFRow rowFirst = sheet.createRow(0);//第一个sheet第一行为标题
			rowFirst.setHeight((short) 500);
			for (int i = 0; i < handers.length; i++) {
				sheet.setColumnWidth((short) i, (short) 4000);// 设置列宽
			}
			//写标题了
			for (int i = 0; i < handers.length; i++) {
			    //获取第一行的每一个单元格
			    HSSFCell cell = rowFirst.createCell(i);
			    //往单元格里面写入值
			    cell.setCellValue(handers[i]);
			}
			for (int i = 0;i < list.size(); i++) {
			    //获取list里面存在是数据集对象
				StutbVo vo = list.get(i);
			    //创建数据行
			    HSSFRow row = sheet.createRow(i+1);
			    //设置对应单元格的值
			    row.setHeight((short)400);   // 设置每行的高度
			    //编号","学生姓名","性别","爱好","生日","专业"
			    row.createCell(0).setCellValue(i+1);
			    row.createCell(1).setCellValue(vo.getsName());
			    row.createCell(2).setCellValue(vo.getsSex());
			    row.createCell(3).setCellValue(vo.getsHobby());
			    row.createCell(4).setCellValue(TimeUtil.formatTime(vo.getsBirth(), "yyyy-MM-dd"));			   
			    row.createCell(5).setCellValue(vo.getCname());
			}
			//写出文件（path为文件路径含文件名）
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("学生列表.xls", "UTF-8"));
			response.setHeader("Connection", "close");
			response.setHeader("Content-Type", "application/octet-stream");
	        wb.write(response.getOutputStream());
	        wb.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
	}
	


	
	
	@RequestMapping("editPassword")
	public void editPassword(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		if(currentUser.getPassword().equals(oldpassword)){
			User user = new User();
			user.setUserid(currentUser.getUserid());
			user.setPassword(newpassword);
			try {
				userService.updateUser(user);
				currentUser.setPassword(newpassword);
				session.removeAttribute("currentUser"); 
				session.setAttribute("currentUser", currentUser);
				result.put("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("修改密码错误",e);
				result.put("errorMsg", "对不起，修改密码失败");
			}
		}else{
			logger.error(currentUser.getUsername()+"修改密码时原密码输入错误！");
			result.put("errorMsg", "对不起，原密码输入错误！");
		}
		WriterUtil.write(response, result.toString());
	}
}
