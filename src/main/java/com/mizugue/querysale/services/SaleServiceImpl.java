package com.mizugue.querysale.services;

import com.mizugue.querysale.dto.ReportDTO;
import com.mizugue.querysale.dto.SummaryDTO;
import com.mizugue.querysale.projection.SaleReportProjection;
import com.mizugue.querysale.repositories.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepository repository;

	@Autowired
	private ModelMapper mp;



	public Page <ReportDTO> findByParams(String minDate, String maxDate, String name, Pageable pageable){
		String[] dates = checkDate(minDate, maxDate);
		minDate = dates[0];
		maxDate = dates[1];
        return repository.findByParams(minDate, maxDate, name, pageable)
				.map(x -> mp.map(x, ReportDTO.class));
    }

	@Override
	public List<SummaryDTO> findBySummary(String minDate, String maxDate) {
		String[] dates = checkDate(minDate, maxDate);
		minDate = dates[0];
		maxDate = dates[1];

		return repository.salesSummary(minDate, maxDate).stream().map(x -> mp.map(x,
				SummaryDTO.class)).toList();
	}


	private String[] checkDate(String min, String max){
		if (max.isBlank()){
			max = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()).toString();
		}
		if (min.isBlank()){
			min = LocalDate.parse(max).minusYears(1).toString();
		}
		return new String[]{min, max};
	}


}