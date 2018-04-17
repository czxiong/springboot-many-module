package com.smm;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启注解事务管理
public class SmmwebApplication {

	public static void main(String[] args) {
		//原生启动方式
		//SpringApplication.run(SmmwebApplication.class, args);
		/**
		 * 隐藏banner启动方式
		 */
		SpringApplication springApplication = new SpringApplication(SmmwebApplication.class);
		//设置banner的模式为隐藏
		springApplication.setBannerMode(Banner.Mode.OFF);
		//启动springboot应用程序
		springApplication.run(args);
	}
}
