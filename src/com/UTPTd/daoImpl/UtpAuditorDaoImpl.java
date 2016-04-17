package com.UTPTd.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.dao.UtpAuditorDao;

@Component
public class UtpAuditorDaoImpl implements UtpAuditorDao {

	private static ApplicationContext Context = new ClassPathXmlApplicationContext("beans.xml");
	private static SessionFactory sf = (SessionFactory) Context.getBean("sessionfactory");
	
	@Override
	public UtpAuditor FindById(Integer IdCard) {
		UtpAuditor utpAuditor = Context.getBean(UtpAuditor.class);
		Session session = sf.openSession();
		session.beginTransaction();
		utpAuditor = (UtpAuditor) session.get(UtpAuditor.class, IdCard);
		return utpAuditor;
	}

	@Override
	public String FindPsdById(Integer IdCard) {
		UtpAuditorDao UAD = Context.getBean(UtpAuditorDaoImpl.class);
		UtpAuditor utpAuditor = Context.getBean(UtpAuditor.class);
		utpAuditor = UAD.FindById(IdCard);
		return utpAuditor.getUtpAuditorPassword();
	}

	@Override
	public Integer FindRoleById(Integer IdCard) {
		UtpAuditorDao UAD = Context.getBean(UtpAuditorDaoImpl.class);
		UtpAuditor utpAuditor = Context.getBean(UtpAuditor.class);
		utpAuditor = UAD.FindById(IdCard);
		return utpAuditor.getUtpAuditorRole();
	}

}
