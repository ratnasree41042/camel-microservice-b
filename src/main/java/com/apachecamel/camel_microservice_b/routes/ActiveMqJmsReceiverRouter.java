package com.apachecamel.camel_microservice_b.routes;

import com.apachecamel.camel_microservice_b.beans.CurrencyExchange;
import com.apachecamel.camel_microservice_b.processes.MyCurrencyExchangeProcessor;
import com.apachecamel.camel_microservice_b.transforms.MyCurrencyExchangeTransformer;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ActiveMqJmsReceiverRouter extends RouteBuilder {

    private final MyCurrencyExchangeProcessor myCurrencyExchangeProcessor;
    private final MyCurrencyExchangeTransformer myCurrencyExchangeTransformer;

    @Override
    public void configure() throws Exception {

          from("activemq:my-activemq-queue")
                  .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                  .bean(myCurrencyExchangeProcessor)
                  .bean(myCurrencyExchangeTransformer)
                  .to("log:received-message-from-active-mq");
    }
}
