package com.UTPTd.action;

import java.util.List;
import java.util.Map;

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
	
	private int everyPage;
	
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
		if (findIdCard != null) {
			Page page = aContext.getBean(Page.class);
			UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
			page.setEveryPage(everyPageNum);
			page.setCurrentPage(currentPage);
			PageResult result = uServices.LikeQueryTechnicalById(findIdCard, page);
			page = result.getPage();
			List<UtpTechnical> utpTechnicals = result.getList();
			ActionContext context = ActionContext.getContext();
			context.put("sel", 1);
			context.put("TechnicalInfo", utpTechnicals);
			context.put("page", page);
			return SUCCESS;
		} else if (findName != null) {
			Page page = aContext.getBean(Page.class);
			UTPAuditorServices uServices = aContext.getBean(UtpAuditorServicesImpl.class);
			page.setCurrentPage(currentPage);
			page.setEveryPage(everyPageNum);
			PageResult result = uServices.LikeQueryTechnical(findName, page);
			List<UtpTechnical> utpTechnicals = result.getList();
			page = result.getPage();
			ActionContext context = ActionContext.getContext();
			context.put("page", page);
			context.put("TechnicalInfo", utpTechnicals);
			context.put("sel", 1);
			return SUCCESS;
		} else {
			addActionMessage("请输入查询条件！");
			return ERROR;
		}
	}
}
