package com.online.nhy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author GodzillaHua
 **/
@Configuration
public class MyBatisConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("1qaz@WSX");
		dataSource.setUrl("jdbc:mysql://192.168.56.183:3306/eshop?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8");
		dataSource.setMaxActive(50);
		dataSource.setMinIdle(10);
		dataSource.setTestOnBorrow(false);
		dataSource.setTestOnReturn(false);
		dataSource.setTestWhileIdle(true);
		dataSource.setValidationQuery("select 1");
		dataSource.setTimeBetweenEvictionRunsMillis(30000);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		transactionManager.afterPropertiesSet();
		return transactionManager;
	}

	@Bean
	public SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(environment.getProperty("mybatis.mapper.locations", "classpath:mappers/**/*.xml")));
		sqlSessionFactoryBean.afterPropertiesSet();
		sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		return sqlSessionFactoryBean.getObject();
	}

}
