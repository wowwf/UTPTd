package com.UTPTd.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.services.UTPAuditorServices;
import com.UTPTd.servicesImpl.UtpAuditorServicesImpl;
import com.UTPTd.util.Page;
import com.UTPTd.util.PageResult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AuditorLikeQueryTechnical extends ActionSupport {

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

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public Integer getFindIdCard() {
		return findIdCard;
	}

	public void setFindIdCard(Integer findIdCard) {
		this.findIdCard = findIdCard;
	}

	public String getFindName() {
		return findName;
	}

	public void setFindName(String findName) {
		this.findName = findName;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		if (findIdCard != null) {
			Page page = aContext.getBean(Page.class);
			UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
			page.setEveryPage(20);
			page.setCurrentPage(currentPage);
			PageResult result = uServices.LikeQueryTechnicalById(findIdCard, page);
			page = result.getPage();
			List<UtpTechnical> utpTechnicals = result.getList();
			ActionContext context = ActionContext.getContext();
			context.put("TechnicalInfo", utpTechnicals);
			context.put("page", page);
			return SUCCESS;
		} else if (findName != null) {
			Page page = aContext.getBean(Page.class);
			UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
			page.setCurrentPage(currentPage);
			page.setEveryPage(20);
			PageResult result = uServices.LikeQueryTechnical(findName, page);
			List<UtpTechnical> utpTechnicals = result.getList();
			page = result.getPage();
			ActionContext context = ActionContext.getContext();
			context.put("page", page);
			context.put("TechnicalInfo", utpTechnicals);
			return SUCCESS;
		} else {
			addActionMessage("请输入查询条件！");
			return ERROR;
		}
	}
}
