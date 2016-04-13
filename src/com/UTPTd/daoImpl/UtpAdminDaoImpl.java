package com.UTPTd.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.UTPTd.bean.UtpAdmin;
import com.UTPTd.dao.UtpAdminDao;

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

}
