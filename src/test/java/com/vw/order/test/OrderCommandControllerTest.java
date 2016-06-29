package com.vw.order.test;

import com.vw.order.CommandCreated;
import com.vw.order.CreateOrderCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author firoz
 * @since 29/06/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderCommandControllerTest {

    @LocalServerPort
    private int port;

    @Test
    public void acceptsCreateOrderCommand(){
        CreateOrderCommand createOrderCommand = new CreateOrderCommand();
        RequestEntity<CreateOrderCommand> request = new RequestEntity<CreateOrderCommand>(createOrderCommand, HttpMethod.POST, URI.create("http://localhost:" + this.port + "/orders"));
        ResponseEntity<CommandCreated> response = new TestRestTemplate().exchange(request, CommandCreated.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}
