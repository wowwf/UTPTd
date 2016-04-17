package com.UTPTd.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherSubmit extends ActionSupport {

	/**
	 *高校教师个人信息提交 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private UtpHighTeacher utpHighTeacher = aContext.getBean(UtpHighTeacher.class);

	public UtpHighTeacher getUtpHighTeacher() {
		return utpHighTeacher;
	}

	public void setUtpHighTeacher(UtpHighTeacher utpHighTeacher) {
		this.utpHighTeacher = utpHighTeacher;
	}
	
	@Override
	public String execute() throws Exception {
		UtpHighTeacherDao UHTD = aContext.getBean(UtpHighTeacherDaoImpl.class);
		UHTD.UpdateHighTeacher(utpHighTeacher);
		return SUCCESS;
	}
	

}
