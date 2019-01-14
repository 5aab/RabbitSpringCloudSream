package com.punjab.de.janwar.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TestBindings {

        String TEST_BIND = "test-bind";

        @Input("test-bind")
        SubscribableChannel testBind();

}
