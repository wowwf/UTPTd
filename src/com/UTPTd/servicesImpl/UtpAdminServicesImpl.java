package com.UTPTd.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.dao.UtpAdminDao;
import com.UTPTd.daoImpl.UtpAdminDaoImpl;
import com.UTPTd.services.UtpAdminServices;
import com.UTPTd.util.UpLoadDao;

@Component
public class UtpAdminServicesImpl implements UtpAdminServices {
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	@Override
	public boolean FindByName(String UtpName) {
		UtpAdminDao UAD = aContext.getBean(UtpAdminDaoImpl.class);
		if (UAD.FindByUtpName(UtpName) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean Login(String UtpName, String UtpPassword) {
		UtpAdminDao UAD = aContext.getBean(UtpAdminDaoImpl.class);
		if (UtpPassword.equals(UAD.FindPsdByName(UtpName))) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean DeleteOtherFile(String personFile, String serverPath) {
		if ("teacher".equals(personFile)) {
			UtpAdminDao UAD = aContext.getBean(UtpAdminDaoImpl.class);
			ArrayList<String> fileList = new ArrayList<String>();
			String findString = UAD.FindUseOtherFileTeacher();
			if (findString != null) {
				UpLoadDao UD = aContext.getBean(UpLoadDao.class);
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
			UtpAdminDao UAD = aContext.getBean(UtpAdminDaoImpl.class);
			ArrayList<String> fileList = new ArrayList<String>();
			String findString = UAD.FindUseOtherFileTechnical();
			if (findString != null) {
				UpLoadDao UD = aContext.getBean(UpLoadDao.class);
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

	@Override
	public List<UtpAuditor> findAllAuditors() {
		UtpAdminDao UAD = aContext.getBean(UtpAdminDaoImpl.class);
		List<UtpAuditor> list = UAD.FindAll();
		return list;
	}

	@Override
	public UtpAuditor findAuditor(String idCard) {
		UtpAdminDao UAD = aContext.getBean(UtpAdminDaoImpl.class);
		UtpAuditor utpAuditor = UAD.selectAuditor(idCard);
		return utpAuditor;
	}

	@Override
	public void updateAuditor(UtpAuditor utpAuditor) {
		UtpAdminDao UAD = aContext.getBean(UtpAdminDaoImpl.class);
		UAD.updateAuditor(utpAuditor);
	}

	@Override
	public void deleteAuditor(String idCard) {
		UtpAdminDao UAD = aContext.getBean(UtpAdminDaoImpl.class);
		UAD.deleteAuditor(idCard);
	}

	@Override
	public void insertAuditor(UtpAuditor utpAuditor) {
		UtpAdminDao UAD = aContext.getBean(UtpAdminDaoImpl.class);
		UAD.insertAuditor(utpAuditor);
	}

	@Override
	public void deleteAuditorOpinion(String idCard) {
		UtpAdminDao UAD = aContext.getBean(UtpAdminDaoImpl.class);
		UAD.deleteAuditorOpinion(idCard);
	}
	
}
