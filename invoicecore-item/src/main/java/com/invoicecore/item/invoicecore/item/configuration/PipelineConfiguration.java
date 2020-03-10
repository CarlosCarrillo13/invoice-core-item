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
    public IPipeline saveItemPipeline(@Qualifier("saveItemHandler") Handler saveItemHandler,
                                      @Qualifier("getCategoriesHandler") Handler getCategoriesHandler) {
        List<handlers.Handler> handlers = new ArrayList<>();
        handlers.add(getCategoriesHandler);
        handlers.add(saveItemHandler);
        return new IPipeline(handlers);
    }

    @Bean(name = "saveCategoryPipeline")
    public IPipeline saveCategoryPipeline(@Qualifier("saveCategoryHandler") Handler saveCategoryHandler) {
        List<handlers.Handler> handlers = new ArrayList<>();
        handlers.add(saveCategoryHandler);
        return new IPipeline(handlers);
    }


    @Bean(name = "saveSpecPipeline")
    public IPipeline saveSpecPipeline(@Qualifier("saveSpecHandler") Handler saveSpecHandler) {
        List<handlers.Handler> handlers = new ArrayList<>();
        handlers.add(saveSpecHandler);
        return new IPipeline(handlers);
    }
}
