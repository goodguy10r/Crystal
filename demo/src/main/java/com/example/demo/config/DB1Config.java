package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages="com.example.demo", annotationClass=Mapper.class, sqlSessionFactoryRef="sqlSessionFactory1")
@EnableTransactionManagement
public class DB1Config {

	@Bean(name="dataSource1")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="sqlSessionFactory1")
	public SqlSessionFactory sqlSessionFactory1(@Qualifier("dataSource1") DataSource dataSource1, ApplicationContext applicationContext) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource1);
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="sqlSessionTemplate1")
	public SqlSessionTemplate sqlSessionTemplate1(SqlSessionFactory sqlSessionFactory1) throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory1);
	}
	
}
