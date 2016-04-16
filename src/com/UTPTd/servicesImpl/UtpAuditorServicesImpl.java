package com.UTPTd.servicesImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.dao.UtpAuditorDao;
import com.UTPTd.daoImpl.UtpAuditorDaoImpl;
import com.UTPTd.services.UTPAuditorServices;

@Component
public class UtpAuditorServicesImpl implements UTPAuditorServices {
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private static UtpAuditorDao UAD = aContext.getBean(UtpAuditorDaoImpl.class);
	
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
