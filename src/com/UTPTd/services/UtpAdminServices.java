package com.UTPTd.services;

public interface UtpAdminServices {
	//判断是否存在用户
	boolean FindByName(String UtpName);
	//判断姓名面貌是否相同
	boolean Login(String UtpName, String UtpPassword);
}
