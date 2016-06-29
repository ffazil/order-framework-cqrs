package com.vw.order;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.domain.DefaultIdentifierFactory;
import org.axonframework.domain.IdentifierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author firoz
 * @since 29/06/16
 */
@Slf4j
@RestController
public class OrderCommandController {

    private final IdentifierFactory identifierFactory = new DefaultIdentifierFactory();
    private CommandGateway commandGateway;

    @Autowired
    public OrderCommandController(){
        this.commandGateway = commandGateway;
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommandCreated> createOrder(@RequestBody CreateOrderCommand createOrderCommand){
        if(createOrderCommand.getOrderId() == null)
            createOrderCommand = new CreateOrderCommand(identifierFactory.generateIdentifier());
        this.commandGateway.send(createOrderCommand);

        return new ResponseEntity<CommandCreated>(new CommandCreated(), HttpStatus.CREATED);
    }
}
