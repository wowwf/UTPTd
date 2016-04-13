package com.UTPTd.action;

import com.UTPTd.servicesImpl.UtpAdminServicesImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UtpAdminLoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String utpNameString;
	private String utpPassword;
	//声明Utpadminservicesimpl对象
	private static UtpAdminServicesImpl UASI = new UtpAdminServicesImpl();
	
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
		if (UASI.FindByName(utpNameString) && UASI.Login(utpNameString, utpPassword)) {
			return SUCCESS;
		} else {
			addFieldError("AdminError", "不存在该管理员！");
			return INPUT;
		}
	}
}
