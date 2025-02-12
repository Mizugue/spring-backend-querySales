package com.mizugue.querysale.repositories;


import com.mizugue.querysale.entities.Sale;
import com.mizugue.querysale.projection.SaleReportProjection;
import com.mizugue.querysale.projection.SaleSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(nativeQuery = true, value =
            "SELECT tb_sales.id, tb_sales.date, tb_sales.amount ,tb_seller.name AS sellerName " +
            "FROM tb_sales " +
            "JOIN tb_seller ON tb_sales.seller_id = tb_seller.id " +
            "WHERE tb_sales.date BETWEEN :minDate AND :maxDate " +
            "AND UPPER(tb_seller.name) LIKE UPPER(CONCAT('%',:sellerName, '%'))",
            countQuery = "SELECT COUNT(tb_sales.id) " +
                        "FROM tb_sales " +
                        "JOIN tb_seller ON tb_sales.seller_id = tb_seller.id " +
                        "WHERE tb_sales.date BETWEEN :minDate AND :maxDate " +
                        "AND UPPER(tb_seller.name) LIKE UPPER(CONCAT('%',:sellerName, '%'))")
    Page <SaleReportProjection> findByParams(String minDate, String maxDate, String sellerName, Pageable pageable);



   @Query(nativeQuery = true, value =
            "SELECT SUM(tb_sales.amount) AS total, tb_seller.name AS sellerName " +
            "FROM tb_sales " +
            "JOIN tb_seller ON tb_sales.seller_id = tb_seller.id " +
            "WHERE tb_sales.date BETWEEN :minDate AND :maxDate " +
            "GROUP BY tb_seller.id " +
            "ORDER BY tb_seller.name")
   List<SaleSummaryProjection> salesSummary(String minDate, String maxDate);
}
