package com.apachecamel.camel_microservice_b.transforms;

import com.apachecamel.camel_microservice_b.beans.CurrencyExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class MyCurrencyExchangeTransformer {
    public CurrencyExchange transform(CurrencyExchange currencyExchange) {
        currencyExchange.setConversionMultiple(
                currencyExchange.getConversionMultiple().multiply(BigDecimal.TEN));
        return currencyExchange;
    }
}
