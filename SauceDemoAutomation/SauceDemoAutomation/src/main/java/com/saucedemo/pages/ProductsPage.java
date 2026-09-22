package com.saucedemo.pages;

import com.saucedemo.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private final WebDriver driver = DriverManager.getDriver();

    private final By productsTitle = By.cssSelector(".title");
    private final By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cart = By.className("shopping_cart_link");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logout = By.id("logout_sidebar_link");

    public String getProductsTitle() {
        return driver.findElement(productsTitle).getText();
    }

    public void addBackpackToCart() {
        driver.findElement(backpack).click();
    }

    public void openCart() {
        driver.findElement(cart).click();
    }

    public void logout() {
        driver.findElement(menuButton).click();
        driver.findElement(logout).click();
    }
}
