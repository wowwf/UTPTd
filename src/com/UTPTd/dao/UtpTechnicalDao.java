package com.UTPTd.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.UTPTd.bean.UtpTechnical;

@Component
public interface UtpTechnicalDao {
	//添加教师登陆申报人信息
	void InsertTechnical(Integer IdCard, String TechnicalName);
	//更新申报人信息
	void UpdateTechnical(UtpTechnical utpTechnical);
	//更新状态
	void updateTechnicals(UtpTechnical utpTechnical);
	//查找是否有这个人
	UtpTechnical FindByTechnicalIdCard(Integer IdCard);
	//审核是否通过
	Integer FindIsPassByTechnicalIdCard(Integer IdCard);
	//审核是否提交
	Integer FindSubmitByTechnicalIdCard(Integer IdCard);
	//第几次审核
	Integer FindWhichSubmitByTechnicalIdCard(Integer IdCard);
	//审核没通过
	void UpdateTechnicalSubmitIsNotPass(Integer IdCard);
	//通过审核
	void UpdateTechnicalSubmitIsPass(Integer IdCard);
	//列出所有没有通过审核的人员信息或者所有通过审核的名单
	List<UtpTechnical> FindAllByUtpTechnicalIsPass(Integer isPassInteger);
	//根据是否通过查询
	List<UtpTechnical> FindUtpTechnicalByIsPass(Integer isPassInteger);
	//上传一寸照片，保存路径
	void PersonImgUpload(Integer IdCard, String savePath);
	//查找一寸照片的路径
	String FindPersonImgUrl(Integer IdCard);
	//论文著作相关路径存储
	void OtherUpload(Integer IdCard, StringBuffer savePath);
	//查找论文相关路径
	String FindOtherFile(Integer IdCard);
}
