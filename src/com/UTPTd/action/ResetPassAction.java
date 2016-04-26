package com.UTPTd.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.services.UTPAuditorServices;
import com.UTPTd.servicesImpl.UtpAuditorServicesImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPassAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private String iD;
	private String uName;
	private String passWord;
	
	public String getiD() {
		return iD;
	}
	public String getuName() {
		return uName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	@Override
	public String execute() throws Exception {
		UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
		uServices.doResetPass(iD, uName, passWord);
		return SUCCESS;
	}

}
