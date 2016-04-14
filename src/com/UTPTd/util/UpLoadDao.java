package com.UTPTd.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.filefilter.FileFileFilter;


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
}
