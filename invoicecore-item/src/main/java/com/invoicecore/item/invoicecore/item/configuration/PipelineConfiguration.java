package com.invoicecore.item.invoicecore.item.configuration;

import handlers.Handler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pipeline.IPipeline;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PipelineConfiguration {

    @Bean(name = "getItemPipeline")
    public IPipeline getItemPipeline(@Qualifier("getItemHandler") Handler getItemHandler) {
        List<handlers.Handler> handlers = new ArrayList<>();
        handlers.add(getItemHandler);
        return new IPipeline(handlers);
    }

    @Bean(name = "saveItemPipeline")
    public IPipeline saveItemPipeline(@Qualifier("saveItemHandler") Handler saveItemHandler) {
        List<handlers.Handler> handlers = new ArrayList<>();
        handlers.add(saveItemHandler);
        return new IPipeline(handlers);
    }
}
