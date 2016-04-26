package com.UTPTd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "utp_Technical")
public class UtpTechnical {
	private String UtpTechnicalIdCard;
	private String UtpTechnicalName;
	private String UtpTechnicalGender;
	private Integer UtpTechnicalAge;
	private String UtpTechnicalBirthday;
	private String UtpTechnicalCareerBegin;
	private String UtpTechnicalGraduateTime;
	private String UtpTechnicalEducation;
	private String UtpTechnicalCollege;
	private String UtpTechnicalMajor;
	private String UtpTechnicalPostNow;
	private String UtpTechnicalDeclarePost;
	private String UtpTechnicalCET;
	private String UtpTechnicalComputer;
	private String UtpTechnicalAssessment;
	private String UtpTechnicalPhotoUrl;
	private String UtpTechnicalSeniority;
	private String UtpTechnicalAchievement;
	private String UtpTechnicalResearch;
	private String UtpTechnicalPublication;
	private Integer UtpTechnicalSubmit;//1|0
	private Integer UtpTechnicalIsSubmit;//1|0
	private Integer UtpTechnicalCountSubmit;//default 1
	@Id
	@Column(unique = true)
	public String getUtpTechnicalIdCard() {
		return UtpTechnicalIdCard;
	}
	public String getUtpTechnicalName() {
		return UtpTechnicalName;
	}
	public String getUtpTechnicalGender() {
		return UtpTechnicalGender;
	}
	public Integer getUtpTechnicalAge() {
		return UtpTechnicalAge;
	}
	public String getUtpTechnicalBirthday() {
		return UtpTechnicalBirthday;
	}
	public String getUtpTechnicalCareerBegin() {
		return UtpTechnicalCareerBegin;
	}
	public String getUtpTechnicalGraduateTime() {
		return UtpTechnicalGraduateTime;
	}
	public String getUtpTechnicalEducation() {
		return UtpTechnicalEducation;
	}
	public String getUtpTechnicalCollege() {
		return UtpTechnicalCollege;
	}
	public String getUtpTechnicalMajor() {
		return UtpTechnicalMajor;
	}
	public String getUtpTechnicalPostNow() {
		return UtpTechnicalPostNow;
	}
	public String getUtpTechnicalDeclarePost() {
		return UtpTechnicalDeclarePost;
	}
	public String getUtpTechnicalCET() {
		return UtpTechnicalCET;
	}
	public String getUtpTechnicalComputer() {
		return UtpTechnicalComputer;
	}
	public String getUtpTechnicalAssessment() {
		return UtpTechnicalAssessment;
	}
	public String getUtpTechnicalPhotoUrl() {
		return UtpTechnicalPhotoUrl;
	}
	public String getUtpTechnicalSeniority() {
		return UtpTechnicalSeniority;
	}
	public String getUtpTechnicalAchievement() {
		return UtpTechnicalAchievement;
	}
	public String getUtpTechnicalResearch() {
		return UtpTechnicalResearch;
	}
	public String getUtpTechnicalPublication() {
		return UtpTechnicalPublication;
	}
	@Column(columnDefinition = "Integer default 0")
	public Integer getUtpTechnicalSubmit() {
		return UtpTechnicalSubmit;
	}
	@Column(columnDefinition = "Integer default 0")
	public Integer getUtpTechnicalIsSubmit() {
		return UtpTechnicalIsSubmit;
	}
	@Column(columnDefinition = "Integer default 1")
	public Integer getUtpTechnicalCountSubmit() {
		return UtpTechnicalCountSubmit;
	}
	public void setUtpTechnicalIdCard(String utpTechnicalIdCard) {
		UtpTechnicalIdCard = utpTechnicalIdCard;
	}
	public void setUtpTechnicalName(String utpTechnicalName) {
		UtpTechnicalName = utpTechnicalName;
	}
	public void setUtpTechnicalGender(String utpTechnicalGender) {
		UtpTechnicalGender = utpTechnicalGender;
	}
	public void setUtpTechnicalAge(Integer utpTechnicalAge) {
		UtpTechnicalAge = utpTechnicalAge;
	}
	public void setUtpTechnicalBirthday(String utpTechnicalBirthday) {
		UtpTechnicalBirthday = utpTechnicalBirthday;
	}
	public void setUtpTechnicalCareerBegin(String utpTechnicalCareerBegin) {
		UtpTechnicalCareerBegin = utpTechnicalCareerBegin;
	}
	public void setUtpTechnicalGraduateTime(String utpTechnicalGraduateTime) {
		UtpTechnicalGraduateTime = utpTechnicalGraduateTime;
	}
	public void setUtpTechnicalEducation(String utpTechnicalEducation) {
		UtpTechnicalEducation = utpTechnicalEducation;
	}
	public void setUtpTechnicalCollege(String utpTechnicalCollege) {
		UtpTechnicalCollege = utpTechnicalCollege;
	}
	public void setUtpTechnicalMajor(String utpTechnicalMajor) {
		UtpTechnicalMajor = utpTechnicalMajor;
	}
	public void setUtpTechnicalPostNow(String utpTechnicalPostNow) {
		UtpTechnicalPostNow = utpTechnicalPostNow;
	}
	public void setUtpTechnicalDeclarePost(String utpTechnicalDeclarePost) {
		UtpTechnicalDeclarePost = utpTechnicalDeclarePost;
	}
	public void setUtpTechnicalCET(String utpTechnicalCET) {
		UtpTechnicalCET = utpTechnicalCET;
	}
	public void setUtpTechnicalComputer(String utpTechnicalComputer) {
		UtpTechnicalComputer = utpTechnicalComputer;
	}
	public void setUtpTechnicalAssessment(String utpTechnicalAssessment) {
		UtpTechnicalAssessment = utpTechnicalAssessment;
	}
	public void setUtpTechnicalPhotoUrl(String utpTechnicalPhotoUrl) {
		UtpTechnicalPhotoUrl = utpTechnicalPhotoUrl;
	}
	public void setUtpTechnicalSeniority(String utpTechnicalSeniority) {
		UtpTechnicalSeniority = utpTechnicalSeniority;
	}
	public void setUtpTechnicalAchievement(String utpTechnicalAchievement) {
		UtpTechnicalAchievement = utpTechnicalAchievement;
	}
	public void setUtpTechnicalResearch(String utpTechnicalResearch) {
		UtpTechnicalResearch = utpTechnicalResearch;
	}
	public void setUtpTechnicalPublication(String utpTechnicalPublication) {
		UtpTechnicalPublication = utpTechnicalPublication;
	}
	public void setUtpTechnicalSubmit(Integer utpTechnicalSubmit) {
		UtpTechnicalSubmit = utpTechnicalSubmit;
	}
	public void setUtpTechnicalIsSubmit(Integer utpTechnicalIsSubmit) {
		UtpTechnicalIsSubmit = utpTechnicalIsSubmit;
	}
	public void setUtpTechnicalCountSubmit(Integer utpTechnicalCountSubmit) {
		UtpTechnicalCountSubmit = utpTechnicalCountSubmit;
	}
}
