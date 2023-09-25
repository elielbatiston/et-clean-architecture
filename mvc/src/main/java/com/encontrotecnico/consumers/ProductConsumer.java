package com.encontrotecnico.consumers;

import com.encontrotecnico.controllers.ProdutoDTO;
import com.encontrotecnico.repositories.models.ProdutoEntity;
import com.encontrotecnico.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
public class ProductConsumer {

    @Autowired
    private ProdutoService service;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${encontro.broker.queue.produtoEventQueue.name}", durable = "true"),
            exchange = @Exchange(value = "${encontro.broker.exchange.produtoEventExchange}", type = ExchangeTypes.FANOUT)
    ))
    public void listenUserEvent(@Payload @Validated ProdutoDTO produto) {
        service.save(ProdutoEntity.toDomain(produto));
    }
}
