package com.wipro.bed2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages={"com.wipro.bed2"})
@EntityScan(basePackages={"com.wipro.bed2.entity"}) 
//@EnableJpaRepositories(basePackages={"com.wipro.bed2.dao"})
@SpringBootApplication
public class BED2MainClass {

	public static void main(String[] args) {
		SpringApplication.run(BED2MainClass.class, args);

	}

}
