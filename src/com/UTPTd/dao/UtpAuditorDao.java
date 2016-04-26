package com.UTPTd.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.util.Page;

@Component
public interface UtpAuditorDao {
	//根据身份证号查询是否有这个用户
	UtpAuditor FindById(String IdCard);
	//根据身份证号查询该用户的密码
	String FindPsdById(String IdCard);
	//根据身份证号查询用户权限
	Integer FindRoleById(String IdCard);
	//查询所有教师参与审核人员的未通过院系审核的姓名，身份证号码，申报职称，目前职位
	List<UtpHighTeacher> getList(Page page);
	
	Integer getListCount();
	//查询所有教师参与审核人员的已通过院系审核的姓名，身份证号码，申报职称，目前职位
	List<UtpHighTeacher> getTeachers(Page page);
	
	Integer getTeachersCount();
	//查询所有参与审核人员的技术人员姓名，身份证号码，申报职称，目前职位
	List<UtpTechnical> getTechnicals(Page page);
	
	Integer getTechnicalsCount();
	//限定职务进行姓名模糊查询
	List<UtpHighTeacher> getTeacherLikeName(String Name, Page page);
	
	Integer getTeacherLikeNameCount(String Name);
	
	List<UtpTechnical> getTechnicalLikeName(String Name, Page page);
	
	Integer getTechnicalLikeNameCount(String Name);
	//限定职务进行身份证号码模糊查询
	List<UtpHighTeacher> getHighTeacherLikeId(String IdCard, Page page);
	
	Integer getHighTeacherLikeIdCount(String IdCard);
	
	List<UtpTechnical> getTechnicalLikeId(String IdCard, Page page);
	
	Integer getTechnicalLikeIdCount(String IdCard);
	//查找是否存在
	UtpAuditor SelectByIdName(String Id, String Name);
	//修改密码
	void updatePassByIdName(String Id, String Name, String pass);
}
