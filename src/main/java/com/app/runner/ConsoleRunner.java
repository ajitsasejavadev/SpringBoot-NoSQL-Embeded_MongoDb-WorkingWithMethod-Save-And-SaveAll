package com.app.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.document.Employee;
import com.app.repo.EmployeeRepository;

@Component
public class ConsoleRunner implements CommandLineRunner {


	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {

		repo.deleteAll();

		/** 1. Insert one row ..**/

		Employee e1 =repo.save(new Employee(10,"AA",5.5));
		System.out.println(e1.getId());

		/** 2. Insert Bulk Row..**/

		List<Employee> emps =repo.saveAll(
				Arrays.asList(new Employee(11,"BB",6.5),
						      new Employee(12,"CC",7.5),
						      new Employee(13,"DD",8.5) ));
		for(Employee e2:emps){System.out.println(e2.getId());}

		System.out.println("------------------------DONE----------------------------------");

	}

}
