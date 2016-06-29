package com.vw.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author firoz
 * @since 29/06/16
 */
@Getter
@AllArgsConstructor
public class OrderCreatedEvent implements OrderEvent{

    private String id;
}
