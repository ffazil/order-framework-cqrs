package com.vw.order;

import lombok.Data;
import lombok.Getter;
import lombok.Value;

/**
 * @author firoz
 * @since 29/06/16
 */
@Getter
public class CreateOrderCommand {

    private final String orderId;

    public CreateOrderCommand(String orderId){
        this.orderId = orderId;
    }

    public CreateOrderCommand(){
        this(null);
    }

}
