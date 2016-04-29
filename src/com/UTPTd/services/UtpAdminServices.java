package com.UTPTd.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpAuditor;

@Component
public interface UtpAdminServices {
	//判断是否存在用户
	boolean FindByName(String UtpName);
	//判断姓名面貌是否相同
	boolean Login(String UtpName, String UtpPassword);
	//判断其他文件是否删除
	boolean DeleteOtherFile(String personFile, String serverPath);
	//返回查询的数据
	List<UtpAuditor> findAllAuditors();
	//返回根据审核人员id查询的信息
	UtpAuditor findAuditor(String idCard);
	//执行更新操作
	void updateAuditor(UtpAuditor utpAuditor);
	//执行删除操作
	void deleteAuditor(String idCard);
	
	void deleteAuditorOpinion(String idCard);
	//添加操作
	void insertAuditor(UtpAuditor utpAuditor);
}
