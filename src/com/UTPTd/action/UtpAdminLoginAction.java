package com.UTPTd.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.services.UtpAdminServices;
import com.UTPTd.servicesImpl.UtpAdminServicesImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UtpAdminLoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String utpNameString;
	private String utpPassword;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	public String getUtpNameString() {
		return utpNameString;
	}
	public void setUtpNameString(String utpNameString) {
		this.utpNameString = utpNameString;
	}
	public String getUtpPassword() {
		return utpPassword;
	}
	public void setUtpPassword(String utpPassword) {
		this.utpPassword = utpPassword;
	}
	@Override
	public String execute() throws Exception {
		UtpAdminServices UASI = aContext.getBean(UtpAdminServicesImpl.class);
		if (UASI.FindByName(utpNameString) && UASI.Login(utpNameString, utpPassword)) {
			return SUCCESS;
		} else {
			addFieldError("AdminError", "不存在该管理员！");
			return INPUT;
		}
	}
}
