package com.UTPTd.dao;

import com.UTPTd.bean.UtpAdmin;

public interface UtpAdminDao {
	UtpAdmin FindByUtpName(String UtpName);
	
	String FindPsdByName(String UtpName);
}
