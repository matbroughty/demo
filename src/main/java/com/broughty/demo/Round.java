package com.broughty.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;

public @Data class Round {

    @Id
    public String id;

    private String number;

}
