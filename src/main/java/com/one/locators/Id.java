package com.one.locators;


import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.id;

public enum Id implements Supplier<By> {

    LOGIN("login-button"),
    LOGOUT("logout_sidebar_link"),
    USERNAME("user-name"),
    PASSWORD("password"),
    INVENTORY_CONTAINER("inventory_container"),
    AddToCartButton("add-to-cart-sauce-labs-backpack"),
    checkoutButton("checkout"),
    FirstName("first-name"),
    LastName("last-name"),
    PostalCode("postal-code"),
    ContinueButton("continue"),
    FinishButton("finish")
   
    ;

    private final By by;

    Id(String id) {
        this.by = id(id);
    }

    @Override
    public By get() {
        return by;
    }

    @Override
    public String toString() {
        return by.toString();
    }
}