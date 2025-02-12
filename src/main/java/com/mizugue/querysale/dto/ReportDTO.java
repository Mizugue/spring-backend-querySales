package com.mizugue.querysale.dto;

import com.mizugue.querysale.projection.SaleReportProjection;
import com.mizugue.querysale.projection.SaleSummaryProjection;

import java.time.LocalDate;

public class ReportDTO {
    private Long id;
    private LocalDate date;
    private Double amount;
    private String sellerName;

    public ReportDTO(Long id, LocalDate date, Double amount, String sellerName) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.sellerName = sellerName;
    }

    public ReportDTO() {
    }

    public ReportDTO(SaleReportProjection x) {
        this.id = x.getId();
        this.date = x.getDate();
        this.amount = x.getAmount();
        this.sellerName = x.getSellerName();
    }


    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setId(Long  id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
