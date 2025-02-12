package com.mizugue.querysale.controllers;

import com.mizugue.querysale.dto.ReportDTO;
import com.mizugue.querysale.dto.SummaryDTO;
import com.mizugue.querysale.services.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleServiceImpl service;


	@GetMapping(value = "/report")
	public ResponseEntity<Page<ReportDTO>> getReport(Pageable pageable, @RequestParam(name = "minDate", defaultValue = "") String minDate,
													 @RequestParam(name = "maxDate", defaultValue = "") String maxDate,
													 @RequestParam(name = "name", defaultValue = "") String name) {
		return new ResponseEntity<>(service.findByParams(minDate, maxDate, name, pageable), HttpStatus.OK);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<List<SummaryDTO>> getSummary(@RequestParam(name = "minDate", defaultValue = "") String minDate,
													   @RequestParam(name = "maxDate", defaultValue = "") String maxDate) {
		return new ResponseEntity<>(service.findBySummary(minDate, maxDate), HttpStatus.OK);
	}
}