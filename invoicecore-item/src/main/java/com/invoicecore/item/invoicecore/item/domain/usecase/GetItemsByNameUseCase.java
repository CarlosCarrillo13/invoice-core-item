package com.invoicecore.item.invoicecore.item.domain.usecase;

import UseCases.UseCase;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pipeline.Pipeline;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetItemsByNameUseCase implements UseCase {

    private final Pipeline getItemsByNamePipeline;

    @Override
    public void handle(MessageContext messageContext) {
        try {
            getItemsByNamePipeline.execute(messageContext);
        } catch (MessageContextException e) {
            e.printStackTrace();
        }
    }
}
