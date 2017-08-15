package com.broughty.demo.view;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

import static com.broughty.demo.view.DefaultView.VIEW_NAME;

@SpringView(name = VIEW_NAME)
public class DefaultView extends VerticalLayout implements View{
    public static final String VIEW_NAME = "";

    @PostConstruct
    void init() {
        addComponent(new Label("This is the default view"));
    }
}
