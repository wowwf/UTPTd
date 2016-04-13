package com.UTPTd.MidAction;

import java.util.Map;

import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SessionScope extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
	
	private static UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
	
	private Integer no;
	
	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}
	@Override
	public String execute() throws Exception {
		String flagString = "";
		Map<String, Object> session = ActionContext.getContext().getSession();
		ActionContext context = ActionContext.getContext();
		switch (no) {
		case 1:
			UtpHighTeacher utpHighTeacher = (UtpHighTeacher) session.get("HighTeacher");
			if (utpHighTeacher.getUtpHighTeacherIdCard() != 0) {
				UtpHighTeacher uTeacher = UHTD.FindByHighTeacherIdCard(utpHighTeacher.getUtpHighTeacherIdCard());
				context.put("readTeacher", uTeacher);
				flagString = "success";
			} else {
				flagString = "unlogin";
			}
			break;
		case 2:
			UtpTechnical utpTechnical = (UtpTechnical) session.get("Technical");
			if (utpTechnical.getUtpTechnicalIdCard() != 0) {
				UtpTechnical uTechnical = UTD.FindByTechnicalIdCard(utpTechnical.getUtpTechnicalIdCard());
				context.put("readTechnical", uTechnical);
				flagString = "technicalsuccess";
			} else {
				flagString = "unlogin";
			}
			break;
		case 3:
			flagString = "auditorsuccess";
			break;
		default:
			addFieldError("scope", "摆渡人喝多了！");
			flagString = "error";
			break;
		}
		
		return flagString;
	}

}
