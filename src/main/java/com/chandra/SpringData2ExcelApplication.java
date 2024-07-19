package com.chandra;

import com.chandra.service.CourseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringData2ExcelApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext cntxt=SpringApplication.run(SpringData2ExcelApplication.class, args);
		CourseService cs=cntxt.getBean(CourseService.class);
		//cs.saveCourse();
	}

}
