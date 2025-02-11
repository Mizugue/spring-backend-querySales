package com.mizugue.querysale.controllers;

import com.mizugue.querysale.dto.SaleDTO;
import com.mizugue.querysale.services.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleServiceImpl service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleDTO> findById(@PathVariable Long id) {
		SaleDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<?> getReport() {
		// TODO
		return null;
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<?> getSummary() {
		// TODO
		return null;
	}
}