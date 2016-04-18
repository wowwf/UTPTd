package com.UTPTd.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.services.UTPAuditorServices;
import com.UTPTd.servicesImpl.UtpAuditorServicesImpl;
import com.UTPTd.util.Page;
import com.UTPTd.util.PageResult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AuditorLikeQueryTeacher extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private int currentPage;
	
	private Integer findIdCard;
	
	private String findName;

	public int getCurrentPage() {
		return currentPage;
	}

	public Integer getFindIdCard() {
		return findIdCard;
	}

	public String getFindName() {
		return findName;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setFindIdCard(Integer findIdCard) {
		this.findIdCard = findIdCard;
	}

	public void setFindName(String findName) {
		this.findName = findName;
	}
	
	@Override
	public String execute() throws Exception {
		if (findIdCard != null) {
			Page page = aContext.getBean(Page.class);
			UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
			page.setEveryPage(20);
			page.setCurrentPage(currentPage);
			PageResult result = uServices.LikeQueryTeacherById(findIdCard, page);
			List<UtpHighTeacher> utpHighTeachers = result.getList();
			page = result.getPage();
			ActionContext context = ActionContext.getContext();
			context.put("page", page);
			context.put("highTeacherInfo", utpHighTeachers);
			return SUCCESS;
		} else if (findName != null) {
			Page page = aContext.getBean(Page.class);
			UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
			page.setEveryPage(20);
			page.setCurrentPage(currentPage);
			PageResult result = uServices.LikeQueryTeacher(findName, page);
			List<UtpHighTeacher> utpHighTeachers = result.getList();
			page = result.getPage();
			ActionContext context = ActionContext.getContext();
			context.put("page", page);
			context.put("highTeacherInfo", utpHighTeachers);
			return SUCCESS;
		} else {
			addActionMessage("请输入查询条件！");
			return ERROR;
		}
	}
	
}
