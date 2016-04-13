package com.UTPTd.servicesImpl;

import com.UTPTd.dao.UtpAuditorDao;
import com.UTPTd.daoImpl.UtpAuditorDaoImpl;
import com.UTPTd.services.UTPAuditorServices;

public class UtpAuditorServicesImpl implements UTPAuditorServices {

	private static UtpAuditorDao UAD = new UtpAuditorDaoImpl();
	
	@Override
	public boolean FindByIdAndRole(Integer IdCard) {
		if (UAD.FindById(IdCard) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean FindPassword(Integer IdCard, Integer Role, String Password) {
		String psdString = UAD.FindPsdById(IdCard);
		Integer roleInteger = UAD.FindRoleById(IdCard);
		if (psdString.equals(Password) && Role == roleInteger) {
			return true;
		} else {
			return false;
		}
	}

}
