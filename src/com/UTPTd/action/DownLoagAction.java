package com.UTPTd.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class DownLoagAction extends ActionSupport implements ServletContextAware {

	/**
	 * 文件下载
	 */
	private static final long serialVersionUID = 5887129269836998280L;

	private String fileName;
	private ServletContext context;
	private String mimeType;
	private InputStream inStream;
	
	@Override
	public String execute() throws Exception {
		mimeType = context.getMimeType(fileName);
		return SUCCESS;
	}
	
	public InputStream getInStream() {
		inStream = context.getResourceAsStream(fileName);
		if (inStream == null) {
			inStream = new ByteArrayInputStream("抱歉没有这个文件！".getBytes());
		}
		return inStream;
	}
	
	public String getMimeType() {
		return mimeType;
	}
	
	public void setFileName(String fileName) {
		this.fileName = new String(fileName.getBytes());
	}
	public String getFileName() {
		return fileName;
	}
	
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	
}
