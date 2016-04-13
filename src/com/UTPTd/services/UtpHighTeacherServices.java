package com.UTPTd.services;

public interface UtpHighTeacherServices {
	//判断该登录用户是否已经在本系统注册或者已经有审核记录
	boolean IsRegister(Integer IdCard);
	//判断密码是否符合
	boolean IsNameCorrect(Integer IdCard, String Name);
	//判断该用户是否已经有审核申请
	boolean IsHaveSubmit(Integer IdCard);
	//判断用户是否审核通过
	boolean IsPass(Integer IdCard);
	//判断是否过院系审核
	boolean WhichAudit(Integer IdCard);
	//判断是否过人事审核
	boolean IsLastAudit(Integer IdCard);
}
