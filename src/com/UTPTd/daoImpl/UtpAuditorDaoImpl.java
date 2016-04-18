package com.UTPTd.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpAuditor;
import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpAuditorDao;
import com.UTPTd.util.Page;

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

	@Override
	public List<UtpHighTeacher> getList(Page page) {
		String hql = "from UtpHighTeacher as tea where tea.utpHighTeacherWhichSubmit = 0";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult((page.getCurrentPage() - 1) * page.getEveryPage());
		@SuppressWarnings("unchecked")
		List<UtpHighTeacher> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Integer getListCount() {
		String hql = "from UtpHighTeacher as tea where tea.utpHighTeacherWhichSubmit = 0";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		List list = query.list();
		Integer num = list.size();
		session.beginTransaction().commit();
		session.close();
		return num;
	}
	
	@Override
	public List<UtpHighTeacher> getTeachers(Page page) {
		String hql = "from UtpHighTeacher as tea where tea.utpHighTeacherWhichSubmit = 1";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult((page.getCurrentPage() - 1) * page.getEveryPage());
		@SuppressWarnings("unchecked")
		List<UtpHighTeacher> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Integer getTeachersCount() {
		String hql = "from UtpHighTeacher as tea where tea.utpHighTeacherWhichSubmit = 1";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		List list = query.list();
		Integer num = list.size();
		session.beginTransaction().commit();
		session.close();
		return num;
	}
	
	@Override
	public List<UtpTechnical> getTechnicals(Page page) {
		String hql = "from UtpTechnical";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult((page.getCurrentPage() - 1) * page.getEveryPage());
		@SuppressWarnings("unchecked")
		List<UtpTechnical> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Integer getTechnicalsCount() {
		String hql = "from UtpTechnical";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		List list = query.list();
		Integer num = list.size();
		session.beginTransaction().commit();
		session.close();
		return num;
	}
	
	@Override
	public List<UtpHighTeacher> getTeacherLikeName(String Name, Page page) {
		String hql = "from UtpHighTeacher as tea where tea.utpHighTeacherName like :name";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("name", "%" + Name + "%");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult((page.getCurrentPage() - 1) * page.getEveryPage());
		@SuppressWarnings("unchecked")
		List<UtpHighTeacher> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Integer getTeacherLikeNameCount(String Name) {
		String hql = "from UtpHighTeacher as tea where tea.utpHighTeacherName like :name";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("name", "%" + Name + "%");
		List list = query.list();
		Integer num = list.size();
		session.beginTransaction().commit();
		session.close();
		return num;
	}
	
	@Override
	public List<UtpTechnical> getTechnicalLikeName(String Name, Page page) {
		String hql = "from UtpTechnical as tea where tea.utpTechnicalName like :name";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("name", "%" + Name + "%");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult((page.getCurrentPage() - 1) * page.getEveryPage());
		@SuppressWarnings("unchecked")
		List<UtpTechnical> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Integer getTechnicalLikeNameCount(String Name) {
		String hql = "from UtpTechnical as tea where tea.utpTechnicalName like :name";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("name", "%" + Name + "%");
		List list = query.list();
		Integer num = list.size();
		session.beginTransaction().commit();
		session.close();
		return num;
	}
	
	@Override
	public List<UtpHighTeacher> getHighTeacherLikeId(Integer IdCard, Page page) {
		String hql = "from UtpHighTeacher as tea where tea.utpHighTeacherIdCard like :id";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("id", "%" + IdCard + "%");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult((page.getCurrentPage() - 1) * page.getEveryPage());
		@SuppressWarnings("unchecked")
		List<UtpHighTeacher> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Integer getHighTeacherLikeIdCount(Integer IdCard) {
		String hql = "from UtpHighTeacher as tea where tea.utpHighTeacherIdCard like :id";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("id", "%" + IdCard + "%");
		List list = query.list();
		Integer num = list.size();
		session.beginTransaction().commit();
		session.close();
		return num;
	}
	
	@Override
	public List<UtpTechnical> getTechnicalLikeId(Integer IdCard, Page page) {
		String hql = "from UtpTechnical as tea where tea.utpTechnicalIdCard like :id";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("id", "%" + IdCard + "%");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult((page.getCurrentPage() - 1) * page.getEveryPage());
		@SuppressWarnings("unchecked")
		List<UtpTechnical> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Integer getTechnicalLikeIdCount(Integer IdCard) {
		String hql = "from UtpTechnical as tea where tea.utpTechnicalIdCard like :id";
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("id", "%" + IdCard + "%");
		List list = query.list();
		Integer num = list.size();
		session.beginTransaction().commit();
		session.close();
		return num;
	}

}
