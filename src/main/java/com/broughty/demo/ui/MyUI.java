package com.broughty.demo.ui;

import com.broughty.demo.app.Customer;
import com.broughty.demo.app.CustomerService;
import com.broughty.demo.view.UIScopedView;
import com.broughty.demo.view.ViewScopedView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Theme(value = "valo")
@SpringUI(path = "")
@SpringViewDisplay
public class MyUI extends UI implements ViewDisplay{
    private Panel springViewDisplay;
    @Autowired
    CustomerService customerService;

    private Grid<Customer> grid = new Grid<>(Customer.class);

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();

        root.addComponent(grid);
        grid.setColumns("firstName", "lastName", "email");
        getSomeData();

        setContent(root);

        final CssLayout navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        navigationBar.addComponent(createNavigationButton("Eh View Scoped View",
                ViewScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("UI Scoped View",
                UIScopedView.VIEW_NAME));
        root.addComponent(navigationBar);



        springViewDisplay = new Panel();
        springViewDisplay.setSizeFull();
        root.addComponent(springViewDisplay);
        root.setExpandRatio(springViewDisplay, 1.0f);

    }

    private void getSomeData() {
        // fetch list of Customers from service and assign it to Grid
        List<Customer> customers = customerService.findAll();
        grid.setItems(customers);
    }

    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        // If you didn't choose Java 8 when creating the project, convert this
        // to an anonymous listener class
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }

    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component) view);
    }
}