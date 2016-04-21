package com.UTPTd.action;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.services.UTPAuditorServices;
import com.UTPTd.servicesImpl.UtpAuditorServicesImpl;
import com.UTPTd.util.Page;
import com.UTPTd.util.PageResult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AuditorQueryTeacher extends ActionSupport {

	/**
	 * 审核人员查询所有符合条件的审核表
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private int currentPage;
	
	private int everyPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	private static Integer getEvery(Integer everyPageInteger) {
		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		Integer every = (Integer) sessionMap.get("every");
		if (every != null) {
			everyPageInteger = every;
			sessionMap.remove("every");
		}
		return everyPageInteger;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		int everyPageNum = 20;
		everyPage = getEvery(everyPage);
		switch (everyPage) {
		case 0:
			everyPageNum = 1;
			break;
		case 1:
			everyPageNum = 10;
			break;
		case 2:
			everyPageNum = 20;
			break;
		case 3:
			everyPageNum = 50;
			break;
		case 4:
			everyPageNum = 100;
			break;
		default:
			everyPageNum = 20;
			break;
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		UtpAuditor utpAuditor = (UtpAuditor) session.get("Auditor");
		if (0 == utpAuditor.getUtpAuditorRole()) {
			Page page = aContext.getBean(Page.class);
			UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
			page.setEveryPage(everyPageNum);
			page.setCurrentPage(currentPage);
			PageResult result = uServices.QueryTeacher(page);
			List<UtpHighTeacher> utpHighTeachers = result.getList();
			page = result.getPage();
			ActionContext context = ActionContext.getContext();
			context.put("highTeacherInfo", utpHighTeachers);
			context.put("page", page);
	 		return SUCCESS;
		} else if (1 == utpAuditor.getUtpAuditorRole()) {
			Page page = aContext.getBean(Page.class);
			UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
			page.setEveryPage(everyPageNum);
			page.setCurrentPage(currentPage);
			PageResult result = uServices.QueryTeachers(page);
			List<UtpHighTeacher> utpHighTeachers = result.getList();
			page = result.getPage();
			ActionContext context = ActionContext.getContext();
			context.put("highTeacherInfo", utpHighTeachers);
			context.put("page", page);
	 		return SUCCESS;
		} else {
			addActionMessage("请先登录！");
			return ERROR;
		}
		
	}
}
