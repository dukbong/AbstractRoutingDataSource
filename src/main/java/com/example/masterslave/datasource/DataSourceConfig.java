package com.example.masterslave.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.masterslave.enums.DataSourceType;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

	@Value("${spring.datasource.master.url}")
	private String masterUrl;
	@Value("${spring.datasource.master.username}")
	private String masterUsername;
	@Value("${spring.datasource.master.password}")
	private String masterPassword;
	@Value("${spring.datasource.slave.url}")
	private String slaveUrl;
	@Value("${spring.datasource.slave.username}")
	private String slaveUsername;
	@Value("${spring.datasource.slave.password}")
	private String slavePassword;
	private final int poolSize = 10;

	@Bean
	@Primary
	public DataSource masterDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(masterUrl);
		config.setUsername(masterUsername);
		config.setPassword(masterPassword);
		config.setMaximumPoolSize(poolSize);
		return new HikariDataSource(config);
	}

	@Bean
	public DataSource slaveDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(slaveUrl);
		config.setUsername(slaveUsername);
		config.setPassword(slavePassword);
		config.setMaximumPoolSize(poolSize);
		return new HikariDataSource(config);
	}

	@Bean
	public DataSource routingDataSource(DataSource master, @Qualifier("slaveDataSource") DataSource slave) {
		RoutingDataSource routingDataSource = new RoutingDataSource();
		Map<Object, Object> dataSources = new HashMap<>();
		dataSources.put(DataSourceType.MASTER, master);
		dataSources.put(DataSourceType.SLAVE, slave);
		routingDataSource.setTargetDataSources(dataSources);
		routingDataSource.setDefaultTargetDataSource(master);
		return routingDataSource;
	}
}
