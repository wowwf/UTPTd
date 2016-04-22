package com.UTPTd.services;

import org.springframework.stereotype.Component;

import com.UTPTd.util.Page;
import com.UTPTd.util.PageResult;

@Component
public interface UTPAuditorServices {
	//判断是否存在这个审核人员
	boolean FindByIdAndRole(Integer IdCard);
	//判断审核人员登录信息是否对应
	boolean FindPassword(Integer IdCard, Integer Role, String Password);
	//根据分页显示查询教师未通过院系审核的人员
	PageResult QueryTeacher(Page page);
	//根据分页显示查询教师未通过人事审核的人员
	PageResult QueryTeachers(Page page);
	//根据分页显示查询未通过审核的技术人员
	PageResult QueryTechnical(Page page);
	//根据分页查询教师的模糊查询
	PageResult LikeQueryTeacher(String Name, Page page);
	
	PageResult LikeQueryTeacherById(Integer IdCard, Page page);
	//根据分页查询技术人员的模糊查询
	PageResult LikeQueryTechnical(String Name, Page page);
	
	PageResult LikeQueryTechnicalById(Integer IdCard, Page page);
	//判断是否存在
	boolean isRegiest(Integer iD, String uName);
	//修改密码
	void doResetPass(Integer iD, String Name, String passWord);
}
