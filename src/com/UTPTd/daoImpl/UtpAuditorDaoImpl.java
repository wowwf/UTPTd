package com.UTPTd.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.dao.UtpAuditorDao;

public class UtpAuditorDaoImpl implements UtpAuditorDao {

	private static Configuration configuration = new Configuration().configure();
	private static ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	private static SessionFactory sf = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);
	
	@Override
	public UtpAuditor FindById(Integer IdCard) {
		UtpAuditor utpAuditor = new UtpAuditor();
		Session session = sf.openSession();
		session.beginTransaction();
		utpAuditor = (UtpAuditor) session.get(UtpAuditor.class, IdCard);
		/*String hqlString = "from UtpAuditor where UtpAuditorIdCard = :Id and UtpAuditorRole = :role";
		Query query = session.createQuery(hqlString);
		query.setParameter("Id", IdCard);
		query.setParameter("role", Role);
		List<UtpAuditor> auditors = query.list();
		utpAuditor.setUtpAuditorIdCard(auditors.get(0).getUtpAuditorIdCard());
		utpAuditor.setUtpAuditorName(auditors.get(0).getUtpAuditorName());
		utpAuditor.setUtpAuditorPassword(auditors.get(0).getUtpAuditorPassword());
		utpAuditor.setUtpAuditorRole(auditors.get(0).getUtpAuditorRole());*/
		return utpAuditor;
	}

	@Override
	public String FindPsdById(Integer IdCard) {
		UtpAuditorDao UAD = new UtpAuditorDaoImpl();
		UtpAuditor utpAuditor = new UtpAuditor();
		utpAuditor = UAD.FindById(IdCard);
		return utpAuditor.getUtpAuditorPassword();
	}

	@Override
	public Integer FindRoleById(Integer IdCard) {
		UtpAuditorDao UAD = new UtpAuditorDaoImpl();
		UtpAuditor utpAuditor = new UtpAuditor();
		utpAuditor = UAD.FindById(IdCard);
		return utpAuditor.getUtpAuditorRole();
	}

}
