package com.UTPTd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpTechnicalDao;

@Component
public class UtpTechnicalDaoImpl implements UtpTechnicalDao {
	
	private static ApplicationContext Context = new ClassPathXmlApplicationContext("beans.xml");
	private static SessionFactory sf = (SessionFactory) Context.getBean("sessionfactory");
	
	@Override
	public void InsertTechnical(String IdCard, String TechnicalName) {
		UtpTechnical utpTechnical = Context.getBean(UtpTechnical.class);
		utpTechnical.setUtpTechnicalIdCard(IdCard);
		utpTechnical.setUtpTechnicalName(TechnicalName);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(utpTechnical);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void UpdateTechnical(UtpTechnical utpTechnical) {
		UtpTechnical uTechnical = Context.getBean(UtpTechnical.class);
		Session session = sf.openSession();
		session.beginTransaction();
		uTechnical = (UtpTechnical) session.get(UtpTechnical.class, utpTechnical.getUtpTechnicalIdCard());
		if (utpTechnical.getUtpTechnicalAge() != null) {
			uTechnical.setUtpTechnicalAge(utpTechnical.getUtpTechnicalAge());
		}
		uTechnical.setUtpTechnicalGender(utpTechnical.getUtpTechnicalGender());
		if (!"".equals(utpTechnical.getUtpTechnicalBirthday())) {
			uTechnical.setUtpTechnicalBirthday(utpTechnical.getUtpTechnicalBirthday());
		}
		if (!"".equals(utpTechnical.getUtpTechnicalCareerBegin())) {
			uTechnical.setUtpTechnicalCareerBegin(utpTechnical.getUtpTechnicalCareerBegin());
		}
		if (!"".equals(utpTechnical.getUtpTechnicalGraduateTime())) {
			uTechnical.setUtpTechnicalGraduateTime(utpTechnical.getUtpTechnicalGraduateTime());
		}
		if (!"".equals(utpTechnical.getUtpTechnicalEducation())) {
			uTechnical.setUtpTechnicalEducation(utpTechnical.getUtpTechnicalEducation());
		}
		if (!"".equals(utpTechnical.getUtpTechnicalPostNow())) {
			uTechnical.setUtpTechnicalPostNow(utpTechnical.getUtpTechnicalPostNow());
		}
		if (!"".equals(utpTechnical.getUtpTechnicalCollege())) {
			uTechnical.setUtpTechnicalCollege(utpTechnical.getUtpTechnicalCollege());
		}
		if (!"".equals(utpTechnical.getUtpTechnicalMajor())) {
			uTechnical.setUtpTechnicalMajor(utpTechnical.getUtpTechnicalMajor());
		}
		if (!"".equals(utpTechnical.getUtpTechnicalDeclarePost())) {
			uTechnical.setUtpTechnicalDeclarePost(utpTechnical.getUtpTechnicalDeclarePost());
		}
		if (!"".equals(utpTechnical.getUtpTechnicalCET())) {
			uTechnical.setUtpTechnicalCET(utpTechnical.getUtpTechnicalCET());
		}
		if (!"".equals(utpTechnical.getUtpTechnicalAchievement())) {
			uTechnical.setUtpTechnicalAchievement(utpTechnical.getUtpTechnicalAchievement());
		}
		if (!"".equals(utpTechnical.getUtpTechnicalAssessment())) {
			uTechnical.setUtpTechnicalAssessment(utpTechnical.getUtpTechnicalAssessment());
		}
		if (!"".equals(utpTechnical.getUtpTechnicalSeniority())) {
			uTechnical.setUtpTechnicalSeniority(utpTechnical.getUtpTechnicalSeniority());
		}
		uTechnical.setUtpTechnicalIsSubmit(0);
		uTechnical.setUtpTechnicalSubmit(1);
		uTechnical.setUtpTechnicalCountSubmit(0);
		session.update(uTechnical);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public UtpTechnical FindByTechnicalIdCard(String IdCard) {
		Session session = sf.openSession();
		session.beginTransaction();
		UtpTechnical utpTechnical = (UtpTechnical) session.get(UtpTechnical.class, IdCard);
		session.getTransaction().commit();
		session.close();
		return utpTechnical;
	}

	@Override
	public Integer FindIsPassByTechnicalIdCard(String IdCard) {
		UtpTechnical utpTechnical = Context.getBean(UtpTechnical.class);
		UtpTechnicalDao UTD = Context.getBean(UtpTechnicalDaoImpl.class);
		utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
		return utpTechnical.getUtpTechnicalIsSubmit();
	}

	@Override
	public Integer FindSubmitByTechnicalIdCard(String IdCard) {
		UtpTechnical utpTechnical = Context.getBean(UtpTechnical.class);
		UtpTechnicalDao UTD = Context.getBean(UtpTechnicalDaoImpl.class);
		utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
		return utpTechnical.getUtpTechnicalSubmit();
	}

	@Override
	public Integer FindWhichSubmitByTechnicalIdCard(String IdCard) {
		UtpTechnical utpTechnical = Context.getBean(UtpTechnical.class);
		UtpTechnicalDao UTD = Context.getBean(UtpTechnicalDaoImpl.class);
		utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
		return utpTechnical.getUtpTechnicalCountSubmit();
	}

	@Override
	public void UpdateTechnicalSubmitIsNotPass(String IdCard) {
		UtpTechnical utpTechnical = Context.getBean(UtpTechnical.class);
		UtpTechnicalDao UTD = Context.getBean(UtpTechnicalDaoImpl.class);
		utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
		utpTechnical.setUtpTechnicalIsSubmit(0);
		utpTechnical.setUtpTechnicalCountSubmit(utpTechnical.getUtpTechnicalCountSubmit() + 1);
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(utpTechnical);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void UpdateTechnicalSubmitIsPass(String IdCard) {
		UtpTechnical utpTechnical = Context.getBean(UtpTechnical.class);
		UtpTechnicalDao UTD = Context.getBean(UtpTechnicalDaoImpl.class);
		utpTechnical = UTD.FindByTechnicalIdCard(IdCard);
		utpTechnical.setUtpTechnicalIsSubmit(1);
		utpTechnical.setUtpTechnicalCountSubmit(utpTechnical.getUtpTechnicalCountSubmit() + 1);
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(utpTechnical);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<UtpTechnical> FindAllByUtpTechnicalIsPass(Integer IsPass) {
		List<UtpTechnical> utpTechnical = new ArrayList<UtpTechnical>();
		UtpTechnicalDao UTD = Context.getBean(UtpTechnicalDaoImpl.class);
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
	public void PersonImgUpload(String IdCard, String savePath) {
		UtpTechnical utpTechnical = Context.getBean(UtpTechnical.class);
		Session session = sf.openSession();
		session.beginTransaction();
		utpTechnical = (UtpTechnical) session.get(UtpTechnical.class, IdCard);
		utpTechnical.setUtpTechnicalPhotoUrl(savePath);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public String FindPersonImgUrl(String IdCard) {
		Session session = sf.openSession();
		session.beginTransaction();
		UtpTechnical utpTechnical = (UtpTechnical) session.get(UtpTechnical.class, IdCard);
		session.getTransaction().commit();
		session.close();
		return utpTechnical.getUtpTechnicalPhotoUrl();
	}

	@Override
	public void OtherUpload(String IdCard, StringBuffer savePath) {
		UtpTechnical utpTechnical = Context.getBean(UtpTechnical.class);
		Session session = sf.openSession();
		session.beginTransaction();
		utpTechnical = (UtpTechnical) session.get(UtpTechnical.class, IdCard);
		utpTechnical.setUtpTechnicalPublication(savePath.toString());
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public String FindOtherFile(String IdCard) {
		Session session = sf.openSession();
		session.beginTransaction();
		UtpTechnical utpTechnical = (UtpTechnical) session.get(UtpTechnical.class, IdCard);
		session.getTransaction().commit();
		session.close();
		return utpTechnical.getUtpTechnicalPublication();
	}

	@Override
	public void updateTechnicals(UtpTechnical utpTechnical) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(utpTechnical);
		session.getTransaction().commit();
		session.close();
	}

}
