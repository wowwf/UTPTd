package com.UTPTd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "utp_Auditor")
public class UtpAuditor {
	private String UtpAuditorIdCard;
	private String UtpAuditorName;
	private String UtpAuditorPassword;
	private Integer UtpAuditorRole;//0.院系	1.人事
	@Id
	@Column(unique = true)
	public String getUtpAuditorIdCard() {
		return UtpAuditorIdCard;
	}
	public String getUtpAuditorName() {
		return UtpAuditorName;
	}
	public String getUtpAuditorPassword() {
		return UtpAuditorPassword;
	}
	public Integer getUtpAuditorRole() {
		return UtpAuditorRole;
	}
	public void setUtpAuditorIdCard(String utpAuditorIdCard) {
		UtpAuditorIdCard = utpAuditorIdCard;
	}
	public void setUtpAuditorName(String utpAuditorName) {
		UtpAuditorName = utpAuditorName;
	}
	public void setUtpAuditorPassword(String utpAuditorPassword) {
		UtpAuditorPassword = utpAuditorPassword;
	}
	public void setUtpAuditorRole(Integer utpAuditorRole) {
		UtpAuditorRole = utpAuditorRole;
	}
	
}
