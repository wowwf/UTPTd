package com.UTPTd.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpAdmin;
import com.UTPTd.bean.UtpAuditor;

@Component
public interface UtpAdminDao {
	UtpAdmin FindByUtpName(String UtpName);
	
	String FindPsdByName(String UtpName);
	//检索教师表的文件路径，把服务器中的冗余文件删除
	String FindUseFromTeacher();
	
	String FindUseOtherFileTeacher();
	//检索技术人员的文件路径，把服务器中的冗余文件删除 同上
	String FindUseFromTechnical();
	
	String FindUseOtherFileTechnical();
	//对审核人员进行操作
	//检索审核所有人员
	List<UtpAuditor> FindAll();
	//增加审核人员
	void insertAuditor(UtpAuditor utpAuditor);
	//修改审核人员权限
	void updateAuditor(UtpAuditor utpAuditor);
	//删除审核人员
	void deleteAuditor(String IdCard);
	
	void deleteAuditorOpinion(String IdCard);
	//查询用户是否已存在
	UtpAuditor selectAuditor(String IdCard);
}
