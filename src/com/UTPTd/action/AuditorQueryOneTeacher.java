package com.UTPTd.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AuditorQueryOneTeacher extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private List<Integer> IdCard;
	
	public List<Integer> getIdCard() {
		return IdCard;
	}

	public void setIdCard(List<Integer> idCard) {
		IdCard = idCard;
	}

	public class myList{
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
		UtpHighTeacherDao uDao = aContext.getBean(UtpHighTeacherDaoImpl.class);
		UtpHighTeacher uTeacher = aContext.getBean(UtpHighTeacher.class);
		ActionContext context = ActionContext.getContext();
		uTeacher = uDao.FindByHighTeacherIdCard(IdCard.get(0));
		String url = uTeacher.getUtpHighTeacherOther();
		if (url != null) {
			String[] urlList = url.split(",");
			List<myList> nameList = new ArrayList<myList>();
			for (int i = 0; i < urlList.length; i++) {
				String[] name = urlList[i].split("@");
				myList mList = new myList();
				mList.setName(name[0]);
				mList.setPath(urlList[i]);
				nameList.add(mList);
			}
			context.put("otherUrlList", nameList);
		}
		context.put("SelectTeacher", uTeacher);
		return SUCCESS;
	}

}
