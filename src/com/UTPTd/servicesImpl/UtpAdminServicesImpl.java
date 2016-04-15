package com.UTPTd.servicesImpl;

import java.util.ArrayList;

import com.UTPTd.dao.UtpAdminDao;
import com.UTPTd.daoImpl.UtpAdminDaoImpl;
import com.UTPTd.services.UtpAdminServices;
import com.UTPTd.util.UpLoadDao;

public class UtpAdminServicesImpl implements UtpAdminServices {
	//声明UtpAdminDaoImpl对象
	private static UtpAdminDao UAD = new UtpAdminDaoImpl();
	
	private static UpLoadDao UD = new UpLoadDao();

	@Override
	public boolean FindByName(String UtpName) {
		if (UAD.FindByUtpName(UtpName) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean Login(String UtpName, String UtpPassword) {
		if (UtpPassword.equals(UAD.FindPsdByName(UtpName))) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean DeleteOtherFile(String personFile, String serverPath) {
		if ("teacher".equals(personFile)) {
			ArrayList<String> fileList = new ArrayList<String>();
			String findString = UAD.FindUseOtherFileTeacher();
			if (findString != null) {
				String[] fileMid = findString.split(",");
				for (int i = 0; i < fileMid.length; i++) {
					fileList.add(fileMid[i]);
				}			
				UD.deleteNoUseFile(personFile, fileList, serverPath);
				return true;
			} else {
				System.out.println("数据库中没有文件！");
				return false;
			}
		} else if ("technical".equals(personFile)) {
			ArrayList<String> fileList = new ArrayList<String>();
			String findString = UAD.FindUseOtherFileTechnical();
			if (findString != null) {
				String[] fileMid = findString.split(",");
				for (int i = 0; i < fileMid.length; i++) {
					fileList.add(fileMid[i]);
				}
				UD.deleteNoUseFile(personFile, fileList, serverPath);
				return true;
			} else {
				System.out.println("数据库中没有文件！");
				return false;
			}
		} else {
			System.out.println("删除错误，第一个参数传入错误！");
			return false;
		}
	}
	
}
