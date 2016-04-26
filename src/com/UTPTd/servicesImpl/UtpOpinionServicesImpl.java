package com.UTPTd.servicesImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.bean.AuditorOpinion;
import com.UTPTd.dao.OpinionDao;
import com.UTPTd.services.UtpOpinionServices;

@Component
public class UtpOpinionServicesImpl implements UtpOpinionServices {

	private static ApplicationContext aContent = new ClassPathXmlApplicationContext("beans.xml");
	@Override
	public List<AuditorOpinion> findByTidAndAid(String Tid) {
		OpinionDao oDao = aContent.getBean(OpinionDao.class);
		if (oDao.findOpinion(Tid) != null) {
			return oDao.findOpinion(Tid);
		} else {
			return null;
		}
	}

}
