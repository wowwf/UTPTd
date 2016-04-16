package com.UTPTd.dao;

import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpAdmin;

@Component
public interface UtpAdminDao {
	UtpAdmin FindByUtpName(String UtpName);
	
	String FindPsdByName(String UtpName);
	//检索教师表的文件路径，把服务器中的冗余文件删除 0:删除失败；1:删除成功
	String FindUseFromTeacher();
	
	String FindUseOtherFileTeacher();
	//检索技术人员的文件路径，把服务器中的冗余文件删除 同上
	String FindUseFromTechnical();
	
	String FindUseOtherFileTechnical();
}
