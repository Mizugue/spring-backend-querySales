package com.mizugue.querysale.projection;

import javax.xml.crypto.Data;
import java.time.LocalDate;

public interface SaleReportProjection {

    Long getId();
    LocalDate getDate();
    Double getAmount();
    String getSellerName();

}
