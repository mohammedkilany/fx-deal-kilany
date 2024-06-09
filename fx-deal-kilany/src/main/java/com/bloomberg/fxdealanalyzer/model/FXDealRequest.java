package com.bloomberg.fxdealanalyzer.model;

import com.bloomberg.fxdealanalyzer.annotation.ValidCurrency;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FXDealRequest {

    @NotNull(message = "Deal Unique ID cannot be null")
    private String dealUniqueId;

    @NotNull(message = "From Currency ISO Code cannot be null")
    @Size(min = 3, max = 3, message = "From Currency ISO Code must be 3 characters")
    @ValidCurrency(message = "Invalid From Currency ISO Code")
    private String fromCurrencyIsoCode;

    @NotNull(message = "From Currency ISO Code cannot be null")
    @Size(min = 3, max = 3, message = "From Currency ISO Code must be 3 characters")
    @ValidCurrency(message = "Invalid From Currency ISO Code")
    private String toCurrencyIsoCode;

    private LocalDateTime dealTimestamp;
    private BigDecimal dealAmount;
}
