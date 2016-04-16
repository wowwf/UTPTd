package com.UTPTd.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpAdmin;
import com.UTPTd.dao.UtpAdminDao;

@Component
public class UtpAdminDaoImpl implements UtpAdminDao {
	private static Configuration configuration = new Configuration().configure();
	private static ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	private static SessionFactory sf = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);
	
	@Override
	public UtpAdmin FindByUtpName(String UtpName) {
		Session session = sf.openSession();
		session.beginTransaction();
		UtpAdmin Uadmin = (UtpAdmin) session.get(UtpAdmin.class, UtpName);
		session.getTransaction().commit();
		session.close();
		return Uadmin;
	}

	@Override
	public String FindPsdByName(String UtpName) {
		UtpAdmin utpAdmin = new UtpAdmin();
		UtpAdminDao utpAdminDao = new UtpAdminDaoImpl();
		utpAdmin = utpAdminDao.FindByUtpName(UtpName);
		return utpAdmin.getPassword();
	}

	@SuppressWarnings("unchecked")
	@Override
	public String FindUseFromTeacher() {
		Session session = sf.openSession();
		session.beginTransaction();
		String hql = "select a.utpHighTeacherPhotoUrl from UtpHighTeacher a";
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		session.getTransaction().commit();
		session.close();
		if (list.size() == 0) {
			return null;
		} else {
			String pathString = "";
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null) {
					pathString = pathString + list.get(i) + ",";
				}
			}
			return pathString;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String FindUseFromTechnical() {
		Session session = sf.openSession();
		session.beginTransaction();
		String hql = "select b.utpTechnicalPhotoUrl from UtpTechnical b";
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		session.getTransaction().commit();
		session.close();
		if (list.size() == 0) {
			return null;
		} else {
			String pathString = "";
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null) {
					pathString = pathString + list.get(i) + ",";
				}
			}
			return pathString;
		}
	}

	@Override
	public String FindUseOtherFileTeacher() {
		Session session = sf.openSession();
		session.beginTransaction();
		String hql = "select a.utpHighTeacherOther from UtpHighTeacher a";
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		session.getTransaction().commit();
		session.close();
		if (list.size() == 0) {
			return null;
		} else {
			String pathString = "";
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null) {
					pathString = pathString + list.get(i);
				}
			}
			return pathString;
		}
	}

	@Override
	public String FindUseOtherFileTechnical() {
		Session session = sf.openSession();
		session.beginTransaction();
		String hql = "select b.utpTechnicalPublication from UtpTechnical b";
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		session.getTransaction().commit();
		session.close();
		if (list.size() == 0) {
			return null;
		} else {
			String pathString = "";
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null) {
					pathString = pathString + list.get(i);
				}
			}
			return pathString;
		}
	}

}
