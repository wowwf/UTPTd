package com.UTPTd.action;

import org.apache.struts2.ServletActionContext;

import com.UTPTd.services.UtpAdminServices;
import com.UTPTd.servicesImpl.UtpAdminServicesImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Admincontroller extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static UtpAdminServices UAS = new UtpAdminServicesImpl();
	
	private final static String path = "/upload";
	
	private String who;
	
	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}
	

	@Override
	public String execute() throws Exception {
		String serverPath = ServletActionContext.getServletContext().getRealPath(path);
		ActionContext context = ActionContext.getContext();
		if (UAS.DeleteOtherFile(who, serverPath)) {
			context.put("technicalDelete", "相关冗余文件已删除！");
			return SUCCESS;
		} else {
			context.put("deleteError", "没有文件多余！");
			return ERROR;
		}
	}

}