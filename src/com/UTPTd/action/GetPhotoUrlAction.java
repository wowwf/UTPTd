package com.UTPTd.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetPhotoUrlAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private String IdCard;
	
	private Integer Role;
	
	public String getIdCard() {
		return IdCard;
	}

	public Integer getRole() {
		return Role;
	}

	public void setIdCard(String idCard) {
		IdCard = idCard;
	}

	public void setRole(Integer role) {
		Role = role;
	}

	@Override
	public String execute() throws Exception {
		String urlPath = "";
		String flag = "";
		ActionContext context = ActionContext.getContext();
		if (Role == 2) {
			UtpHighTeacherDao UHTD = aContext.getBean(UtpHighTeacherDaoImpl.class);
			urlPath = UHTD.FindPersonImageUrl(IdCard);
			context.put("teacherUrl", urlPath);
			flag = "success";
		} else if (Role == 3) {
			UtpTechnicalDao UTD = aContext.getBean(UtpTechnicalDaoImpl.class);
			urlPath = UTD.FindPersonImgUrl(IdCard);
			context.put("technicalUrl", urlPath);
			flag = "success";
		} else {
			addFieldError("getUrlError", "职务获取错误！");
			flag = "error";
		}
		return flag;
	}

}
