package com.UTPTd.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.UTPTd.services.UtpHighTeacherServices;
import com.UTPTd.services.UtpTechnicalServices;
import com.UTPTd.servicesImpl.UtpHighTeacherServicesImpl;
import com.UTPTd.servicesImpl.UtpTechnicalServicesImpl;
import com.opensymphony.xwork2.ActionSupport;

public class RegiestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private String userName;
	private String idCard;
	private Integer Post;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPost() {
		return Post;
	}


	public void setPost(Integer post) {
		Post = post;
	}


	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Override
	public String execute() throws Exception {
		String flag = "";
		
		switch (Post) {
		case 0:
			UtpHighTeacherServices UHTS = aContext.getBean(UtpHighTeacherServicesImpl.class);
			if (!UHTS.IsRegister(idCard)) {
				UtpHighTeacherDao UHTD = aContext.getBean(UtpHighTeacherDaoImpl.class);
				UHTD.InsertHighTeacher(idCard, userName);
				flag = "success";
			} else {
				addFieldError("PersonRegiest", "该用户已存在，请直接登录！");
				flag = "input";
			}
			break;
		case 1:
			UtpTechnicalServices UTS = aContext.getBean(UtpTechnicalServicesImpl.class);
			if (!UTS.IsRegister(idCard)) {
				UtpTechnicalDao UTD = aContext.getBean(UtpTechnicalDaoImpl.class);
				UTD.InsertTechnical(idCard, userName);
				flag = "success";
			} else {
				addFieldError("PersinRegiest", "该用户已存在，请直接登录！");
				flag = "input";
			}
			break;
		case 2:
			addFieldError("PersonRegiest", "请选择职务！");
			break;
		default:
			addFieldError("PersonRegiest", "注册出错了！");
			flag = "error";
			break;
		}
		return flag;
	}
	
}
