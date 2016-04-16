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
	
	private static UtpHighTeacherDao UHTD = aContext.getBean(UtpHighTeacherDaoImpl.class);
	
	private static UtpTechnicalDao UTD = aContext.getBean(UtpTechnicalDaoImpl.class);
	
	private Integer IdCard;
	
	private Integer Role;
	
	public Integer getIdCard() {
		return IdCard;
	}

	public Integer getRole() {
		return Role;
	}

	public void setIdCard(Integer idCard) {
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
			urlPath = UHTD.FindPersonImageUrl(IdCard);
			context.put("teacherUrl", urlPath);
			flag = "success";
		} else if (Role == 3) {
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
