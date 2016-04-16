package com.UTPTd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.dao.UtpHighTeacherDao;

@Component
public class UtpHighTeacherDaoImpl implements UtpHighTeacherDao {
	
	/*private static Configuration configuration = new Configuration().configure();
	private static ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	private static SessionFactory sf = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);*/

	private static ApplicationContext Context = new ClassPathXmlApplicationContext("beans.xml");
	private static SessionFactory sf = (SessionFactory) Context.getBean("sessionfactory");
	
	@Override
	public void InsertHighTeacher(Integer IdCard, String TearcherName) {
		UtpHighTeacher highTeacher = new UtpHighTeacher();
		Session session = sf.openSession();
		session.beginTransaction();
		highTeacher.setUtpHighTeacherIdCard(IdCard);
		highTeacher.setUtpHighTeacherName(TearcherName);
		session.save(highTeacher);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void UpdateHighTeacher(UtpHighTeacher utpHighTeacher) {
		UtpHighTeacher uTeacher = new UtpHighTeacher();
		Session session = sf.openSession();
		session.beginTransaction();
		uTeacher = (UtpHighTeacher) session.get(UtpHighTeacher.class, utpHighTeacher.getUtpHighTeacherIdCard());
		if (utpHighTeacher.getUtpHighTeacherAge() != 0) {
			uTeacher.setUtpHighTeacherAge(utpHighTeacher.getUtpHighTeacherAge());
		}
		uTeacher.setUtpHighTeacherGender(utpHighTeacher.getUtpHighTeacherGender());
		if (!"".equals(utpHighTeacher.getUtpHighTeacherBirthday())) {
			uTeacher.setUtpHighTeacherBirthday(utpHighTeacher.getUtpHighTeacherBirthday());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherCareerBegin())) {
			uTeacher.setUtpHighTeacherCareerBegin(utpHighTeacher.getUtpHighTeacherCareerBegin());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherGraduateTime())) {
			uTeacher.setUtpHighTeacherGraduateTime(utpHighTeacher.getUtpHighTeacherGraduateTime());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherEducation())) {
			uTeacher.setUtpHighTeacherEducation(utpHighTeacher.getUtpHighTeacherEducation());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherCollege())) {
			uTeacher.setUtpHighTeacherCollege(utpHighTeacher.getUtpHighTeacherCollege());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherMajor())) {
			uTeacher.setUtpHighTeacherMajor(utpHighTeacher.getUtpHighTeacherMajor());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherPostNow())) {
			uTeacher.setUtpHighTeacherPostNow(utpHighTeacher.getUtpHighTeacherPostNow());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherDeclarePost())) {
			uTeacher.setUtpHighTeacherDeclarePost(utpHighTeacher.getUtpHighTeacherDeclarePost());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherCET())) {
			uTeacher.setUtpHighTeacherCET(utpHighTeacher.getUtpHighTeacherCET());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherComputer())) {
			uTeacher.setUtpHighTeacherComputer(utpHighTeacher.getUtpHighTeacherComputer());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherAssessment())) {
			uTeacher.setUtpHighTeacherAssessment(utpHighTeacher.getUtpHighTeacherAssessment());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherRefresher())) {
			uTeacher.setUtpHighTeacherRefresher(utpHighTeacher.getUtpHighTeacherRefresher());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherSeniority())) {
			uTeacher.setUtpHighTeacherSeniority(utpHighTeacher.getUtpHighTeacherSeniority());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherTeaching())) {
			uTeacher.setUtpHighTeacherTeaching(utpHighTeacher.getUtpHighTeacherTeaching());
		}
		if (!"".equals(utpHighTeacher.getUtpHighTeacherAcademic())) {
			uTeacher.setUtpHighTeacherAcademic(utpHighTeacher.getUtpHighTeacherAcademic());
		}
		uTeacher.setUtpHighTeacherSubmit(1);
		uTeacher.setUtpHighTeacherIsSubmit(0);
		uTeacher.setUtpHighTeacherWhichSubmit(0);
		session.update(uTeacher);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public UtpHighTeacher FindByHighTeacherIdCard(Integer IdCard) {
		Session session = sf.openSession();
		session.beginTransaction();
		UtpHighTeacher utpHighTeacher = (UtpHighTeacher) session.get(UtpHighTeacher.class, IdCard);
		session.getTransaction().commit();
		session.close();
		return utpHighTeacher;
	}

	@Override
	public Integer FindIsPassByHighTeacherIdCard(Integer IdCard) {
		UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
		UtpHighTeacher utpHighTeacher = new UtpHighTeacher();
		utpHighTeacher = UHTD.FindByHighTeacherIdCard(IdCard);
		return utpHighTeacher.getUtpHighTeacherIsSubmit();
	}

	@Override
	public Integer FindSubmitByHighTeacherIdCard(Integer IdCard) {
		UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
		UtpHighTeacher utpHighTeacher = new UtpHighTeacher();
		utpHighTeacher = UHTD.FindByHighTeacherIdCard(IdCard);
		return utpHighTeacher.getUtpHighTeacherSubmit();
	}

	@Override
	public Integer FindWitchSubmitByHighTeacherIdCard(Integer IdCard) {
		UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
		UtpHighTeacher utpHighTeacher = new UtpHighTeacher();
		utpHighTeacher = UHTD.FindByHighTeacherIdCard(IdCard);
		return utpHighTeacher.getUtpHighTeacherWhichSubmit();
	}

	@Override
	public void UpdateSubmitIsNotPass(Integer IdCard) {
		UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
		UtpHighTeacher utpHighTeacher = new UtpHighTeacher();
		utpHighTeacher = UHTD.FindByHighTeacherIdCard(IdCard);
		utpHighTeacher.setUtpHighTeacherIsSubmit(0);
	}

	@Override
	public void UpdateWhichSubmit(Integer IdCard, Integer WhichSubmit) {
		UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
		UtpHighTeacher utpHighTeacher = new UtpHighTeacher();
		utpHighTeacher = UHTD.FindByHighTeacherIdCard(IdCard);
		switch (WhichSubmit) {
		case 0:
			utpHighTeacher.setUtpHighTeacherWhichSubmit(0);
			UHTD.UpdateHighTeacher(utpHighTeacher);
			break;
		case 1:
			utpHighTeacher.setUtpHighTeacherWhichSubmit(1);
			UHTD.UpdateHighTeacher(utpHighTeacher);
			break;
		case 2:
			utpHighTeacher.setUtpHighTeacherWhichSubmit(2);
			UHTD.UpdateHighTeacher(utpHighTeacher);
			break;
		default:
			System.out.println("出错了！");
			break;
		}
	}

	@Override
	public void UpdateSubmitIsPass(Integer IdCard) {
		UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
		UtpHighTeacher utpHighTeacher = new UtpHighTeacher();
		utpHighTeacher = UHTD.FindByHighTeacherIdCard(IdCard);
		utpHighTeacher.setUtpHighTeacherIsSubmit(1);//审核通过
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(utpHighTeacher);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<UtpHighTeacher> FindByHighTeacherWhichSubmit(Integer WhichSubmit) {
		List<UtpHighTeacher> utpHighTeacher = new ArrayList<UtpHighTeacher>();
		UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
		switch (WhichSubmit) {
		case 0:
			utpHighTeacher = UHTD.FindHighTeacherByWhichSubmit(WhichSubmit);
			break;
		case 1:
			utpHighTeacher = UHTD .FindHighTeacherByWhichSubmit(WhichSubmit);
			break;
		case 2:
			utpHighTeacher = UHTD.FindHighTeacherByWhichSubmit(WhichSubmit);
			break;
		default:
			utpHighTeacher = null;
			System.out.println("数据库无数据！");
			break;
		}
		return utpHighTeacher;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UtpHighTeacher> FindHighTeacherByWhichSubmit(Integer whichInteger) {
		List<UtpHighTeacher> utpHighTeacher = new ArrayList<UtpHighTeacher>();
		String hqlString = "from UtpHighTeacher as utp where utp.UtpHighTeacherWhichSubmit = :which";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hqlString);
		query.setParameter("which", whichInteger);
		utpHighTeacher = query.list();
		session.getTransaction().commit();
		session.close();
		return utpHighTeacher;
	}

	@Override
	public List<UtpHighTeacher> FindHighTeacherByIsPass(Integer isPassInteger) {
		List<UtpHighTeacher> utpHighTeacher = new ArrayList<UtpHighTeacher>();
		UtpHighTeacherDao UHTD = new UtpHighTeacherDaoImpl();
		switch (isPassInteger) {
		case 0:
			utpHighTeacher = UHTD.FindHighTeacherByIsPass(isPassInteger);
			break;
		case 1:
			utpHighTeacher = UHTD.FindHighTeacherByIsPass(isPassInteger);
			break;
		default:
			utpHighTeacher = null;
			System.out.println("数据库中没有数据！");
			break;
		}
		return utpHighTeacher;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UtpHighTeacher> FindByHighTeacherByIsPass(Integer isPassInteger) {
		List<UtpHighTeacher> utpHighTeacher = new ArrayList<UtpHighTeacher>();
		String hqlString = "from UtpHighTeacher as utp where utp.UtpHighTeacherIsSubmit = :isPass";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hqlString);
		query.setParameter("isPass", isPassInteger);
		utpHighTeacher = query.list();
		session.getTransaction().commit();
		session.close();
		return utpHighTeacher;
	}

	@Override
	public void PersonImgUpload(Integer IdCard, String savePath) {
		UtpHighTeacher highTeacher = new UtpHighTeacher();
		Session session = sf.openSession();
		session.beginTransaction();
		highTeacher = (UtpHighTeacher) session.get(UtpHighTeacher.class, IdCard);
		highTeacher.setUtpHighTeacherPhotoUrl(savePath);
		session.update(highTeacher);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public String FindPersonImageUrl(Integer IdCard) {
		UtpHighTeacher highTeacher = new UtpHighTeacher();
		Session session = sf.openSession();
		session.beginTransaction();
		highTeacher = (UtpHighTeacher) session.get(UtpHighTeacher.class, IdCard);
		session.getTransaction().commit();
		session.close();
		return highTeacher.getUtpHighTeacherPhotoUrl();
	}

	@Override
	public void OthersUpload(Integer IdCard, StringBuffer fileName) {
		UtpHighTeacher highTeacher = new UtpHighTeacher();
		Session session = sf.openSession();
		session.beginTransaction();
		highTeacher = (UtpHighTeacher) session.get(UtpHighTeacher.class, IdCard);
		highTeacher.setUtpHighTeacherOther(fileName.toString());
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public String FindOtherFileName(Integer IdCard) {
		UtpHighTeacher highTeacher = new UtpHighTeacher();
		Session session = sf.openSession();
		session.beginTransaction();
		highTeacher = (UtpHighTeacher) session.get(UtpHighTeacher.class, IdCard);
		session.getTransaction().commit();
		session.close();
		return highTeacher.getUtpHighTeacherOther();
	}

}
