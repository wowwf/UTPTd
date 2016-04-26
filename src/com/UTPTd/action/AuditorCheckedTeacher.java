package com.UTPTd.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.AuditorOpinion;
import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.dao.OpinionDao;
import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.daoImpl.OpinionDaoImpl;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AuditorCheckedTeacher extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private List<String> teacherIdCard;
	
	private List<Integer> opinion;
	
	private List<String> auditorOpinion;

	public List<String> getTeacherIdCard() {
		return teacherIdCard;
	}

	public List<Integer> getOpinion() {
		return opinion;
	}

	public List<String> getAuditorOpinion() {
		return auditorOpinion;
	}

	public void setTeacherIdCard(List<String> teacherIdCard) {
		this.teacherIdCard = teacherIdCard;
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
		ActionContext context = ActionContext.getContext();
		UtpAuditor uAuditor = (UtpAuditor) session.get("Auditor");
		if (0 == uAuditor.getUtpAuditorRole()) {
			String auditorId = uAuditor.getUtpAuditorIdCard();
			AuditorOpinion aOpinion = aContext.getBean(AuditorOpinion.class);
			aOpinion.setAuditorId(auditorId);
			aOpinion.setTeacherId(teacherIdCard.get(0));
			aOpinion.setOpinion(auditorOpinion.get(0));
			aOpinion.setSumbitTime(new Date().toString());
			OpinionDao oDao = aContext.getBean(OpinionDaoImpl.class);
			oDao.insertMessage(aOpinion);
			if (opinion.get(0) == 0) {												//不同意
				UtpHighTeacherDao uDao = aContext.getBean(UtpHighTeacherDaoImpl.class);
				uDao.UpdateWhichSubmit(teacherIdCard.get(0), 1);
				uDao.UpdateSubmitIsNotPass(teacherIdCard.get(0));
				session.put("every", 2);
				return SUCCESS;
			} else if(opinion.get(0) == 1) {										//同意
				UtpHighTeacherDao uDao = aContext.getBean(UtpHighTeacherDaoImpl.class);
				uDao.UpdateWhichSubmit(teacherIdCard.get(0), 1);
				context.put("currentPage", 1);
				context.put("everyPage", 2);
				return SUCCESS;
			} else {
				addActionError("没有审核意见");
				return ERROR;
			}
		} else if (1 == uAuditor.getUtpAuditorRole()) {
			String auditorId = uAuditor.getUtpAuditorIdCard();
			AuditorOpinion aOpinion = aContext.getBean(AuditorOpinion.class);
			aOpinion.setAuditorId(auditorId);
			aOpinion.setTeacherId(teacherIdCard.get(0));
			aOpinion.setOpinion(auditorOpinion.get(0));
			aOpinion.setSumbitTime(new Date().toString());
			OpinionDao oDao = aContext.getBean(OpinionDaoImpl.class);
			oDao.insertMessage(aOpinion);
			if (opinion.get(0) == 0) {												//不同意
				UtpHighTeacherDao uDao = aContext.getBean(UtpHighTeacherDaoImpl.class);
				uDao.UpdateWhichSubmit(teacherIdCard.get(0), 2);
				uDao.UpdateSubmitIsNotPass(teacherIdCard.get(0));
				session.put("every", 2);
				return SUCCESS;
			} else if(opinion.get(0) == 1) {										//同意
				UtpHighTeacherDao uDao = aContext.getBean(UtpHighTeacherDaoImpl.class);
				uDao.UpdateWhichSubmit(teacherIdCard.get(0), 2);
				uDao.UpdateSubmitIsPass(teacherIdCard.get(0));
				context.put("currentPage", 1);
				context.put("everyPage", 2);
				return SUCCESS;
			} else {
				addActionError("没有审核意见");
				return ERROR;
			}
		} else {
			addActionMessage("没有登录！");
			return "unLogin";
		}
		
	}
}
