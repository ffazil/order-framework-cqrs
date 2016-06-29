package com.vw.order;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.domain.DefaultIdentifierFactory;
import org.axonframework.domain.IdentifierFactory;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

/**
 * @author firoz
 * @since 29/06/16
 */
@Slf4j
public class OrderAggregate extends AbstractAnnotatedAggregateRoot<String>{

    private final IdentifierFactory identifierFactory = new DefaultIdentifierFactory();

    @AggregateIdentifier
    private String id;

    private OrderStatus orderStatus;

    public OrderAggregate(){
        this(null);
    }

    public OrderAggregate(String id){
        apply(new OrderCreatedEvent(id));
    }

    @EventHandler
    void on(OrderCreatedEvent event){
        if(event.getId() == null)
            this.id = identifierFactory.generateIdentifier();
        else
            this.id = event.getId();
        this.orderStatus = OrderStatus.AWAITING_PAYMENT;
    }


}
