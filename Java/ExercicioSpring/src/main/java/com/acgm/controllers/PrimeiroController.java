package com.acgm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	//@RequestMapping(method = RequestMethod.GET, path = "/ola")
	//@GetMapping(path = "/ola")
	@GetMapping(path = {"/ola", "/saudacao"})
	public String ola() {
		
		return "ola spring boot";
		
	}

}
