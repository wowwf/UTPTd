package com.UTPTd.MidAction;

import com.opensymphony.xwork2.ActionSupport;

public class ChooseQuery extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer post;
	private String findIdCard;
	private String findName;
	private int everyPage;
	
	public String getFindIdCard() {
		return findIdCard;
	}
	
	public String getFindName() {
		return findName;
	}
	
	public void setFindIdCard(String findIdCard) {
		this.findIdCard = findIdCard;
	}
	
	public void setFindName(String findName) {
		this.findName = findName;
	}

	public Integer getPost() {
		return post;
	}
	
	public void setPost(Integer post) {
		this.post = post;
	}
	
	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	@Override
	public String execute() throws Exception {
		if (findIdCard != null) {
			if (post == 0) {
				return "queryT";
			} else {
				return "queryL";
			}
		} else if (findName != null) {
			if (post == 0) {
				return "queryT";
			} else {
				return "queryL";
			}
		} else {
			addActionMessage("请输入查询内容！");
			return ERROR;
		}
	}
}
