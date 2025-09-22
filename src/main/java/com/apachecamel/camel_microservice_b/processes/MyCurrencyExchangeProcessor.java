package com.apachecamel.camel_microservice_b.processes;

import com.apachecamel.camel_microservice_b.beans.CurrencyExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyCurrencyExchangeProcessor {

    public void process(CurrencyExchange currencyExchange) {
        currencyExchange.getConversionMultiple();
    }

}
