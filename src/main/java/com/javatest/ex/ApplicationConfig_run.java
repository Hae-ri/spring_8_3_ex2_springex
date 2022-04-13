package com.javatest.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("run")
public class ApplicationConfig_run {

	@Bean
	public ServerInfo serverInfo() {
		ServerInfo s_Info = new ServerInfo();
		s_Info.setIpNum("211.5.20.121");
		s_Info.setPortNum("80");
		return s_Info;		
	}
}
