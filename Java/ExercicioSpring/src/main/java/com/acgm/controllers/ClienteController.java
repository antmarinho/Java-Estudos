package com.acgm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acgm.model.entities.Cliente;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
	
	@GetMapping(path = "/qualquer")
	public Cliente obterCliente() {
		
		return new Cliente(28,"jose","111-555-999-85");
		
	}
	
	@GetMapping("/{id}")
	public Cliente obterClienteId1(@PathVariable int id) {
		
		return new Cliente(id,"maria","578-956-472-40");
		
	}
	
	@GetMapping
	public Cliente obterClienteId2(@RequestParam(name = "id") int id) {
		
		return new Cliente(id,"jose","452-321-785-56");
		
	}

}
