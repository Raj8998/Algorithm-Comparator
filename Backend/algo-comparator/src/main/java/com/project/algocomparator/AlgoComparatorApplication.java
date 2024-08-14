package com.project.algocomparator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource({"file:./src/main/resources/application.properties", "file:./src/main/resources/mysql.properties"})
@ComponentScan(basePackages = {"com.project.algocomparator"})
@EnableScheduling
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
public class AlgoComparatorApplication {

	public static void main(String[] args) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Starting Algorithm Comparator ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		SpringApplication app = new SpringApplication(AlgoComparatorApplication.class);
		app.setBannerMode(Mode.OFF);
		app.run(args);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Started Algorithm Comparator ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
