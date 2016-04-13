package com.UTPTd.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class UpLoadDao {
	
	//上传文件到服务器
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
}
