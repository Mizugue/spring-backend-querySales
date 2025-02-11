package com.mizugue.querysale.dto;

import com.mizugue.querysale.entities.Sale;

import java.time.LocalDate;

public class SaleDTO {

	private Long id;
	private Double amount;
	private LocalDate date;

	public SaleDTO(Long id, Double amount, LocalDate date) {
		this.id = id;
		this.amount = amount;
		this.date = date;
	}

	public SaleDTO(Sale entity) {
		id = entity.getId();
		amount = entity.getAmount();
		date = entity.getDate();
	}

	public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}
}