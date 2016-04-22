package com.UTPTd.MidAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.services.UTPAuditorServices;
import com.UTPTd.servicesImpl.UtpAuditorServicesImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BooleanIsRegiestAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private Integer iD;
	private String uName;
	public Integer getiD() {
		return iD;
	}
	public void setiD(Integer iD) {
		this.iD = iD;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	@Override
	public String execute() throws Exception {
		UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
		ActionContext context = ActionContext.getContext();
		if (uServices.isRegiest(iD, uName)) {
			context.put("sel", 1);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
