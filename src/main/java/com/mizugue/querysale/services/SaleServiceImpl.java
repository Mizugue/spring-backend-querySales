package com.mizugue.querysale.services;

import com.mizugue.querysale.dto.SaleDTO;
import com.mizugue.querysale.entities.Sale;
import com.mizugue.querysale.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepository repository;

	public SaleDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleDTO(entity);
	}
}