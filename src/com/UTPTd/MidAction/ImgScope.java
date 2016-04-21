package com.UTPTd.MidAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ImgScope extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer no;
	
	private Integer sel;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}
	
	public Integer getSel() {
		return sel;
	}

	public void setSel(Integer sel) {
		this.sel = sel;
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
			ActionContext context = ActionContext.getContext();
			if (sel == 1) {
				context.put("sel", 0);
			} else {
				context.put("sel", 1);
			}
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
