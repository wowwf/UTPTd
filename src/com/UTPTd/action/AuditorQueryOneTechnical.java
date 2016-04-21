package com.UTPTd.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.action.AuditorQueryOneTeacher.myList;
import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AuditorQueryOneTechnical extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private List<Integer> idCard;

	public List<Integer> getIdCard() {
		return idCard;
	}

	public void setIdCard(List<Integer> idCard) {
		this.idCard = idCard;
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
		UtpTechnicalDao tDao = aContext.getBean(UtpTechnicalDaoImpl.class);
		UtpTechnical uTechnical = aContext.getBean(UtpTechnical.class);
		ActionContext context = ActionContext.getContext();
		uTechnical = tDao.FindByTechnicalIdCard(idCard.get(0));
		String url = uTechnical.getUtpTechnicalPublication();
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
		context.put("SelectTechnical", uTechnical);
		return super.execute();
	}
}
