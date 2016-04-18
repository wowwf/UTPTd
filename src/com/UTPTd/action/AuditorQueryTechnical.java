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

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		UtpAuditor utpAuditor = (UtpAuditor) session.get("Auditor");
		if (1 == utpAuditor.getUtpAuditorRole()) {
			Page page = aContext.getBean(Page.class);
			UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
			page.setCurrentPage(currentPage);
			page.setEveryPage(20);
			PageResult result = uServices.QueryTechnical(page);
			List<UtpTechnical> utpTechnicals = result.getList();
			page = result.getPage();
			ActionContext context = ActionContext.getContext();
			context.put("page", page);
			context.put("TechnicalInfo", utpTechnicals);
			return SUCCESS;
		} else {
			addActionMessage("你没有人事部门人员的权限！");
			return ERROR;
		}
	}
}
