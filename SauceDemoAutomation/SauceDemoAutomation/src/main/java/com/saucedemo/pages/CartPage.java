package com.saucedemo.pages;

import com.saucedemo.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver = DriverManager.getDriver();

    private final By backpack = By.xpath("//div[text()='Sauce Labs Backpack']");
    private final By removeBackpack = By.id("remove-sauce-labs-backpack");
    private final By checkout = By.id("checkout");

    public boolean isBackpackDisplayed() {
        return driver.findElement(backpack).isDisplayed();
    }

    public void removeBackpack() {
        driver.findElement(removeBackpack).click();
    }

    public void clickCheckout() {
        driver.findElement(checkout).click();
    }
}
