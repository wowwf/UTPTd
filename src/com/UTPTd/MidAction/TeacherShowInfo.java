package com.UTPTd.MidAction;

import java.util.Map;

import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherShowInfo extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
	
	private UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
	
	private Integer no;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}
	
	@Override
	public String execute() throws Exception {
		String flag = "";
		UtpHighTeacher uTeacher = new UtpHighTeacher();
		UtpTechnical utpTechnical = new UtpTechnical();
		Map<String, Object> session = ActionContext.getContext().getSession();
		ActionContext context = ActionContext.getContext();
		if (no == 1) {
			uTeacher = (UtpHighTeacher) session.get("HighTeacher");
			if (uTeacher != null) {
				uTeacher = UHTD.FindByHighTeacherIdCard(uTeacher.getUtpHighTeacherIdCard());
				if ("1".equals(uTeacher.getUtpHighTeacherGender())) {
					context.put("Gender", "男");
				} else {
					context.put("Gender", "nv");
				}
				context.put("highTeacher", uTeacher);
				//取出其他佐证的字符串，分解成佐证名称，并构造文件路径
				String[] nameList = UHTD.FindOtherFileName(uTeacher.getUtpHighTeacherIdCard()).split(",");
				
				flag = "success";
			} else {
				flag = "unLogin";
			}
		} else if (no == 2) {
			utpTechnical = (UtpTechnical) session.get("Technical");
			if (utpTechnical != null) {
				utpTechnical = UTD.FindByTechnicalIdCard(utpTechnical.getUtpTechnicalIdCard());
				context.put("TeachnicalInfo", utpTechnical);
				//查询出的年资情况的字符串，按逗号分别隔开
				
				
				flag = "success";
			} else {
				flag = "unLogin";
			}
		} else {
			addFieldError("showError", "信息展示出问题了！");
			flag = "error";
		}
		return flag;
	}

}
