package com.UTPTd.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.AuditorOpinion;
import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.dao.UtpAuditorDao;
import com.UTPTd.daoImpl.UtpAuditorDaoImpl;
import com.UTPTd.services.UtpOpinionServices;
import com.UTPTd.servicesImpl.UtpOpinionServicesImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAuditorOpinion extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private Integer tid;
	private String tname;
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}
	
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public class MyLists {
		private String aName;
		private String tName;
		private String aOpinion;
		private String aTime;
		
		public String getaName() {
			return aName;
		}
		public String gettName() {
			return tName;
		}
		public String getaOpinion() {
			return aOpinion;
		}
		public String getaTime() {
			return aTime;
		}
		public void setaName(String aName) {
			this.aName = aName;
		}
		public void settName(String tName) {
			this.tName = tName;
		}
		public void setaOpinion(String aOpinion) {
			this.aOpinion = aOpinion;
		}
		public void setaTime(String aTime) {
			this.aTime = aTime;
		}
	}
	
	@Override
	public String execute() throws Exception {
		UtpOpinionServices uServices = aContext.getBean(UtpOpinionServicesImpl.class);
		ActionContext context = ActionContext.getContext();
		List<AuditorOpinion> aList = uServices.findByTidAndAid(tid);
		if (aList != null) {
			UtpAuditorDao uDao = aContext.getBean(UtpAuditorDaoImpl.class);
			List<MyLists> lists = new ArrayList<ShowAuditorOpinion.MyLists>();
			for (int i = 0; i < aList.size(); i++) {
				UtpAuditor uAuditor = uDao.FindById(aList.get(i).getAuditorId());
				MyLists myLists = new MyLists();
				myLists.setaName(uAuditor.getUtpAuditorName());
				myLists.settName(tname);
				myLists.setaTime(aList.get(i).getSumbitTime());
				myLists.setaOpinion(aList.get(i).getOpinion());
				lists.add(myLists);
			}
			context.put("OpinionInfo", lists);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
}
