package com.mizugue.querysale.dto;

import com.mizugue.querysale.projection.SaleSummaryProjection;

public class SummaryDTO {
    private String sellerName;
    private Double total;

    public SummaryDTO() {
    }

    public SummaryDTO(SaleSummaryProjection x) {
        this.sellerName = x.getSellerName();
        this.total = x.getTotal();
    }


    public SummaryDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
