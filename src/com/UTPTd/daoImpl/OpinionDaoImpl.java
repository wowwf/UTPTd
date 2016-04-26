package com.UTPTd.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.bean.AuditorOpinion;
import com.UTPTd.dao.OpinionDao;

@Component
public class OpinionDaoImpl implements OpinionDao {

	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private static SessionFactory sf = (SessionFactory) aContext.getBean("sessionfactory");
	
	@Override
	public void insertMessage(AuditorOpinion aOpinion) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(aOpinion);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<AuditorOpinion> findOpinion(String idCard) {
		Session session = sf.openSession();
		session.beginTransaction();
		String hql = "from AuditorOpinion as a where a.teacherId = :teacher";
		Query query = session.createQuery(hql);
		query.setParameter("teacher", idCard);
		List<AuditorOpinion> aList = query.list();
		session.getTransaction().commit();
		session.close();
		return aList;
	}

}
