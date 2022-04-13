package com.javatest.ex;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("서버 종류를 입력해주세요(dev, run)");
		Scanner scan = new Scanner(System.in);
		String str= scan.next();
		String config = "";
		if(str.equals("dev"))
			config = "dev";
		else
			config = "run";
		
		scan.close();
		
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		//ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		ctx.register(ApplicationConfig_dev.class, ApplicationConfig_run.class);
		ctx.refresh();
		
		ServerInfo s_info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("ip : " + s_info.getIpNum());
		System.out.println("port : " + s_info.getPortNum());
		
		ctx.close();
	}

}
