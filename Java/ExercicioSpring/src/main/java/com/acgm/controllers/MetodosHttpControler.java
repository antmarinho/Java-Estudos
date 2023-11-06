package com.acgm.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/metodos")
public class MetodosHttpControler {
	
	@GetMapping
	public String get() {
		
		return "requisicao get";
		
	}
	
	@PostMapping
	public String post() {
		
		return "requisicao post";
		
	}

	@PutMapping
	public String put() {
	
	return "requisicao put";
	
	}
	
	@PatchMapping
	public String patch() {
		
		return "requisicao patch";
		
	}

	@DeleteMapping
	public String delete() {
		
		return "requisicao delete";
		
	}

}
