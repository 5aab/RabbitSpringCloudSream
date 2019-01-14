package com.punjab.de.janwar.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface FoodOrderSource {

    @Output("foodOrdersChannel")
    MessageChannel foodOrders();

}
