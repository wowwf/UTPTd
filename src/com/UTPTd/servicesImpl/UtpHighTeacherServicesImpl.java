package com.UTPTd.servicesImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.UTPTd.services.UtpHighTeacherServices;

@Component
public class UtpHighTeacherServicesImpl implements UtpHighTeacherServices {

	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private static UtpHighTeacherDao UHTD = aContext.getBean(UtpHighTeacherDaoImpl.class);
	
	@Override
	public boolean IsRegister(Integer IdCard) {
		if (UHTD.FindByHighTeacherIdCard(IdCard) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean IsNameCorrect(Integer IdCard, String Name) {
		if (Name.equals(UHTD.FindByHighTeacherIdCard(IdCard).getUtpHighTeacherName())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean IsHaveSubmit(Integer IdCard) {
		if (UHTD.FindSubmitByHighTeacherIdCard(IdCard) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean IsPass(Integer IdCard) {
		if (UHTD.FindIsPassByHighTeacherIdCard(IdCard) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean WhichAudit(Integer IdCard) {
		if (UHTD.FindWitchSubmitByHighTeacherIdCard(IdCard) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean IsLastAudit(Integer IdCard) {
		if (UHTD.FindWitchSubmitByHighTeacherIdCard(IdCard) == 2) {
			return true;
		} else {
			return false;
		}
	}

}
