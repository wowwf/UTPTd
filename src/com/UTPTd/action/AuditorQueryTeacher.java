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

public class AuditorQueryTeacher extends ActionSupport {

	/**
	 * 审核人员查询所有符合条件的审核表
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Page page = aContext.getBean(Page.class);
		UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
		page.setEveryPage(20);
		page.setCurrentPage(currentPage);
		PageResult result = uServices.QueryTeacher(page);
		List<UtpHighTeacher> utpHighTeachers = result.getList();
		page = result.getPage();
		ActionContext context = ActionContext.getContext();
		context.put("highTeacherInfo", utpHighTeachers);
		context.put("page", page);
 		return SUCCESS;
	}
}
