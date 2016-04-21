package com.UTPTd.action;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.services.UTPAuditorServices;
import com.UTPTd.servicesImpl.UtpAuditorServicesImpl;
import com.UTPTd.util.Page;
import com.UTPTd.util.PageResult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AuditorQueryTechnical extends ActionSupport {

	/**
	 * 查询所有符合条件的技术人员信息
	 */
	private static final long serialVersionUID = 1L;

	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
		
	private int currentPage;
	private List<Integer> everyPage;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Integer> getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(List<Integer> everyPage) {
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
		everyPage.set(0, getEvery(everyPage.get(0)));
		switch (everyPage.get(0)) {
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
		if (1 == utpAuditor.getUtpAuditorRole()) {
			Page page = aContext.getBean(Page.class);
			UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
			page.setCurrentPage(currentPage);
			page.setEveryPage(everyPageNum);
			PageResult result = uServices.QueryTechnical(page);
			List<UtpTechnical> utpTechnicals = result.getList();
			page = result.getPage();
			ActionContext context = ActionContext.getContext();
			context.put("page", page);
			context.put("TechnicalInfo", utpTechnicals);
			context.put("sel", 1);
			return SUCCESS;
		} else {
			ActionContext context = ActionContext.getContext();
			context.put("sel", 1);
			addActionMessage("你没有人事部门人员的权限！");
			return ERROR;
		}
	}
}
