package com.UTPTd.servicesImpl;

import com.UTPTd.dao.UtpAdminDao;
import com.UTPTd.daoImpl.UtpAdminDaoImpl;
import com.UTPTd.services.UtpAdminServices;

public class UtpAdminServicesImpl implements UtpAdminServices {
	//声明UtpAdminDaoImpl对象
	private static UtpAdminDao UAD = new UtpAdminDaoImpl();

	@Override
	public boolean FindByName(String UtpName) {
		if (UAD.FindByUtpName(UtpName) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean Login(String UtpName, String UtpPassword) {
		if (UtpPassword == UAD.FindPsdByName(UtpName)) {
			return true;
		}else {
			return false;
		}
	}
	
}
