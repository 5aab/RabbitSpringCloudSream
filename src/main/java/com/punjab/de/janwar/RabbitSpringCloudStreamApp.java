package com.punjab.de.janwar;

import com.punjab.de.janwar.config.TestBindings;
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

@AllArgsConstructor
@ComponentScan
@EnableBinding({Processor.class,TestBindings.class})
@Slf4j
@SpringBootApplication
public class RabbitSpringCloudStreamApp extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(RabbitSpringCloudStreamApp.class, args);
    }

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
        return springApplicationBuilder.sources(RabbitSpringCloudStreamApp.class);
    }

    @StreamListener(target = Processor.INPUT)
    public void processCheapMeals(String meal){
        System.out.println("This was a great meal!: "+meal);
    }

    @StreamListener(target = "test-bind")
    public void processCheapMeals2(String meal){
        System.out.println("This was a great meal!: "+meal);
    }

}
