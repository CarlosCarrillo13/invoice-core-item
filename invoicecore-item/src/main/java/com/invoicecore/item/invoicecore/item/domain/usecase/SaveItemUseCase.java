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
public class SaveItemUseCase implements UseCase {

    private final Pipeline saveItemPipeline;

    @Override
    public void handle(MessageContext messageContext) {

        try {
            saveItemPipeline.execute(messageContext);
        } catch (MessageContextException e) {
            log.error(e.getCause().getMessage());
            e.printStackTrace();
        }
    }
}
