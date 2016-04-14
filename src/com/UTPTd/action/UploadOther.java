package com.UTPTd.action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

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
	
	private static UpLoadDao ULD = new UpLoadDao();
	
	private static UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
	
	private static UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
	
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
			UtpHighTeacher teacher = (UtpHighTeacher) session.get("HighTeacher");
			UtpTechnical technical = (UtpTechnical) session.get("Technical");
			if (teacher != null) {
				String localPath = UHTD.FindOtherFileName(teacher.getUtpHighTeacherIdCard());
				ULD.deleteFileByName(0, localPath, pathString);
				for (int i = 0; i < myFile.size(); i++) {
					String path = nameList[i] + "@" + new Date().getTime() + getExtention(this.myFileFileName.get(i));
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append(pathString);
					stringBuilder.append("/teacher/");
					stringBuilder.append(path);
					File newFile = new File(stringBuilder.toString());
					StringBuilder stringBuilder2 = new StringBuilder();
					stringBuilder2.append("D:/java/workspace/UTPTd/WebContent/upload/teacher/");
					//stringBuilder2.append("D:/dx/workspeace/UTPTd/WebContent/upload/teacher/");
					stringBuilder2.append(path);
					String againPath = stringBuilder2.toString();
					ULD.upLoadFile(newFile, myFile.get(i), againPath);
					fileNameBuffer.append(path + ",");
				}
				UHTD.OthersUpload(teacher.getUtpHighTeacherIdCard(), fileNameBuffer);
				flag = "success";
			} else if (technical != null) {
				String localPath = UTD.FindOtherFile(technical.getUtpTechnicalIdCard());
				ULD.deleteFileByName(1, localPath, pathString);
				for (int i = 0; i < myFile.size(); i++) {
					String path = nameList[i] + "@" + new Date().getTime() + getExtention(this.myFileFileName.get(i));
					StringBuilder builder = new StringBuilder();
					builder.append(pathString);
					builder.append("/technical/");
					builder.append(path);
					File newFile = new File(builder.toString());
					StringBuilder builder2 = new StringBuilder();
					builder2.append("D:/java/workspace/UTPTd/WebContent/upload/technical/");
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
