package com.UTPTd.servicesImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.UTPTd.services.UtpTechnicalServices;

@Component
public class UtpTechnicalServicesImpl implements UtpTechnicalServices {
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private static UtpTechnicalDao UTD = aContext.getBean(UtpTechnicalDaoImpl.class);
	
	@Override
	public boolean IsRegister(String IdCard) {
		if (UTD.FindByTechnicalIdCard(IdCard) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean IsNameCorrect(String IdCard, String Name) {
		if (Name.equals(UTD.FindByTechnicalIdCard(IdCard).getUtpTechnicalName())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean IsHaveSubmit(String IdCard) {
		if (UTD.FindSubmitByTechnicalIdCard(IdCard) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean IsPass(String IdCard) {
		if (UTD.FindIsPassByTechnicalIdCard(IdCard) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
