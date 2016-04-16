package com.UTPTd.util;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class DataDao {
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
