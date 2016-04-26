package com.UTPTd.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpHighTeacher;

@Component
public interface UtpHighTeacherDao {
	//添加教师登陆申报人信息
	void InsertHighTeacher(String IdCard, String TearcherName);
	//更新申报人信息
	void UpdateHighTeacher(UtpHighTeacher utpHighTeacher);
	//更新
	void updateHighTeahcers(UtpHighTeacher utpHighTeacher);
	//查找是否有这个人
	UtpHighTeacher FindByHighTeacherIdCard(String IdCard);
	//审核是否通过
	Integer FindIsPassByHighTeacherIdCard(String IdCard);
	//审核是否提交
	Integer FindSubmitByHighTeacherIdCard(String IdCard);
	//第几次审核
	Integer FindWitchSubmitByHighTeacherIdCard(String IdCard);
	//审核没通过
	void UpdateSubmitIsNotPass(String IdCard);
	//院系审核通过或者没通过
	void UpdateWhichSubmit(String IdCard, Integer WhichSubmit);
	//通过最后审核
	void UpdateSubmitIsPass(String IdCard);
	//根据那一次审核筛选出审核名单
	List<UtpHighTeacher> FindByHighTeacherWhichSubmit(Integer whichSubmitInteger);
	//根据第几次审核查询
	List<UtpHighTeacher> FindHighTeacherByWhichSubmit(Integer whichInteger);
	//根据是否通过筛选
	List<UtpHighTeacher> FindByHighTeacherByIsPass(Integer isPassInteger);
	//根据审核查询
	List<UtpHighTeacher> FindHighTeacherByIsPass(Integer isPass);
	//上传一寸照片，保存路径到数据库
	void PersonImgUpload(String IdCard, String savePath);
	//查询用户一寸照片的路径
	String FindPersonImageUrl(String IdCard);
	//上传其他佐证，保存文件名称到数据库
	void OthersUpload(String IdCard, StringBuffer fileName);
	//查询其他佐证的字符串
	String FindOtherFileName(String IdCard);
}
