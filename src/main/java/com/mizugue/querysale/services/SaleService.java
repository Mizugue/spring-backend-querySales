package com.mizugue.querysale.services;

import com.mizugue.querysale.dto.ReportDTO;
import com.mizugue.querysale.dto.SummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleService {

    Page <ReportDTO> findByParams(String minDate, String maxDate, String name, Pageable pageable);
    List<SummaryDTO> findBySummary(String minDate, String maxDate);

}
