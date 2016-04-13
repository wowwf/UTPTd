package com.UTPTd.action;

import java.util.Map;

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
import com.UTPTd.services.UtpHighTeacherServices;
import com.UTPTd.services.UtpTechnicalServices;
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
	
	private static UTPAuditorServices UAS = new UtpAuditorServicesImpl();
	
	private static UtpAuditorDao UAD = new UtpAuditorDaoImpl();
	
	private static UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
	
	private static UtpHighTeacherServices UHTS = new UtpHighTeacherServicesImpl();
	
	private static UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
	
	private static UtpTechnicalServices UTS = new UtpTechnicalServicesImpl();
	
	private Integer IdCard;
	private String password;
	private Integer Role;
	public Integer getIdCard() {
		return IdCard;
	}
	public String getPassword() {
		return password;
	}
	public void setIdCard(Integer idCard) {
		IdCard = idCard;
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
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("Auditor");
		session.remove("HighTeacher");
		session.remove("Technical");
		if (Role == 0 || Role == 1) {
			UtpAuditor utpAuditor = new UtpAuditor();
			utpAuditor = UAD.FindById(IdCard);
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
			UtpHighTeacher utpHighTeacher = new UtpHighTeacher();
			utpHighTeacher = UHTD.FindByHighTeacherIdCard(IdCard);
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
			UtpTechnical utpTechnical = new UtpTechnical();
			utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
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
		} else {
			addFieldError("LoginError", "你没有选择登陆角色！");
			flag = "error";
		}
		
		return flag;
	}
}
