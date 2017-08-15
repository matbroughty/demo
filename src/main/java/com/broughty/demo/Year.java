package com.broughty.demo;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.logging.Level;

@Log
public @Data
class Year {

    @Id
    public String id;

    private List<Game> games;

    private void someMethod(){

        log.log(Level.SEVERE,games.get(0).getRounds().get(0).toString() );


    }
}
