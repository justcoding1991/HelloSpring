package com.newspring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.newspring")
public class DatasourceConfig {
	
	@Bean
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource  ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	

}
