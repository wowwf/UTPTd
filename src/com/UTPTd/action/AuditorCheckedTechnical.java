package com.UTPTd.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.AuditorOpinion;
import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.dao.OpinionDao;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AuditorCheckedTechnical extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private List<String> technicalIdCard;
	
	private List<Integer> opinion;
	
	private List<String> auditorOpinion;

	public List<String> getTechnicalIdCard() {
		return technicalIdCard;
	}

	public List<Integer> getOpinion() {
		return opinion;
	}

	public List<String> getAuditorOpinion() {
		return auditorOpinion;
	}

	public void setTechnicalIdCard(List<String> technicalIdCard) {
		this.technicalIdCard = technicalIdCard;
	}

	public void setOpinion(List<Integer> opinion) {
		this.opinion = opinion;
	}

	public void setAuditorOpinion(List<String> auditorOpinion) {
		this.auditorOpinion = auditorOpinion;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		UtpAuditor uAuditor = (UtpAuditor) session.get("Auditor");
		if (uAuditor != null) {
			if (1 == uAuditor.getUtpAuditorRole()) {
				String auditorId = uAuditor.getUtpAuditorIdCard();
				AuditorOpinion aOpinion = aContext.getBean(AuditorOpinion.class);
				aOpinion.setAuditorId(auditorId);
				aOpinion.setOpinion(auditorOpinion.get(0));
				aOpinion.setTeacherId(technicalIdCard.get(0));
				aOpinion.setSumbitTime(new Date().toString());
				OpinionDao oDao = aContext.getBean(OpinionDao.class);
				oDao.insertMessage(aOpinion);
				if (0 == opinion.get(0)) {
					UtpTechnicalDao uDao = aContext.getBean(UtpTechnicalDaoImpl.class);
					uDao.UpdateTechnicalSubmitIsNotPass(technicalIdCard.get(0));
					session.put("every", 2);
					return SUCCESS;
				} else if(1 == opinion.get(0)) {
					ActionContext context = ActionContext.getContext();
					UtpTechnicalDao uDao = aContext.getBean(UtpTechnicalDaoImpl.class);
					uDao.UpdateTechnicalSubmitIsPass(technicalIdCard.get(0));
					context.put("currentPage", 1);
					context.put("everyPage", 2);
					return SUCCESS;
				} else {
					addActionMessage("没有审核意见");
					return ERROR;
				}
			} else {
				addActionMessage("你的权限不够");
				return ERROR;
			}
		} else {
			addActionMessage("未登录！");
			return "unLogin";
		}
	}
}
