package com.broughty.demo;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

public @Data
class Game {
    @Id
    public String id;

    List<Round> rounds;
}
