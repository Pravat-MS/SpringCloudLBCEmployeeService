package com.pravat.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravat.ms.service.AddressRestConsumer;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	@Autowired
	private AddressRestConsumer addressService;
	
	@GetMapping("/getEmployeeAddress")
	public String employeeAddress() {
		return addressService.getAddress();
	}

}
