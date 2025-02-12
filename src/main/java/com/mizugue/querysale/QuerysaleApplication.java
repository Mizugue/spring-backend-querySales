package com.mizugue.querysale;

import com.mizugue.querysale.entities.Sale;
import com.mizugue.querysale.projection.SaleReportProjection;
import com.mizugue.querysale.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class QuerysaleApplication {


	public static void main(String[] args) {
		SpringApplication.run(QuerysaleApplication.class, args);
	}
}




