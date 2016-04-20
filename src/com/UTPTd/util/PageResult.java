package com.UTPTd.util;

import java.util.List;

import org.springframework.stereotype.Component;

public class PageResult {
	private Page page;		//分页信息
	private List list;		//记录信息
	public PageResult(Page page, List list) {
		this.page = page;
		this.list = list;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
