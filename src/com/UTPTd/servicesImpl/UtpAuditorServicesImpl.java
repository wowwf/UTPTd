package com.UTPTd.servicesImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpHighTeacher;
import com.UTPTd.bean.UtpTechnical;
import com.UTPTd.dao.UtpAuditorDao;
import com.UTPTd.daoImpl.UtpAuditorDaoImpl;
import com.UTPTd.services.UTPAuditorServices;
import com.UTPTd.util.Page;
import com.UTPTd.util.PageResult;
import com.UTPTd.util.PageUtil;

@Component
public class UtpAuditorServicesImpl implements UTPAuditorServices {
	
	private static ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
	
	private static UtpAuditorDao UAD = aContext.getBean(UtpAuditorDaoImpl.class);
	
	@Override
	public boolean FindByIdAndRole(Integer IdCard) {
		if (UAD.FindById(IdCard) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean FindPassword(Integer IdCard, Integer Role, String Password) {
		String psdString = UAD.FindPsdById(IdCard);
		Integer roleInteger = UAD.FindRoleById(IdCard);
		if (Password.equals(psdString) && Role == roleInteger) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public PageResult QueryTeacher(Page page) {
		UtpAuditorDao uDao = aContext.getBean(UtpAuditorDaoImpl.class);
		//根据总记录数创建分页信息
		page = PageUtil.createPage(page.getEveryPage(), uDao.getListCount(), page.getCurrentPage());
		//查询未通过院系审核总记录
		List<UtpHighTeacher> utpHighTeachers = uDao.getList(page);
		//封装分页信息和记录信息，返回给调用处
		PageResult result = new PageResult(page, utpHighTeachers);
		return result;
	}

	@Override
	public PageResult QueryTeachers(Page page) {
		UtpAuditorDao uDao = aContext.getBean(UtpAuditorDaoImpl.class);
		page = PageUtil.createPage(page.getEveryPage(), uDao.getTeachersCount(), page.getCurrentPage());
		List<UtpHighTeacher> utpHighTeachers = uDao.getTeachers(page);
		PageResult result = new PageResult(page, utpHighTeachers);
		return result;
	}

	@Override
	public PageResult QueryTechnical(Page page) {
		UtpAuditorDao uDao = aContext.getBean(UtpAuditorDaoImpl.class);
		page = PageUtil.createPage(page.getEveryPage(), uDao.getTechnicalsCount(), page.getCurrentPage());
		List<UtpTechnical> technicals = uDao.getTechnicals(page);
		PageResult result = new PageResult(page, technicals);
		return result;
	}

	@Override
	public PageResult LikeQueryTeacher(String Name, Page page) {
		UtpAuditorDao uDao = aContext.getBean(UtpAuditorDaoImpl.class);
		page = PageUtil.createPage(page.getEveryPage(), uDao.getTeacherLikeNameCount(Name), page.getCurrentPage());
		List<UtpHighTeacher> utpHighTeachers = uDao.getTeacherLikeName(Name, page);
		PageResult result = new PageResult(page, utpHighTeachers);
		return result;
	}

	@Override
	public PageResult LikeQueryTeacherById(Integer IdCard, Page page) {
		UtpAuditorDao uDao = aContext.getBean(UtpAuditorDaoImpl.class);
		page = PageUtil.createPage(page.getEveryPage(), uDao.getHighTeacherLikeIdCount(IdCard), page.getCurrentPage());
		List<UtpHighTeacher> utpHighTeachers = uDao.getHighTeacherLikeId(IdCard, page);
		PageResult result = new PageResult(page, utpHighTeachers);
		return result;
	}

	@Override
	public PageResult LikeQueryTechnical(String Name, Page page) {
		UtpAuditorDao uDao = aContext.getBean(UtpAuditorDaoImpl.class);
		page = PageUtil.createPage(page.getEveryPage(), uDao.getTechnicalLikeNameCount(Name), page.getCurrentPage());
		List<UtpTechnical> utpTechnicals = uDao.getTechnicalLikeName(Name, page);
		PageResult result = new PageResult(page, utpTechnicals);
		return result;
	}

	@Override
	public PageResult LikeQueryTechnicalById(Integer IdCard, Page page) {
		UtpAuditorDao uDao = aContext.getBean(UtpAuditorDaoImpl.class);
		page = PageUtil.createPage(page.getEveryPage(), uDao.getTechnicalLikeIdCount(IdCard), page.getCurrentPage());
		List<UtpTechnical> utpTechnicals = uDao.getTechnicalLikeId(IdCard, page);
		PageResult result = new PageResult(page, utpTechnicals);
		return result;
	}

	@Override
	public boolean isRegiest(Integer iD, String uName) {
		UtpAuditorDao uDao = aContext.getBean(UtpAuditorDaoImpl.class);
		if (uDao.SelectByIdName(iD, uName) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void doResetPass(Integer iD, String Name, String passWord) {
		UtpAuditorDao uDao = aContext.getBean(UtpAuditorDaoImpl.class);
		uDao.updatePassByIdName(iD, Name, passWord);
	}
	
}
