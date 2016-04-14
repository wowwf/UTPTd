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

public class UpLoadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String UP = "/upload";
	
	private static UpLoadDao ULD = new UpLoadDao();
	
	private static UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
	
	private static UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();

	private List<File> upFile;
	
	private List<String> upFileFileName;
	
	private List<String> upFileContentType;
	
	public List<File> getUpFile() {
		return upFile;
	}

	public List<String> getUpFileFileName() {
		return upFileFileName;
	}

	public List<String> getUpFileContentType() {
		return upFileContentType;
	}

	public void setUpFile(List<File> upFile) {
		this.upFile = upFile;
	}

	public void setUpFileFileName(List<String> upFileFileName) {
		this.upFileFileName = upFileFileName;
	}

	public void setUpFileContentType(List<String> upFileContentType) {
		this.upFileContentType = upFileContentType;
	}

	private static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}
	
	@Override
	public String execute() throws Exception {
		String flag = "";
		if (this.upFile == null) {
			addActionMessage("请选择一寸照片！");
			flag = "isnull";
		} else {
			Map<String, Object> session = ActionContext.getContext().getSession();
			UtpHighTeacher teacher = (UtpHighTeacher) session.get("HighTeacher");
			UtpTechnical technical = (UtpTechnical) session.get("Technical");
			ActionContext context = ActionContext.getContext();
			String serverPath = ServletActionContext.getServletContext().getRealPath(UP);
			String imageFileName = new Date().getTime() + getExtention(this.upFileFileName.get(0));
			File imageFile = null;
			String imageNewPath = "";
			String againPath = "";
			if (teacher != null) {
				String[] localPath = (UHTD.FindPersonImageUrl(teacher.getUtpHighTeacherIdCard())).split("/");
				System.out.println(localPath[2].toString());
				ULD.deleteFileByName(0, localPath[2].toString(), serverPath);
				imageFile = new File(serverPath + "/teacher/" + imageFileName);
				//againPath = "D:/dx/workspeace/UTPTd/WebContent/upload/teacher/" + imageFileName;
				againPath = "D:/java/workspace/UTPTd/WebContent/upload/teacher/" + imageFileName;
				ULD.upLoadFile(imageFile, upFile.get(0), againPath);
				imageNewPath = "upload/teacher/" + imageFileName;
				UHTD.PersonImgUpload(teacher.getUtpHighTeacherIdCard(), imageNewPath);
				context.put("Imgpath", imageNewPath);
				flag = "success";
			} else if (technical != null) {
				String[] localPath = (UTD.FindPersonImgUrl(technical.getUtpTechnicalIdCard())).split("/");
				System.out.println(localPath[2].toString());
				ULD.deleteFileByName(1, localPath[2].toString(), serverPath);
				imageFile = new File(serverPath + "/technical/" + imageFileName);
				//againPath = "D:/dx/workspeace/UTPTd/WebContent/upload/technical/" + imageFileName;
				againPath = "D:/java/workspace/UTPTd/WebContent/upload/technical/" + imageFileName;
				ULD.upLoadFile(imageFile, upFile.get(0), againPath);
				imageNewPath = "upload/technical/" + imageFileName;
				UTD.PersonImgUpload(technical.getUtpTechnicalIdCard(), imageNewPath);
				context.put("Imgpath", imageNewPath);
				flag = "success";
			} else {
				addFieldError("fileUploadError", "您未登录，请先登录！");
				flag = "error";
			}
			System.out.println(imageFile.toString());
		}
		return flag;
	}
	
}
