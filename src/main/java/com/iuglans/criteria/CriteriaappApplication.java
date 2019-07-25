package com.iuglans.criteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.iuglans"})
@EntityScan("com.iuglans.criteria.model")
@EnableJpaRepositories("com.iuglans.repository")
public class CriteriaappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriteriaappApplication.class, args);
	}

}

