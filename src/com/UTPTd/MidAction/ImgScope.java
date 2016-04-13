package com.UTPTd.MidAction;

import com.opensymphony.xwork2.ActionSupport;

public class ImgScope extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		switch (no) {
		case 1:
			flag = "teachersuccess";
			break;
		case 2:
			flag = "technicalsuccess";
			break;
		case 3:
			flag = "auditorsuccess";
			break;
		default:
			addFieldError("imgUrlError", "2号摆渡人也醉了！");
			flag = "error";
			break;
		}
		return flag;
	}
}
