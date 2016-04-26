package com.UTPTd.action;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpAuditorDao;
import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpAuditorDaoImpl;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.UTPTd.services.UTPAuditorServices;
import com.UTPTd.services.UtpAdminServices;
import com.UTPTd.services.UtpHighTeacherServices;
import com.UTPTd.services.UtpTechnicalServices;
import com.UTPTd.servicesImpl.UtpAdminServicesImpl;
import com.UTPTd.servicesImpl.UtpAuditorServicesImpl;
import com.UTPTd.servicesImpl.UtpHighTeacherServicesImpl;
import com.UTPTd.servicesImpl.UtpTechnicalServicesImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AALoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private String UserName;
	private String password;
	private Integer Role;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getRole() {
		return Role;
	}
	
	public void setRole(Integer role) {
		Role = role;
	}
	
	@Override
	public String execute() throws Exception {
		String flag = " ";
		UtpAdminServices UA = aContext.getBean(UtpAdminServicesImpl.class);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("Auditor");
		session.remove("HighTeacher");
		session.remove("Technical");
		if (Role == 0 || Role == 1) {
			String IdCard = UserName;
			UtpAuditorDao UAD = aContext.getBean(UtpAuditorDaoImpl.class);
			UtpAuditor utpAuditor = aContext.getBean(UtpAuditor.class);
			utpAuditor = UAD.FindById(IdCard);
			UTPAuditorServices UAS = aContext.getBean(UtpAuditorServicesImpl.class);
			if (UAS.FindByIdAndRole(IdCard)) {
				if (UAS.FindPassword(IdCard, Role, password)) {
					session.put("Auditor", utpAuditor);
					flag = "success";
				} else {
					addFieldError("LoginError", "登录信息错误！");
					flag = "error";
				}
			} else {
				addFieldError("LoginError", "用户不存在！");
				flag = "error";
			}
		} else if (Role == 2) {
			String IdCard = UserName;
			UtpHighTeacherDao UHTD = aContext.getBean(UtpHighTeacherDaoImpl.class);
			UtpHighTeacher utpHighTeacher = aContext.getBean(UtpHighTeacher.class);
			utpHighTeacher = UHTD.FindByHighTeacherIdCard(IdCard);
			UtpHighTeacherServices UHTS = aContext.getBean(UtpHighTeacherServicesImpl.class);
			if (UHTS.IsRegister(IdCard)) {
				if (UHTS.IsNameCorrect(IdCard, password)) {
					session.put("HighTeacher", utpHighTeacher);
					flag = "teacherlog";
				} else {
					addFieldError("LoginError", "登陆信息输入错误！");
					flag = "error";
				}
			} else {
				addFieldError("LoginError", "用户不存在！");
				flag = "error";
			}
		} else if (Role == 3) {
			String IdCard = UserName;
			UtpTechnicalDao UTD = aContext.getBean(UtpTechnicalDaoImpl.class);
			UtpTechnical utpTechnical = aContext.getBean(UtpTechnical.class);
			utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
			UtpTechnicalServices UTS = aContext.getBean(UtpTechnicalServicesImpl.class);
			if (UTS.IsRegister(IdCard)) {
				if (UTS.IsNameCorrect(IdCard, password)) {
					session.put("Technical", utpTechnical);
					flag = "technicallog";
				} else {
					addFieldError("LoginError", "登陆信息输入错误！");
					flag = "error";
				}
			} else {
				addFieldError("LoginError", "用户不存在！");
				flag = "error";
			}
		} else if (UA.Login(UserName, password)) {
			session.put("Admin", UserName);
			flag = "adminLog";
		} else {
			addFieldError("LoginError", "你没有选择登陆角色！");
			flag = "error";
		}
		
		return flag;
	}
}
