package com.punjab.de.janwar;

import com.punjab.de.janwar.config.TestBindings;
import com.punjab.de.janwar.domain.FoodOrder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.IdempotentReceiver;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@AllArgsConstructor
@ComponentScan
@EnableBinding({Processor.class,TestBindings.class})
@Slf4j
@SpringBootApplication
@EnableIntegration
@EnableTransactionManagement
public class RabbitSpringCloudStreamApp extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(RabbitSpringCloudStreamApp.class, args);
    }

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
        return springApplicationBuilder.sources(RabbitSpringCloudStreamApp.class);
    }

    @StreamListener(target = Processor.INPUT)
    @IdempotentReceiver("idempotentReceiverInterceptor")
    public void processCheapMeals(FoodOrder meal, @Header("restaurant") String header, @Header("amqp_redelivered") boolean redelivered){
        System.out.println("Header: "+header+" "+redelivered);
        System.out.println("This was a great meal 1!: "+meal);
    }

    @StreamListener(target = "test-bind")
    public void processCheapMeals2(String meal){
        System.out.println("This was a great meal 2test!: "+meal);
    }



}
