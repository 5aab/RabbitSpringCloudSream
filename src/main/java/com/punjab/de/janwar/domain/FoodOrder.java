package com.punjab.de.janwar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class FoodOrder {

    private String restaurant;
    private String customerAddress;
    private String orderDescription;
}
