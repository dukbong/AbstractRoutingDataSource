package com.example.masterslave.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.example.masterslave.enums.DataSourceType;

public class RoutingDataSource extends AbstractRoutingDataSource {
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

	@Override
	protected Object determineCurrentLookupKey() {
		return getDataSourceType();
	}
	
    public static void setDataSourceType(DataSourceType type) {
        contextHolder.set(type.getDataSourceName());
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

}
