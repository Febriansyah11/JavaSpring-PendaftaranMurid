package com.enigmacamp.db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.enigmacamp.db.services.MuridServices;
import com.enigmacamp.db.services.impl.MuridServicesDummyImpl;

@Configuration
public class DaoSpringConfig {
	@Bean
	public MuridServices muridService() {
		return new MuridServicesDummyImpl();
	}
}
