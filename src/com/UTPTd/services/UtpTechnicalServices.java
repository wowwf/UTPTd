package com.UTPTd.services;

import org.springframework.stereotype.Component;

@Component
public interface UtpTechnicalServices {
	//判断该登录用户是否已经在本系统注册或者已经有审核记录
	boolean IsRegister(Integer IdCard);
	//判断密码是否符合
	boolean IsNameCorrect(Integer IdCard, String Name);
	//判断该用户是否已经有审核申请
	boolean IsHaveSubmit(Integer IdCard);
	//判断用户是否审核通过
	boolean IsPass(Integer IdCard);
}
