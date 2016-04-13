package com.UTPTd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpTechnicalDao;

public class UtpTechnicalDaoImpl implements UtpTechnicalDao {
	
	private static UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
	private static Configuration configuration = new Configuration().configure();
	private static ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	private static SessionFactory sf = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);
	
	// TODO Auto-generated method stub
	@Override
	public void InsertTechnical(Integer IdCard, String TechnicalName) {
		UtpTechnical utpTechnical = new UtpTechnical();
		utpTechnical.setUtpTechnicalIdCard(IdCard);
		utpTechnical.setUtpTechnicalName(TechnicalName);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(utpTechnical);
		session.getTransaction().commit();
		session.close();
	}

	// TODO Auto-generated method stub
	@Override
	public void UpdateTechnical(UtpTechnical utpTechnical) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(utpTechnical);
		session.getTransaction().commit();
		session.close();
	}

	// TODO Auto-generated method stub
	@Override
	public UtpTechnical FindByTechnicalIdCard(Integer IdCard) {
		Session session = sf.openSession();
		session.beginTransaction();
		UtpTechnical utpTechnical = (UtpTechnical) session.get(UtpTechnical.class, IdCard);
		session.getTransaction().commit();
		session.close();
		return utpTechnical;
	}

	// TODO Auto-generated method stub
	@Override
	public Integer FindIsPassByTechnicalIdCard(Integer IdCard) {
		UtpTechnical utpTechnical = new UtpTechnical();
		UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
		utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
		return utpTechnical.getUtpTechnicalIsSubmit();
	}

	// TODO Auto-generated method stub
	@Override
	public Integer FindSubmitByTechnicalIdCard(Integer IdCard) {
		UtpTechnical utpTechnical = new UtpTechnical();
		UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
		utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
		return utpTechnical.getUtpTechnicalSubmit();
	}

	// TODO Auto-generated method stub
	@Override
	public Integer FindWhichSubmitByTechnicalIdCard(Integer IdCard) {
		UtpTechnical utpTechnical = new UtpTechnical();
		UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
		utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
		return utpTechnical.getUtpTechnicalCountSubmit();
	}

	// TODO Auto-generated method stub
	@Override
	public void UpdateTechnicalSubmitIsNotPass(Integer IdCard) {
		UtpTechnical utpTechnical = new UtpTechnical();
		UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
		utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
		utpTechnical.setUtpTechnicalIsSubmit(0);
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(utpTechnical);
		session.getTransaction().commit();
		session.close();
	}

	// TODO Auto-generated method stub
	@Override
	public void UpdateTechnicalSubmitIsPass(Integer IdCard) {
		UtpTechnical utpTechnical = new UtpTechnical();
		UtpTechnicalDao UTD = new UtpTechnicalDaoImpl();
		utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
		utpTechnical.setUtpTechnicalIsSubmit(1);
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(utpTechnical);
		session.getTransaction().commit();
		session.close();
	}

	// TODO Auto-generated method stub
	@Override
	public List<UtpTechnical> FindAllByUtpTechnicalIsPass(Integer IsPass) {
		List<UtpTechnical> utpTechnical = new ArrayList<UtpTechnical>();
		utpTechnical = null;
		switch (IsPass) {
		case 0:
			utpTechnical = UTD.FindUtpTechnicalByIsPass(IsPass);
			break;
		case 1:
			utpTechnical = UTD.FindUtpTechnicalByIsPass(IsPass);
			break;
		default:
			utpTechnical = null;
			break;
		}
		return utpTechnical;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UtpTechnical> FindUtpTechnicalByIsPass(Integer isPassInteger) {
		List<UtpTechnical> utpTechnical = new ArrayList<UtpTechnical>();
		Session session = sf.openSession();
		session.beginTransaction();
		String hqlString = "from UtpTechnical as utp where utp.UtpTechnicalIsSubmit = :pass";
		Query query2 = session.createQuery(hqlString);
		query2.setParameter("pass", isPassInteger);
		utpTechnical = query2.list();
		session.getTransaction().commit();
		session.close();
		return utpTechnical;
	}

	@Override
	public void PersonImgUpload(Integer IdCard, String savePath) {
		UtpTechnical utpTechnical = new UtpTechnical();
		Session session = sf.openSession();
		session.beginTransaction();
		utpTechnical = (UtpTechnical) session.get(UtpTechnical.class, IdCard);
		utpTechnical.setUtpTechnicalPhotoUrl(savePath);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public String FindPersonImgUrl(Integer IdCard) {
		Session session = sf.openSession();
		session.beginTransaction();
		UtpTechnical utpTechnical = (UtpTechnical) session.get(UtpTechnical.class, IdCard);
		session.getTransaction().commit();
		session.close();
		return utpTechnical.getUtpTechnicalPhotoUrl();
	}

}
