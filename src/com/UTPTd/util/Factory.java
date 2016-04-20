package com.UTPTd.util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;








import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.UTPTd.action.UpLoadAction;
import com.UTPTd.bean.UtpAdmin;
import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpAdminDao;
import com.UTPTd.dao.UtpAuditorDao;
import com.UTPTd.dao.UtpHighTeacherDao;
import com.UTPTd.dao.UtpTechnicalDao;
import com.UTPTd.daoImpl.UtpAdminDaoImpl;
import com.UTPTd.daoImpl.UtpAuditorDaoImpl;
import com.UTPTd.daoImpl.UtpHighTeacherDaoImpl;
import com.UTPTd.daoImpl.UtpTechnicalDaoImpl;
import com.UTPTd.services.UTPAuditorServices;
import com.UTPTd.services.UtpAdminServices;
import com.UTPTd.services.UtpHighTeacherServices;
import com.UTPTd.services.UtpTechnicalServices;
import com.UTPTd.servicesImpl.UtpAdminServicesImpl;
import com.UTPTd.servicesImpl.UtpAuditorServicesImpl;
import com.UTPTd.servicesImpl.UtpHighTeacherServicesImpl;
import com.UTPTd.servicesImpl.UtpTechnicalServicesImpl;
import com.opensymphony.xwork2.ActionContext;

public class Factory {
	private static Configuration configuration = new Configuration().configure();
	private static ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	private static SessionFactory sf = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);
	
	private static UTPAuditorServices UAS = new UtpAuditorServicesImpl();
	
	private static UtpAuditorDao UAD = new UtpAuditorDaoImpl();
	
	private static UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
	
	private static UtpHighTeacherServices UHTS = new UtpHighTeacherServicesImpl();
	
	private static UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
	
	private static UtpTechnicalServices UTS = new UtpTechnicalServicesImpl();
	
	private static UtpAdminServices UA = new UtpAdminServicesImpl();
	
	private static UtpAdminDao UD = new UtpAdminDaoImpl();
	/**
	 * @param args
	 * @throws IOException
	 */
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		new SchemaExport(configuration).create(true, true);//hibernate 4.0的建表方法
		/*UtpHighTeacher utpHighTeacher = new UtpHighTeacher();
		utpHighTeacher.setUtpHighTeacherIdCard(330226);
		utpHighTeacher.setUtpHighTeacherName("李宁");
		utpHighTeacher.setUtpHighTeacherGender("男");
		utpHighTeacher.setUtpHighTeacherAge(22);
		utpHighTeacher.setUtpHighTeacherBirthday("1993-11-12");
		utpHighTeacher.setUtpHighTeacherCareerBegin("2016-2-22");
		utpHighTeacher.setUtpHighTeacherEducation("本科");
		utpHighTeacher.setUtpHighTeacherCollege("山东建筑大学");
		utpHighTeacher.setUtpHighTeacherMajor("软件工程");
		utpHighTeacher.setUtpHighTeacherPostNow("初级程序员");
		utpHighTeacher.setUtpHighTeacherDeclarePost("中级程序员");
		utpHighTeacher.setUtpHighTeacherCET("四级");
		utpHighTeacher.setUtpHighTeacherComputer("二级");
		utpHighTeacher.setUtpHighTeacherAssessment(null);
		utpHighTeacher.setUtpHighTeacherPhotoUrl(null);
		utpHighTeacher.setUtpHighTeacherRefresher(null);
		utpHighTeacher.setUtpHighTeacherSeniority(null);
		utpHighTeacher.setUtpHighTeacherTeaching(null);
		utpHighTeacher.setUtpHighTeacherOther(null);
		utpHighTeacher.setUtpHighTeacherSubmit(1);
		utpHighTeacher.setUtpHighTeacherIsSubmit(0);
		utpHighTeacher.setUtpHighTeacherWhichSubmit(1);
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(utpHighTeacher);
		session.getTransaction().commit();
		session.close();*/
		/*UtpTechnical utpTechnical = new UtpTechnical();
		utpTechnical.setUtpTechnicalIdCard(330226);
		utpTechnical.setUtpTechnicalName("李宁");
		utpTechnical.setUtpTechnicalGender("男");
		utpTechnical.setUtpTechnicalAge(22);
		utpTechnical.setUtpTechnicalBirthday("1993-11-12");
		utpTechnical.setUtpTechnicalCareerBegin("2016-2-22");
		utpTechnical.setUtpTechnicalEducation("本科");
		utpTechnical.setUtpTechnicalCollege("山东建筑大学");
		utpTechnical.setUtpTechnicalMajor("软件工程");
		utpTechnical.setUtpTechnicalPostNow("初级程序员");
		utpTechnical.setUtpTechnicalDeclarePost("中级程序员");
		utpTechnical.setUtpTechnicalCET("四级");
		utpTechnical.setUtpTechnicalComputer("二级");
		utpTechnical.setUtpTechnicalAssessment(null);
		utpTechnical.setUtpTechnicalPhotoUrl(null);
		utpTechnical.setUtpTechnicalSeniority(null);
		utpTechnical.setUtpTechnicalAchievement(null);
		utpTechnical.setUtpTechnicalSubmit(1);
		utpTechnical.setUtpTechnicalIsSubmit(0);
		utpTechnical.setUtpTechnicalCountSubmit(1);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(utpTechnical);
		session.getTransaction().commit();
		session.close();*/
