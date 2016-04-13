package com.UTPTd.services;

public interface UTPAuditorServices {
	//判断是否存在这个审核人员
	boolean FindByIdAndRole(Integer IdCard);
	//判断审核人员登录信息是否对应
	boolean FindPassword(Integer IdCard, Integer Role, String Password);
}
