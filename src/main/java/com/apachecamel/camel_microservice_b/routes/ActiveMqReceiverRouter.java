package com.apachecamel.camel_microservice_b.routes;

import com.apachecamel.camel_microservice_b.beans.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

          from("activemq:my-activemq-queue")
                  .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                  .to("log:received-message-from-active-mq");
    }
}
