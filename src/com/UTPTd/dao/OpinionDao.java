package com.UTPTd.dao;

import java.util.List;

import com.UTPTd.bean.AuditorOpinion;

public interface OpinionDao {
	//存储评论信息
	void insertMessage(AuditorOpinion aOpinion);
	//查询某一条信息
	List<AuditorOpinion> findOpinion(Integer idCard, Integer AuditorId);
}
