package com.vw.order.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vw.order.CreateOrderCommand;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author firoz
 * @since 29/06/16
 */
@Slf4j
public class CreateOrderCommandTest {

    private ObjectMapper objectMapper;

    @Before
    public void setUp(){
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void serializesToJSON() throws JsonProcessingException {
        CreateOrderCommand createOrderCommand = new CreateOrderCommand();
        String json = objectMapper.writeValueAsString(createOrderCommand);
        log.info(json);
        Assert.assertNotNull(json);
    }
}
