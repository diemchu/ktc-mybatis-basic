package com.example.crud_mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudMybatisApplication.class, args);
		Student student = new Student();
		student.setName("Alex");
		student.setEmail("alex@gmail.com");
		student.setPhone("010-9999-2222");
		System.out.println(student);
	}

}
