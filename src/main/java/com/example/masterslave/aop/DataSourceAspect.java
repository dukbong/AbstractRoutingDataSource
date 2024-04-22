package com.example.masterslave.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.masterslave.datasource.RoutingDataSource;
import com.example.masterslave.enums.DataSourceType;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class DataSourceAspect {

	@Pointcut("execution(* com.example.masterslave.serviceImpl.*.*(..))")
	public void serviceImplMethods() {
	}

	@Around("serviceImplMethods()")
	public Object setDataSource(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();

		if (methodName.startsWith("get")) {
			log.info("Slave DB Connect..");
			RoutingDataSource.setDataSourceType(DataSourceType.SLAVE);
		} else {
			log.info("Master DB Connect..");
			RoutingDataSource.setDataSourceType(DataSourceType.MASTER);
		}

		try {
			return joinPoint.proceed(); // Proceed with the method execution
		} finally {
			RoutingDataSource.clearDataSourceType(); // Clean up after execution
		}
	}
}
