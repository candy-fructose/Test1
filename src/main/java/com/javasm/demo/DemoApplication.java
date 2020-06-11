package com.javasm.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*包扫描，扫描dao接口*/
@MapperScan("com.javasm.*.dao")
/*开启事务管理*/
@EnableTransactionManagement


@SpringBootApplication
/*打war包，修改启动类*/
public class DemoApplication/* extends SpringBootServletInitializer*/ {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}*/
}
