package com.UTPTd.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.UTPTd.bean.AuditorOpinion;

@Component
public interface UtpOpinionServices {

	//查询观点
	List<AuditorOpinion> findByTidAndAid(Integer Tid);
	
}
