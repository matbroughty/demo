package com.broughty.demo.app;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@SpringComponent
@UIScope
public class Greeter {

    public String sayHello() {
        return "Hello from bean " + toString();
    }

}
