package com.UTPTd.MidAction;

import java.util.ArrayList;
import java.util.Map;

import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowInfoAction extends ActionSupport {

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
	
	public class NamePath{
		private String name;
		private String path;
		public String getName() {
			return name;
		}
		public String getPath() {
			return path;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setPath(String path) {
			this.path = path;
		}
		
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
					context.put("Gender", "女");
				}
				context.put("highTeacher", uTeacher);
				//取出其他佐证的字符串，分解成佐证名称，并构造文件路径
				String[] nameList = UHTD.FindOtherFileName(uTeacher.getUtpHighTeacherIdCard()).split(",");
				ArrayList<NamePath> urlList = new ArrayList<NamePath>();
				//NamePath namePath = new NamePath();
				for (int i = 0; i < nameList.length; i++) {
					System.out.println(nameList[i]);
					NamePath namePath = new NamePath();
					String[] stringList = nameList[i].split("@");
					namePath.setName(stringList[0]);
					namePath.setPath(nameList[i]);
					urlList.add(namePath);
				}
				context.put("otherUrlList", urlList);
				flag = "teachersuccess";
			} else {
				flag = "unLogin";
			}
		} else if (no == 2) {
			utpTechnical = (UtpTechnical) session.get("Technical");
			if (utpTechnical != null) {
				utpTechnical = UTD.FindByTechnicalIdCard(utpTechnical.getUtpTechnicalIdCard());
				if ("1".equals(utpTechnical.getUtpTechnicalGender())) {
					context.put("Gender", "男");
				} else {
					context.put("Gender", "女");
				}
				context.put("TechnicalInfo", utpTechnical);
				//查询出的论文情况的字符串，按逗号分别隔开
				String[] nameList = UTD.FindOtherFile(utpTechnical.getUtpTechnicalIdCard()).split(",");
				ArrayList<NamePath> urlList = new ArrayList<NamePath>();
				for (int i = 0; i < nameList.length; i++) {
					NamePath namePath = new NamePath();
					String[] stringList = nameList[i].split("@");
					namePath.setName(stringList[0]);
					namePath.setPath(nameList[i]);
					urlList.add(namePath);
				}
				context.put("otherUrlList", urlList);
				flag = "technicalsuccess";
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
