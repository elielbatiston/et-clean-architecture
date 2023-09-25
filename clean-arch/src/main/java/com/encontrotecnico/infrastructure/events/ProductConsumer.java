package com.encontrotecnico.infrastructure.events;

import com.encontrotecnico.application.create.CreateProductUseCase;
import com.encontrotecnico.application.create.InputCreateProductDTO;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductConsumer {

    private final CreateProductUseCase useCase;

    public ProductConsumer(final CreateProductUseCase useCase) {
        this.useCase = Objects.requireNonNull(useCase);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${encontro.broker.queue.produtoEventQueue.name}", durable = "true"),
            exchange = @Exchange(value = "${encontro.broker.exchange.produtoEventExchange}", type = ExchangeTypes.FANOUT)
    ))
    public void listenUserEvent(@Payload final InputCreateProductEventDTO payload) {
        var input = new InputCreateProductDTO(
                payload.name(),
                payload.price()
        );
        useCase.execute(input);
    }
}
