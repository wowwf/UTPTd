package com.UTPTd.action;

import java.util.Date;
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
	
	private Integer teacherIdCard;
	
	private Integer opinion;
	
	private String auditorOpinion;

	public Integer getTeacherIdCard() {
		return teacherIdCard;
	}

	public Integer getOpinion() {
		return opinion;
	}

	public String getAuditorOpinion() {
		return auditorOpinion;
	}

	public void setTeacherIdCard(Integer teacherIdCard) {
		this.teacherIdCard = teacherIdCard;
	}

	public void setOpinion(Integer opinion) {
		this.opinion = opinion;
	}

	public void setAuditorOpinion(String auditorOpinion) {
		this.auditorOpinion = auditorOpinion;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		UtpAuditor uAuditor = (UtpAuditor) session.get("Auditor");
		Integer auditorId = uAuditor.getUtpAuditorIdCard();
		AuditorOpinion aOpinion = aContext.getBean(AuditorOpinion.class);
		aOpinion.setAuditorId(auditorId);
		aOpinion.setTeacherId(teacherIdCard);
		aOpinion.setOpinion(auditorOpinion);
		aOpinion.setSumbitTime(new Date().toString());
		OpinionDao oDao = aContext.getBean(OpinionDaoImpl.class);
		oDao.insertMessage(aOpinion);
		if (opinion == 0) {
			UtpHighTeacherDao uDao = aContext.getBean(UtpHighTeacherDaoImpl.class);
			uDao.UpdateWhichSubmit(teacherIdCard, 1);
		} else if(opinion == 1) {
			
		} else {
			
		}
		return SUCCESS;
	}
}
