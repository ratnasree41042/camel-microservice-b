package com.apachecamel.camel_microservice_b.beans;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyExchange {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
}
