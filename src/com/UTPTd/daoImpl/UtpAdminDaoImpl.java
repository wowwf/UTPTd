package com.UTPTd.daoImpl;

import java.util.List;

import oracle.net.aso.l;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpAdmin;
import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.dao.UtpAdminDao;

@Component
public class UtpAdminDaoImpl implements UtpAdminDao {
	
	private static ApplicationContext Context = new ClassPathXmlApplicationContext("beans.xml");
	private static SessionFactory sf = (SessionFactory) Context.getBean("sessionfactory");
	
	@Override
	public UtpAdmin FindByUtpName(String UtpName) {
		UtpAdmin Uadmin = Context.getBean(UtpAdmin.class);
		Session session = sf.openSession();
		session.beginTransaction();
		Uadmin = (UtpAdmin) session.get(UtpAdmin.class, UtpName);
		session.getTransaction().commit();
		session.close();
		return Uadmin;
	}

	@Override
	public String FindPsdByName(String UtpName) {
		UtpAdmin utpAdmin = Context.getBean(UtpAdmin.class);
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

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
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

	@Override
	public List<UtpAuditor> FindAll() {
		String hql = "from UtpAuditor";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		List<UtpAuditor> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public void insertAuditor(UtpAuditor utpAuditor) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(utpAuditor);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateAuditor(UtpAuditor utpAuditor) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(utpAuditor);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteAuditor(String IdCard) {
		String hql = "delete from UtpAuditor as a where a.utpAuditorIdCard = :id";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("id", IdCard);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public UtpAuditor selectAuditor(String IdCard) {
		Session session = sf.openSession();
		session.beginTransaction();
		UtpAuditor uAuditor = (UtpAuditor) session.get(UtpAuditor.class, IdCard);
		session.getTransaction().commit();
		session.close();
		return uAuditor;
	}

	@Override
	public void deleteAuditorOpinion(String IdCard) {
		String hql = "delete from AuditorOpinion where auditorId = :id";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("id", IdCard);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

}
