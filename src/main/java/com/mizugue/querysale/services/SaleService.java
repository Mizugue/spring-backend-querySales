package com.mizugue.querysale.services;

import com.mizugue.querysale.dto.SaleDTO;

public interface SaleService {

    SaleDTO findById(Long id);

}
