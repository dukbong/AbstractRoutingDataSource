package com.example.masterslave.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DataSourceType {

	MASTER("master"),
	SLAVE("slave");
	
	private String dataSourceName;
	
}
