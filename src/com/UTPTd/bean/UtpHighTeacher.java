package com.UTPTd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "utp_HighTeacher")
public class UtpHighTeacher {
	private String UtpHighTeacherIdCard;
	private String UtpHighTeacherName;
	private String UtpHighTeacherGender;
	private Integer UtpHighTeacherAge;
	private String utpHighTeacherBirthday;
	private String UtpHighTeacherCareerBegin;
	private String UtpHighTeacherGraduateTime;
	private String UtpHighTeacherEducation;  
	private String UtpHighTeacherCollege;
	private String UtpHighTeacherMajor;    
	private String UtpHighTeacherPostNow;
	private String UtpHighTeacherDeclarePost;
	private String UtpHighTeacherCET;
	private String UtpHighTeacherComputer;
	private String UtpHighTeacherAssessment;
	private String UtpHighTeacherPhotoUrl;
	private String UtpHighTeacherRefresher;
	private String UtpHighTeacherSeniority;
	private String UtpHighTeacherTeaching;
	private String UtpHighTeacherAcademic;
	private String UtpHighTeacherOther;
	private Integer UtpHighTeacherSubmit;//1.提交|0.未提交	
	private Integer UtpHighTeacherIsSubmit;//1.通过审核|0.未通过审核   
	private Integer UtpHighTeacherWhichSubmit;//0.默认值|1。院系审核|2。人事审核
	@Id
	@Column(unique = true)
	public String getUtpHighTeacherIdCard() {
		return UtpHighTeacherIdCard;
	}
	public String getUtpHighTeacherName() {
		return UtpHighTeacherName;
	}
	public String getUtpHighTeacherGender() {
		return UtpHighTeacherGender;
	}
	public Integer getUtpHighTeacherAge() {
		return UtpHighTeacherAge;
	}
	public String getUtpHighTeacherBirthday() {
		return utpHighTeacherBirthday;
	}
	public String getUtpHighTeacherCareerBegin() {
		return UtpHighTeacherCareerBegin;
	}
	public String getUtpHighTeacherGraduateTime() {
		return UtpHighTeacherGraduateTime;
	}
	public String getUtpHighTeacherEducation() {
		return UtpHighTeacherEducation;
	}
	public String getUtpHighTeacherCollege() {
		return UtpHighTeacherCollege;
	}
	public String getUtpHighTeacherMajor() {
		return UtpHighTeacherMajor;
	}
	public String getUtpHighTeacherPostNow() {
		return UtpHighTeacherPostNow;
	}
	public String getUtpHighTeacherDeclarePost() {
		return UtpHighTeacherDeclarePost;
	}
	public String getUtpHighTeacherCET() {
		return UtpHighTeacherCET;
	}
	public String getUtpHighTeacherComputer() {
		return UtpHighTeacherComputer;
	}
	public String getUtpHighTeacherAssessment() {
		return UtpHighTeacherAssessment;
	}
	public String getUtpHighTeacherPhotoUrl() {
		return UtpHighTeacherPhotoUrl;
	}
	public String getUtpHighTeacherRefresher() {
		return UtpHighTeacherRefresher;
	}
	public String getUtpHighTeacherSeniority() {
		return UtpHighTeacherSeniority;
	}
	public String getUtpHighTeacherTeaching() {
		return UtpHighTeacherTeaching;
	}
	public String getUtpHighTeacherAcademic() {
		return UtpHighTeacherAcademic;
	}
	public String getUtpHighTeacherOther() {
		return UtpHighTeacherOther;
	}
	@Column(columnDefinition = "Integer default 0")
	public Integer getUtpHighTeacherSubmit() {
		return UtpHighTeacherSubmit;
	}
	@Column(columnDefinition = "Integer default 0")
	public Integer getUtpHighTeacherIsSubmit() {
		return UtpHighTeacherIsSubmit;
	}
	@Column(columnDefinition = "Integer default 0")
	public Integer getUtpHighTeacherWhichSubmit() {
		return UtpHighTeacherWhichSubmit;
	}
	public void setUtpHighTeacherIdCard(String utpHighTeacherIdCard) {
		UtpHighTeacherIdCard = utpHighTeacherIdCard;
	}
	public void setUtpHighTeacherName(String utpHighTeacherName) {
		UtpHighTeacherName = utpHighTeacherName;
	}
	public void setUtpHighTeacherGender(String utpHighTeacherGender) {
		UtpHighTeacherGender = utpHighTeacherGender;
	}
	public void setUtpHighTeacherAge(Integer utpHighTeacherAge) {
		UtpHighTeacherAge = utpHighTeacherAge;
	}
	public void setUtpHighTeacherBirthday(String utpHighTeacherBirthday) {
		this.utpHighTeacherBirthday = utpHighTeacherBirthday;
	}
	public void setUtpHighTeacherCareerBegin(String utpHighTeacherCareerBegin) {
		UtpHighTeacherCareerBegin = utpHighTeacherCareerBegin;
	}
	public void setUtpHighTeacherGraduateTime(String utpHighTeacherGraduateTime) {
		UtpHighTeacherGraduateTime = utpHighTeacherGraduateTime;
	}
	public void setUtpHighTeacherEducation(String utpHighTeacherEducation) {
		UtpHighTeacherEducation = utpHighTeacherEducation;
	}
	public void setUtpHighTeacherCollege(String utpHighTeacherCollege) {
		UtpHighTeacherCollege = utpHighTeacherCollege;
	}
	public void setUtpHighTeacherMajor(String utpHighTeacherMajor) {
		UtpHighTeacherMajor = utpHighTeacherMajor;
	}
	public void setUtpHighTeacherPostNow(String utpHighTeacherPostNow) {
		UtpHighTeacherPostNow = utpHighTeacherPostNow;
	}
	public void setUtpHighTeacherDeclarePost(String utpHighTeacherDeclarePost) {
		UtpHighTeacherDeclarePost = utpHighTeacherDeclarePost;
	}
	public void setUtpHighTeacherCET(String utpHighTeacherCET) {
		UtpHighTeacherCET = utpHighTeacherCET;
	}
	public void setUtpHighTeacherComputer(String utpHighTeacherComputer) {
		UtpHighTeacherComputer = utpHighTeacherComputer;
	}
	public void setUtpHighTeacherAssessment(String utpHighTeacherAssessment) {
		UtpHighTeacherAssessment = utpHighTeacherAssessment;
	}
	public void setUtpHighTeacherPhotoUrl(String utpHighTeacherPhotoUrl) {
		UtpHighTeacherPhotoUrl = utpHighTeacherPhotoUrl;
	}
	public void setUtpHighTeacherRefresher(String utpHighTeacherRefresher) {
		UtpHighTeacherRefresher = utpHighTeacherRefresher;
	}
	public void setUtpHighTeacherSeniority(String utpHighTeacherSeniority) {
		UtpHighTeacherSeniority = utpHighTeacherSeniority;
	}
	public void setUtpHighTeacherTeaching(String utpHighTeacherTeaching) {
		UtpHighTeacherTeaching = utpHighTeacherTeaching;
	}
	public void setUtpHighTeacherAcademic(String utpHighTeacherAcademic) {
		UtpHighTeacherAcademic = utpHighTeacherAcademic;
	}
	public void setUtpHighTeacherOther(String utpHighTeacherOther) {
		UtpHighTeacherOther = utpHighTeacherOther;
	}
	public void setUtpHighTeacherSubmit(Integer utpHighTeacherSubmit) {
		UtpHighTeacherSubmit = utpHighTeacherSubmit;
	}
	public void setUtpHighTeacherIsSubmit(Integer utpHighTeacherIsSubmit) {
		UtpHighTeacherIsSubmit = utpHighTeacherIsSubmit;
	}
	public void setUtpHighTeacherWhichSubmit(Integer utpHighTeacherWhichSubmit) {
		UtpHighTeacherWhichSubmit = utpHighTeacherWhichSubmit;
	}
}
