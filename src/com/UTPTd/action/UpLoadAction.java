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

public class UpLoadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String UP = "/upload";
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
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
			UpLoadDao ULD = aContext.getBean(UpLoadDao.class);
			UtpHighTeacher teacher = (UtpHighTeacher) session.get("HighTeacher");
			UtpTechnical technical = (UtpTechnical) session.get("Technical");
			ActionContext context = ActionContext.getContext();
			String serverPath = ServletActionContext.getServletContext().getRealPath(UP);
			String imageFileName = new Date().getTime() + getExtention(this.upFileFileName.get(0));
			File imageFile = null;
			String imageNewPath = "";
			String againPath = "";
			if (teacher != null) {
				UtpHighTeacherDao UHTD = aContext.getBean(UtpHighTeacherDaoImpl.class);
				String localString = UHTD.FindPersonImageUrl(teacher.getUtpHighTeacherIdCard());
				if (localString != null) {
					String[] localPath = localString.split("/");
					ULD.deleteFileByName(0, localPath[2].toString(), serverPath);
				}
				imageFile = new File(serverPath + "/teacher/" + imageFileName);
				//公司
				//againPath = ULD.getProp("teacherPath") + imageFileName;
				//个人
				againPath = ULD.getProp("teaPath") + imageFileName;
				ULD.upLoadFile(imageFile, upFile.get(0), againPath);
				imageNewPath = "upload/teacher/" + imageFileName;
				UHTD.PersonImgUpload(teacher.getUtpHighTeacherIdCard(), imageNewPath);
				context.put("Imgpath", imageNewPath);
				flag = "success";
			} else if (technical != null) {
				UtpTechnicalDao UTD = aContext.getBean(UtpTechnicalDaoImpl.class);
				String pathString = UTD.FindPersonImgUrl(technical.getUtpTechnicalIdCard());
				if (pathString != null) {
					String[] localPath = pathString.split("/");
					ULD.deleteFileByName(1, localPath[2].toString(), serverPath);
				}
				imageFile = new File(serverPath + "/technical/" + imageFileName);
				//公司
				//againPath = ULD.getProp("technicalPath") + imageFileName;
				//个人
				againPath = ULD.getProp("teacalPath") + imageFileName;
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
