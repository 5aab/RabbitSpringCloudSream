package com.punjab.de.janwar.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of="restaurant")
public class FoodOrder {

    private String restaurant;
    private String customerAddress;
    private String orderDescription;

    @Override
    public int hashCode(){
        return super.hashCode();
    }
}
