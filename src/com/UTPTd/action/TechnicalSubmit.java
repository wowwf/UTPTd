package com.UTPTd.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class TechnicalSubmit extends ActionSupport {

	/**
	 * 技术人员申报职称个人信息填写及提交
	 */
	private static final long serialVersionUID = 1L;

	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private UtpTechnical utpTechnical = aContext.getBean(UtpTechnical.class);
	
	public UtpTechnical getUtpTechnical() {
		return utpTechnical;
	}

	public void setUtpTechnical(UtpTechnical utpTechnical) {
		this.utpTechnical = utpTechnical;
	}


	@Override
	public String execute() throws Exception {
		UtpTechnicalDao utpTechnicalDao = aContext.getBean(UtpTechnicalDaoImpl.class);
		utpTechnicalDao.UpdateTechnical(utpTechnical);
		return SUCCESS;
	}
}
