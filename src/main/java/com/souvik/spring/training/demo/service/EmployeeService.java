package com.souvik.spring.training.demo.service;

import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.souvik.spring.training.demo.model.Employee;

import ch.qos.logback.classic.Logger;

@Service
public class EmployeeService {

private static final org.slf4j.Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
		
		
		public List<Employee> getAllEmployees() {
			RestTemplate restTemplate = new RestTemplate();
			List<Employee> employeeList = new ArrayList<Employee>();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<Employee[]> response = restTemplate.exchange("http://localhost:8080/list", HttpMethod.GET, requestEntity,Employee[].class);
			Employee[] employees = response.getBody();
			employeeList = Arrays.asList(employees);
			for (Employee emp : employees) {
				log.info(emp.toString());
			}
			return employeeList;
		}
		
		
		public void addEmployee(Employee employee) {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForEntity("http://localhost:8080/employee", employee, Employee[].class);
		}

	}
}
