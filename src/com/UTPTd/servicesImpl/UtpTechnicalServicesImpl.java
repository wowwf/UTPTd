package com.UTPTd.servicesImpl;

import org.springframework.stereotype.Component;

import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.UTPTd.services.UtpTechnicalServices;

@Component
public class UtpTechnicalServicesImpl implements UtpTechnicalServices {
	
	private static UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
	
	@Override
	public boolean IsRegister(Integer IdCard) {
		if (UTD.FindByTechnicalIdCard(IdCard) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean IsNameCorrect(Integer IdCard, String Name) {
		if (Name.equals(UTD.FindByTechnicalIdCard(IdCard).getUtpTechnicalName())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean IsHaveSubmit(Integer IdCard) {
		if (UTD.FindSubmitByTechnicalIdCard(IdCard) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean IsPass(Integer IdCard) {
		if (UTD.FindIsPassByTechnicalIdCard(IdCard) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
