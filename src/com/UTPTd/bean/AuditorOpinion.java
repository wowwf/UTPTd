package com.UTPTd.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="utp_comment")
public class AuditorOpinion {
	private Integer num;
	private String auditorId;
	private String teacherId;
	private String opinion;
	private String sumbitTime;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sep")
	@SequenceGenerator(name="sep",sequenceName="utp_user_seq") /*allocationSize=1, initialValue=1, */
	public Integer getNum() {
		return num;
	}
	public String getAuditorId() {
		return auditorId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public String getSumbitTime() {
		return sumbitTime;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public void setSumbitTime(String sumbitTime) {
		this.sumbitTime = sumbitTime;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
}
