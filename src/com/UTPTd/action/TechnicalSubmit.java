package com.UTPTd.action;

import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class TechnicalSubmit extends ActionSupport {

	/**
	 * 技术人员申报职称个人信息填写及提交
	 */
	private static final long serialVersionUID = 1L;

	private static UtpTechnicalDao utpTechnicalDao = new UtpTechnicalDaoImpl();
	
	private static UtpTechnical utpTechnical = new UtpTechnical();

	public static UtpTechnical getUtpTechnical() {
		return utpTechnical;
	}

	public static void setUtpTechnical(UtpTechnical utpTechnical) {
		TechnicalSubmit.utpTechnical = utpTechnical;
	}
	
	@Override
	public String execute() throws Exception {
		utpTechnicalDao.UpdateTechnical(utpTechnical);
		return SUCCESS;
	}
}
