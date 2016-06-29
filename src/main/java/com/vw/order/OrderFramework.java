package com.vw.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author firoz
 * @since 29/06/16
 */
@SpringBootApplication
public class OrderFramework {

    public static void main(String... args) {
        ApplicationContext context = SpringApplication.run(OrderFramework.class, args);
    }
}
