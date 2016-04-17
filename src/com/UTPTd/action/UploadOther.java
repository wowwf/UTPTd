package com.UTPTd.action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.UTPTd.util.UpLoadDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadOther extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static String UP = "/upload";
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private List<File> myFile;
	
	private List<String> myFileFileName;
	
	private List<String> myFileContentType;
	
	private String showmessage;

	public List<File> getMyFile() {
		return myFile;
	}

	public List<String> getMyFileFileName() {
		return myFileFileName;
	}

	public List<String> getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFile(List<File> myFile) {
		this.myFile = myFile;
	}

	public void setMyFileFileName(List<String> myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public void setMyFileContentType(List<String> myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getShowmessage() {
		return showmessage;
	}

	public void setShowmessage(String showmessage) {
		this.showmessage = showmessage;
	}
	
	private static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}
	
	@Override
	public String execute() throws Exception {
		String flag = "";
		if (myFile == null) {
			addActionMessage("文件不能为空！");
			flag = "fileIsnull";
		} else {
			String[] nameList = showmessage.split(",");
			StringBuffer fileNameBuffer = new StringBuffer();
			String pathString = ServletActionContext.getServletContext().getRealPath(UP);
			Map<String, Object> session = ActionContext.getContext().getSession();
			UpLoadDao ULD = aContext.getBean(UpLoadDao.class);
			UtpHighTeacher teacher = (UtpHighTeacher) session.get("HighTeacher");
			UtpTechnical technical = (UtpTechnical) session.get("Technical");
			if (teacher != null) {
				UtpHighTeacherDao UHTD = aContext.getBean(UtpHighTeacherDaoImpl.class);
				if (UHTD.FindOtherFileName(teacher.getUtpHighTeacherIdCard()) != null) {
					String localPath = UHTD.FindOtherFileName(teacher.getUtpHighTeacherIdCard());
					ULD.deleteFileByName(0, localPath, pathString);
				}
				for (int i = 0; i < myFile.size(); i++) {
					String path = nameList[i] + "@" + new Date().getTime() + getExtention(this.myFileFileName.get(i));
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append(pathString);
					stringBuilder.append("/teacher/");
					stringBuilder.append(path);
					File newFile = new File(stringBuilder.toString());
					StringBuilder stringBuilder2 = new StringBuilder();
					//公司
					//stringBuilder2.append(ULD.getProp("teacherPath"));
					//个人
					stringBuilder2.append(ULD.getProp("teaPath"));
					stringBuilder2.append(path);
					String againPath = stringBuilder2.toString();
					ULD.upLoadFile(newFile, myFile.get(i), againPath);
					fileNameBuffer.append(path + ",");
				}
				UHTD.OthersUpload(teacher.getUtpHighTeacherIdCard(), fileNameBuffer);
				flag = "success";
			} else if (technical != null) {
				UtpTechnicalDao UTD = aContext.getBean(UtpTechnicalDaoImpl.class);
				if (UTD.FindOtherFile(technical.getUtpTechnicalIdCard()) != null) {
					String localPath = UTD.FindOtherFile(technical.getUtpTechnicalIdCard());
					ULD.deleteFileByName(1, localPath, pathString);
				};
				for (int i = 0; i < myFile.size(); i++) {
					String path = nameList[i] + "@" + new Date().getTime() + getExtention(this.myFileFileName.get(i));
					StringBuilder builder = new StringBuilder();
					builder.append(pathString);
					builder.append("/technical/");
					builder.append(path);
					File newFile = new File(builder.toString());
					StringBuilder builder2 = new StringBuilder();
					//公司
					//builder2.append(ULD.getProp("technicalPath"));
					//个人
					builder2.append(ULD.getProp("teacalPath"));
					builder2.append(path);
					String againPath = builder2.toString();
					ULD.upLoadFile(newFile, myFile.get(i), againPath);
					fileNameBuffer.append(path + ",");
				}
				UTD.OtherUpload(technical.getUtpTechnicalIdCard(), fileNameBuffer);
				flag = "success";
			} else {
				addActionError("没有登录！");
				flag = "error";
			}
		}
		return flag;
	}

}