//		System.out.println(UHTS.IsNameCorrect(330226, "李宁"));
//		System.out.println( "李宁".equals(UHTD.FindByHighTeacherIdCard(330226).getUtpHighTeacherName()));
//		System.out.println(UTD.FindByTechnicalIdCard(330226).getUtpTechnicalName());
//		UpLoadDao uDao = new UpLoadDao();
/*		File file = new File("C:/Users/Administrator/Desktop/材料处理工具/测试.jpg");
		File file2 = new File("C:/Users/Administrator/Desktop/材料处理工具/测试2.jpg");
		
		uDao.upLoadFile(file2, file);*/
		
//		String path = "2";
//		System.out.println(!"".equals(path));
		
//		String[] aaStrings = {"1","2","3"};
//		String bb = "";
//		for (int i = 0; i < aaStrings.length; i++) {
//			bb = bb + aaStrings[i] + ",";
//		}
//		System.out.println(bb);
		//System.out.println(new Date().getHours() + "" + new Date().getMinutes());
//		StringBuffer stringBuffer = new StringBuffer();
//		stringBuffer.append("2");
//		stringBuffer.append("bb");
//		stringBuffer.append("3");
//		System.out.println(stringBuffer);
//		uDao.deleteFileByName(0, "在线@2221.txt");
//		System.out.println(UA.Login("admin", "admin"));
//		File file = new File("D:/java/workspace/UTPTd/WebContent/upload/teacher/");
//		String[] filenameString = file.list();
//		for (int i = 0; i < filenameString.length; i++) {
//			if (!"小娃@2221.txt".equals(filenameString[i])) {
//				System.out.println("行");
//			} else {
//				System.out.println("no");
//			}
//		}
//		System.out.println(UD.FindUseOtherFileTechnical());
//		String[] arr = {"1", "2", "3", "4"};
//		String[] ar = {"2", "3"};
//		ArrayList<String> list = new ArrayList<String>();
//		for (int i = 0; i < ar.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				if (ar[i].equals(arr[j])) {
//					arr[j] = null;
//				}
//			}
//		}
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] != null) {
//				list.add(arr[i]);
//			}
//		}
//		for (String string : list) {
//			System.out.println(string);
//		}
		/*	UtpHighTeacher uTeacher = actionContext.getBean(UtpHighTeacher.class);
		uTeacher.setUtpHighTeacherAcademic("222");
		System.out.println(uTeacher.getUtpHighTeacherAcademic());
		Tea ttTea = actionContext.getBean(Tea.class);
		ttTea.teaShow();*/
//		UtpAdminDao uAdminDao = actionContext.getBean(UtpAdminDaoImpl.class);
//		System.out.println((uAdminDao.FindByUtpName("admin")).getPassword());
		/*DataDao dd = (DataDao) actionContext.getBean("dao");
		try {
			Connection conn = dd.getDataSource().getConnection();
			System.out.println(conn.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
//		SessionFactory sessionFactory = (SessionFactory) aContext.getBean("sessionfactory");
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		UtpAdmin uAdmin = aContext.getBean(UtpAdmin.class);
//		uAdmin = (UtpAdmin) session.get(UtpAdmin.class, "admin");
//		session.getTransaction().commit();
//		session.close();
//		System.out.println(uAdmin.getPassword());
		//UpLoadDao uDao = aContext.getBean(UpLoadDao.class);
		//System.out.println(uDao.getProp("teacherPath"));
	}
	
}
