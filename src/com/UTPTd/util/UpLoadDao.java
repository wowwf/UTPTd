package com.UTPTd.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class UpLoadDao {
	
	//上传文件到服务器,拷贝到项目文件夹
	public void upLoadFile(File fileLocal, File file, String beifenPath) throws IOException{
		InputStream inputStream = null;
		OutputStream outputStream = null;
		OutputStream outputStream2 = null;
		File againFile = new File(beifenPath);
		try {
			inputStream = new BufferedInputStream(new FileInputStream(file));
			outputStream = new BufferedOutputStream(new FileOutputStream(fileLocal));
			outputStream2 = new BufferedOutputStream(new FileOutputStream(againFile));
			byte[] buffer = new byte[inputStream.available()];
			while (inputStream.read(buffer) > 0) {
				outputStream.write(buffer);
				outputStream2.write(buffer);
			}
		} catch (Exception e) {
			System.out.println("上传文件出错");
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
	//删除文件，0教师，1技术人员
	public void deleteFileByName(int number, String path, String serverPath) {
		String[] nameList = path.split(",");
		String teacherPath = "D:/java/workspace/UTPTd/WebContent/upload/teacher/";
		String technicalPath = "D:/java/workspace/UTPTd/WebContent/upload/technical/";
		switch (number) {
		case 0:
			for (int i = 0; i < nameList.length; i++) {
				File file = new File(teacherPath + nameList[i]);
				File file2 = new File(serverPath + "/teacher/" + nameList[i]);
				if (file.exists()) {
					file.delete();
				} else {
					System.out.println("项目文件夹里没有这个" + nameList[i].toString() + "文件！");
				}
				if (file2.exists()) {
					file2.delete();
				} else {
					System.out.println("服务器上没有这个" + nameList[i].toString() + "文件！");
				}
			}
			break;
		case 1:
			for (int i = 0; i < nameList.length; i++) {
				File file = new File(technicalPath + nameList[i]);
				File file2 = new File(serverPath + "/technical/" + nameList[i]);
				if (file.exists()) {
					file.delete();
				} else {
					System.out.println("项目文件夹里没有这个" + nameList[i].toString() + "文件！");
				}
				if (file2.exists()) {
					file2.delete();
				} else {
					System.out.println("服务器上没有这个" + nameList[i].toString() + "文件！");
				}
			}
			break;
		default:
			System.out.println("系统故障！");
			break;
		}
	}
	//检索文件中的所有文件列表，根据传过来的数组，把多余的文件删除 
	public void deleteNoUseFile(String personFile, ArrayList<String> fileList, String serverPath) {
		if ("teacher".equals(personFile)) {
			String personPath = "D:/java/workspace/UTPTd/WebContent/upload/teacher/";
			File file = new File(personPath);
			String[] fileName = file.list();
			for (int i = 0; i < fileList.size(); i++) {
				for (int j = 0; j < fileName.length; j++) {
					if (fileList.get(i).equals(fileName[j])) {
						fileName[j] = null;
					}
				}
			}
			for (int i = 0; i < fileName.length; i++) {
				if (fileName[i] != null) {
					File deleteListFile = new File(personPath + fileName[i]);
					deleteListFile.delete();
				}
			}
			File serverFile = new File(serverPath + "/teacher/");
			String[] serverFileName = serverFile.list();
			for (int i = 0; i < fileList.size(); i++) {
				for (int j = 0; j < serverFileName.length; j++) {
					if (fileList.get(i).equals(serverFileName[j])) {
						serverFileName[j] = null;
					}
				}
			}
			for (int i = 0; i < serverFileName.length; i++) {
				if (serverFileName[i] != null) {
					File deleteListFile = new File(serverPath + "/teacher/" + serverFileName[i]);
					deleteListFile.delete();
				}
			}
		} else if("technical".equals(personFile)) {
			String personPath = "D:/java/workspace/UTPTd/WebContent/upload/technical/";
			File file = new File(personPath);
			String[] fileName = file.list();
			for (int i = 0; i < fileList.size(); i++) {
				for (int j = 0; j < fileName.length; j++) {
					if (fileList.get(i).equals(fileName[j])) {
						fileName[j] = null;
					}
				}
			}
			for (int i = 0; i < fileName.length; i++) {
				if (fileName[i] != null) {
					File deleteListFile = new File(personPath + fileName[i]);
					deleteListFile.delete();
				}
			}
			File serverFile = new File(serverPath + "/technical/");
			String[] serverFileName = serverFile.list();
			for (int i = 0; i < fileList.size(); i++) {
				for (int j = 0; j < serverFileName.length; j++) {
					if (fileList.get(i).equals(serverFileName[j])) {
						serverFileName[j] = null;
					}
				}
			}
			for (int i = 0; i < serverFileName.length; i++) {
				if (serverFileName[i] != null) {
					File deleteListFile = new File(serverPath + "/technical/" + serverFileName[i]);
					deleteListFile.delete();
				}
			}
		} else {
			System.out.println("第一个参数传入错误！");
		}
	}
}
