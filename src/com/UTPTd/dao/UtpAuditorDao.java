package com.UTPTd.dao;

import com.UTPTd.bean.UtpAuditor;

public interface UtpAuditorDao {
	//根据身份证号查询是否有这个用户
	UtpAuditor FindById(Integer IdCard);
	//根据身份证号查询该用户的密码
	String FindPsdById(Integer IdCard);
	//根据身份证号查询用户权限
	Integer FindRoleById(Integer IdCard);
}
