package com.punjab.de.janwar.service;

import com.punjab.de.janwar.domain.FoodOrder;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@EnableBinding(FoodOrderSource.class)
public class FoodOrderController {

    private FoodOrderSource foodOrderSource;

    @PostMapping("/order")
    @ResponseBody
    public String orderFood(@RequestBody FoodOrder foodOrder){
        foodOrderSource.foodOrders().send(MessageBuilder.withPayload(foodOrder).build());
        System.out.println(foodOrder.toString());
        return "food ordered!";
    }
}
