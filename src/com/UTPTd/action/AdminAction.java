package com.UTPTd.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.services.UtpAdminServices;
import com.UTPTd.servicesImpl.UtpAdminServicesImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private int sel;
	private String card;
	private String name;
	private String password;
	private Integer role;
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Integer getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public int getSel() {
		return sel;
	}

	public void setSel(int sel) {
		this.sel = sel;
	}
	
	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	@Override
	public String execute() throws Exception {
		String flag = "";
		UtpAdminServices uServices = aContext.getBean(UtpAdminServicesImpl.class);
		ActionContext context = ActionContext.getContext();
		switch (sel) {
		case 1:
			UtpAuditor utpAuditor = aContext.getBean(UtpAuditor.class);
			utpAuditor.setUtpAuditorIdCard(card);
			utpAuditor.setUtpAuditorName(name);
			utpAuditor.setUtpAuditorPassword(password);
			utpAuditor.setUtpAuditorRole(role);
			uServices.insertAuditor(utpAuditor);
			addActionMessage("审核人员添加成功!");
			flag = "addsuccess";
			break;
		case 2:
			List<UtpAuditor> list = uServices.findAllAuditors();
			context.put("auditorList", list);
			flag = "findsuccess";
			break;
		case 3:
			UtpAuditor uAuditor = aContext.getBean(UtpAuditor.class);
			uAuditor = uServices.findAuditor(card);
			context.put("oneauditor", uAuditor);
			flag = "findonesuccess";
			break;
		case 4:
			if (uServices.findAuditor(card) != null) {
				uServices.deleteAuditor(card);
				uServices.deleteAuditorOpinion(card);
				addActionMessage("删除成功！");
				flag = "deletesuccess";
			} else {
				addActionMessage("用户不存在！");
				flag = "deleteerror";
			}
			break;
		default:
			flag = "error";
			break;
		}
		return flag;
	}

}
